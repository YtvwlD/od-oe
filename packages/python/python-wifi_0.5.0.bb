DESCRIPTION = "Fusil is a Python library used to write fuzzing programs."
HOMEPAGE = "http://fusil.hachoir.org/"
SECTION = "devel/python"
LICENSE = "GPLv2"
SRCNAME = "python-wifi"
DEPENDS = "python-native"
RDEPENDS = "python-ctypes python-datetime"
PROVIDES = "python-wifi"
PR = "r1"

SRC_URI = "http://download.berlios.de/pythonwifi/${SRCNAME}-${PV}.tar.bz2"
S = "${WORKDIR}/${SRCNAME}-${PV}"

PACKAGES = "python-wifi"

inherit distutils-base

do_install() {
	install -d ${D}${libdir}/${PYTHON_DIR}
	install -d ${D}${libdir}/${PYTHON_DIR}/site-packages/
	install -d ${D}${libdir}/${PYTHON_DIR}/site-packages/pythonwifi/
	for file in pythonwifi/*.py
	do
		install -m 0755 ${file} ${D}${libdir}/${PYTHON_DIR}/site-packages/pythonwifi/
	done
}

