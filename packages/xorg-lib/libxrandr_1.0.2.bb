SECTION = "x11/libs"
LICENSE = "BSD-X"
DEPENDS = "randrext virtual/libx11 libxrender libxext"
DESCRIPTION = "X Resize and Rotate extension library."
PR = "r1"

SRC_URI = "${XLIBS_MIRROR}/libXrandr-${PV}.tar.bz2 \
	   file://autofoo.patch;patch=1"
S = "${WORKDIR}/libXrandr-${PV}"

inherit autotools pkgconfig 

do_stage() {
	autotools_stage_all
}