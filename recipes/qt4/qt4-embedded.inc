SUMMARY = "Qt is a versatile cross-platform application framework -- this is the embedded version."
SECTION = "libs"
LICENSE = "LGPLv2.1 GPLv3"
PRIORITY = "optional"
HOMEPAGE = "https://qt.nokia.com/"
DEPENDS += "directfb tslib"
INC_PR = "r33"

QT_BASE_NAME ?= "qt4-embedded"
QT_BASE_LIB  ?= "libqt-embedded"
QT_DIR_NAME = "qtopia"
QT_LIBINFIX = "E"

SRC_URI = "http://get.qt.nokia.com/qt/source/qt-embedded-linux-opensource-src-${PV}.tar.bz2 \
           file://0001-cross-compile.patch;patch=1 \
           file://0002-fix-resinit-declaration.patch;patch=1 \
           file://0003-no-tools.patch;patch=1 \
           file://0004-no-qmake.patch;patch=1 \
           file://0006-freetype-host-includes.patch;patch=1 \
           file://0007-openssl-host-includes.patch;patch=1 \
           file://0008-qt-lib-infix.patch;patch=1 \
           file://0009-support-2bpp.patch;patch=1 \
           file://fix-config-tests.patch;patch=1 \
           file://g++.conf \
           file://linux.conf \
           "

# Set necessary variables in the profile
SRC_URI += "file://qte.sh"

S = "${WORKDIR}/qt-embedded-linux-opensource-src-${PV}"

QT_CONFIG_FLAGS += " \
    -qtlibinfix ${QT_LIBINFIX} \
    -plugin-gfx-transformed -plugin-gfx-qvfb -plugin-gfx-vnc -plugin-gfx-directfb \
    -plugin-mouse-tslib -qt-mouse-pc -qt-mouse-qvfb -qt-mouse-linuxinput \
    -qt-kbd-tty -qt-kbd-linuxinput \
    -DQT_KEYPAD_NAVIGATION \
    "

require qt4.inc

do_install_append() {
	install -d ${D}${sysconfdir}/profile.d/
	install -m 0755 ${WORKDIR}/qte.sh ${D}${sysconfdir}/profile.d/
}

FILES_${PN} += " ${sysconfdir}/profile.d/qte.sh"

inherit qt4e
