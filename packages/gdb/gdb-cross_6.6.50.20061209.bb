LICENSE = "GPL"
DESCRIPTION = "gdb - GNU debugger"
SECTION = "base"
PRIORITY = "optional"
MAINTAINER = "Phil Blundell <pb@nexus.co.uk>"
DEPENDS = "ncurses-native"

inherit autotools sdk

S = "${WORKDIR}/gdb-${PV}"
SRC_URI = "http://sources-redhat.oc1.mirrors.redwire.net/gdb/snapshots/current/gdb-${PV}.tar.bz2"

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/gdb-${PV}"

export CC_FOR_BUILD = "${BUILD_CC}"
export CXX_FOR_BUILD = "${BUILD_CXX}"
export CPP_FOR_BUILD = "${BUILD_CPP}"
export CFLAGS_FOR_BUILD = "${BUILD_CFLAGS}"
export CXXFLAGS_FOR_BUILD = "${BUILD_CXXFLAGS}"
export CPPFLAGS_FOR_BUILD = "${BUILD_CPPFLAGS}"

EXTRA_OEMAKE = "'SUBDIRS=intl mmalloc libiberty opcodes bfd sim gdb etc utils' LDFLAGS='${BUILD_LDFLAGS}'"

EXTRA_OECONF = "--with-curses --with-readline --disable-werror"

do_configure () {
# override this function to avoid the autoconf/automake/aclocal/autoheader
# calls for now
	gnu-configize
	oe_runconf
}

do_stage() {
	oe_runmake 'DESTDIR=${CROSS_DIR}' install
	cp -pPR ${CROSS_DIR}${prefix}/* ${CROSS_DIR}
	rm -rf ${CROSS_DIR}${prefix}
}