DESCRIPTION = "DBus and HAL convenience wrappers for EFL"
DEPENDS = "dbus ecore efreet ewl"
LICENSE = "MIT BSD"
PV = "0.1.0.042+cvs${SRCDATE}"
PR = "r0"

inherit efl

SRC_URI = "${E_CVS};module=e17/libs/e_dbus"
S = "${WORKDIR}/e_dbus"

EXTRA_OECONF = "--enable-build-test-gui"

PACKAGES =+ "${PN}-enotify ${PN}-edbus ${PN}-enm ${PN}-ehal ${PN}-test-gui"
FILES_${PN}-enotify = "${libdir}/libenotify.so.*"
FILES_${PN}-edbus = "${libdir}/libedbus.so.*"
FILES_${PN}-enm = "${libdir}/libenm.so.*"
FILES_${PN}-ehal = "${libdir}/libehal.so.*"
FILES_${PN}-test-gui = "${bindir}/e_dbus_hal"