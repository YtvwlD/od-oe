DESCRIPTION = "Dreambox second stage bootloader"
SECTION = "base"
PRIORITY = "required"
MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>"
PV = "84"
PV_dm7020hd = "87"
PV_dm7025 = "83"
PR = "r0"

DEPENDS = "dreambox-buildimage dreambox-writenfi"

RDEPENDS_${PN} = "dreambox-bootlogo (>= 7.0) dreambox-buildimage dreambox-writenfi"

SRC_URI = "http://sources.dreamboxupdate.com/download/7020/secondstage-${MACHINE}-${PV}.bin"

S = "${WORKDIR}"

do_stage() {
	install -d ${STAGING_LIBDIR}/dreambox-secondstage
	cp ${S}/secondstage-${MACHINE}-${PV}.bin ${STAGING_LIBDIR}/dreambox-secondstage/main.bin.gz
}

do_install() {
	install -d ${D}/tmp
	install ${S}/secondstage-${MACHINE}-${PV}.bin ${D}/tmp/secondstage-${MACHINE}-${PV}.raw
}

FILES_${PN} = "/tmp"
PACKAGE_ARCH := "${MACHINE_ARCH}"

pkg_postinst() {
	if [ -d /proc/stb ]; then
		buildimage $(writenfi --buildimage-params /tmp/secondstage-${MACHINE}-${PV}.raw) -d:/dev/null -d:/dev/null > /tmp/secondstage.nfi
		writenfi /tmp/secondstage.nfi
		rm /tmp/secondstage.nfi
	fi
}
