DESCRIPTION = "An HTTP library implementation in C"
SECTION = "x11/gnome/libs"
LICENSE = "GPL"
DEPENDS = "glib-2.0 gnutls libxml2"

inherit autotools

SRC_URI = "${GNOME_MIRROR}/libsoup/${@'.'.join((bb.data.getVar('PV', d, 1)).split('.')[:2])}/libsoup-${PV}.tar.bz2"
S = "${WORKDIR}/libsoup-${PV}"

AUTOTOOLS_STAGE_PKGCONFIG = "1"

do_stage() {
	autotools_stage_all
}

EXTRA_OECONF_opendreambox += "--without-gnome"

FILES_${PN} = "${libdir}/lib*.so.*"
FILES_${PN}-dev = "${includedir}/ ${libdir}/"
FILES_${PN}-doc = "${datadir}/"
