
DESCRIPTION = "iSCSI Enterprise Target is for building an iSCSI storage system on Linux"
HOMEPAGE = "http://iscsitarget.sourceforge.net/"
LICENSE = "GPL"
FILE_PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/iscsitarget/iscsitarget-${PV}.tar.gz \
	   file://libs.patch;patch=1 \
	   file://init \
		"

DEPENDS = " openssl"
S = "${WORKDIR}/iscsitarget-${PV}"

inherit module

do_configure() {
}

CFLAGS  = "-isystem${STAGING_KERNEL_DIR}/include -I${STAGING_INCDIR} -L${STAGING_LIBDIR}"
LDFLAGS = "-L${STAGING_LIBDIR}"
FILES_${PN} += " ${base_sbindir}"

do_compile() {
	oe_runmake KSRC=${STAGING_KERNEL_DIR} CFLAGS='${CFLAGS}' LDFLAGS='${LDFLAGS}'
}

do_install() {
	# Module
	install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/iscsi
	install -m 0644 kernel/iscsi_trgt.ko ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/iscsi/iscsi_trgt.ko

	# Userspace utilities
	install -d ${D}${base_sbindir}
        install -m 0755 usr/ietd ${D}${base_sbindir}/ietd
        install -m 0755 usr/ietadm ${D}${base_sbindir}/ietadm

	# Config files, init scripts
	mkdir -p ${D}${sysconfdir}/init.d
	install -m 0755 ../init ${D}${sysconfdir}/init.d/iscsi-target
	install -m 0644 etc/initiators.allow ${D}${sysconfdir}/
	install -m 0644 etc/initiators.deny ${D}${sysconfdir}/
}