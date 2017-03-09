DESCRIPTION = "Zlib Compression Library"
SECTION = "libs"
PRIORITY = "required"
MAINTAINER = "Henning Heinold <heinold@inf.fu-berlin.de>"
HOMEPAGE = "http://www.gzip.org/zlib/"
LICENSE = "zlib"
PR="r1"

SRC_URI = "https://downloads.sourceforge.net/project/libpng/zlib/1.2.3/zlib-1.2.3.tar.bz2?r=https%3A%2F%2Fsourceforge.net%2Fprojects%2Flibpng%2Ffiles%2Fzlib%2F1.2.3%2F&ts=1489052050 \
		file://visibility.patch;patch=1 \
		file://autotools.patch;patch=1 "

S = "${WORKDIR}/zlib-${PV}"

DEPENDS = "libtool-cross"

inherit autotools

do_stage() {
	install -m 0644 zlib.h ${STAGING_INCDIR}/zlib.h
	install -m 0644 zconf.h ${STAGING_INCDIR}/zconf.h
	oe_libinstall -a -so libz ${STAGING_LIBDIR}
}

do_install() {
	install -d ${D}${prefix} ${D}${includedir} ${D}${libdir}
	oe_runmake "prefix=${D}${prefix}" \
		   "exec_prefix=${D}${exec_prefix}" \
		   "man3dir=${D}${mandir}/man3" \
		   "includedir=${D}${includedir}" \
		   "libdir=${D}${libdir}" install
}
