SECTION = "kernel"
AUTHOR = "Harald Welte <laforge@openmoko.org>"
HOMEPAGE = "http://www.openmoko.org"
LICENSE = "GPL"
DEPENDS += "u-boot-mkimage-openmoko-native"

inherit kernel

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/linux-openmoko"
DEFCONFIG = "defconfig-${VANILLA_VERSION}-${MACHINE}"

##############################################################
# source and patches
#
SRCREV_FORMAT = "patches"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${VANILLA_VERSION}.tar.bz2 \
           file://${DEFCONFIG} \
           file://logo_linux_clut224.ppm"
S = "${WORKDIR}/linux-${VANILLA_VERSION}"

##############################################################
# kernel image resides on a seperate flash partition (for now)
#
FILES_kernel-image = ""
ALLOW_EMPTY = "1"

COMPATIBLE_HOST = "arm.*-linux"
COMPATIBLE_MACHINE = 'fic-gta01|fic-gta02'

CMDLINE = "unused -- bootloader passes ATAG list"

###############################################################
# module configs specific to this kernel
#

# usb
module_autoload_ohci-hcd = "ohci-hcd"
module_autoload_hci_usb = "hci_usb"
module_autoload_g_ether = "g_ether"
# audio
module_autoload_snd-soc-neo1973-wm8753 = "snd-soc-neo1973-wm8753"
# sd/mmc
module_autoload_s3cmci = "s3cmci"

do_prepatch() {
	mv ${WORKDIR}/patches ${S}/patches && cd ${S} && quilt push -av
	mv patches patches.openmoko
	mv .pc .pc.old
}

do_configure() {
	install -m 0644 ${WORKDIR}/logo_linux_clut224.ppm drivers/video/logo/logo_linux_clut224.ppm

	if [ ! -e ${WORKDIR}/${DEFCONFIG} ]; then
		die "No default configuration for ${MACHINE} available."
	fi

	echo "CONFIG_CMDLINE=\"${CMDLINE}\"" >> ${S}/.config

	if [ "${TARGET_OS}" = "linux-gnueabi" ]; then
		echo "CONFIG_AEABI=y"                   >> ${S}/.config
		echo "CONFIG_OABI_COMPAT=y"             >> ${S}/.config
	else 
		echo "# CONFIG_AEABI is not set"        >> ${S}/.config
		echo "# CONFIG_OABI_COMPAT is not set"  >> ${S}/.config
	fi

	sed -e '/CONFIG_AEABI/d' \
	    -e '/CONFIG_OABI_COMPAT=/d' \
	    -e '/CONFIG_CMDLINE=/d' \
	    -e '/CONFIG_MTD_MTDRAM_SA1100=/d' \
	    -e '/CONFIG_MTDRAM_TOTAL_SIZE=/d' \
	    -e '/CONFIG_MTDRAM_ERASE_SIZE=/d' \
	    -e '/CONFIG_MTDRAM_ABS_POS=/d' \
	    '${WORKDIR}/${DEFCONFIG}' >>'${S}/.config'

	yes '' | oe_runmake oldconfig
}

###############################################################
# put into deploy directory and append u-boot header
#
do_deploy() {
	install -d ${DEPLOY_DIR_IMAGE}
	install -m 0644 arch/${ARCH}/boot/${KERNEL_IMAGETYPE} ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-${PV}-${PR}-${MACHINE}.bin
	tar -cvzf ${DEPLOY_DIR_IMAGE}/modules-${KERNEL_RELEASE}-${PR}-${MACHINE}.tgz -C ${D} lib
	${OBJCOPY} -O binary -R .note -R .comment -S vmlinux linux.bin
	rm -f linux.bin.gz
	gzip -9 linux.bin
	${STAGING_BINDIR_NATIVE}/uboot-mkimage -A arm -O linux -T kernel -C gzip -a 30008000 -e 30008000 -n "OpenMoko Kernel Image Neo1973(GTA01)" -d linux.bin.gz ${DEPLOY_DIR_IMAGE}/uImage-${PV}-${PR}-${MACHINE}.bin
	ln -sf ${DEPLOY_DIR_IMAGE}/uImage-${PV}-${PR}-${MACHINE}.bin ${DEPLOY_DIR_IMAGE}/uImage-${MACHINE}-latest.bin
	rm -f linux.bin.gz
}

do_deploy[dirs] = "${S}"

addtask prepatch before do_patch after do_unpack
addtask deploy before do_package after do_install
