DESCRIPTION = "The Enlightenment freedesktop.org library"
DEPENDS = "ecore"
LICENSE = "MIT BSD"
PV = "0.0.3.042+cvs${SRCDATE}"
PR = "r0"

inherit efl_library

PACKAGES =+ "${PN}-mime"
FILES_${PN}-mime = "${libdir}/libefreet_mime.so.*"
