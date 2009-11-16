DESCRIPTION = "Additional plugins for Enigma2"
MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>"

SRCDATE = "20091103"

PACKAGES_DYNAMIC = "enigma2-plugin-*"

REL_MAJOR="2"
REL_MINOR="6"

# if you want a 2.6-based release, use
TAG = ";tag=${PN}_rel${REL_MAJOR}${REL_MINOR}"

# if you want experimental, use:
#TAG = ""

PV = "${REL_MAJOR}.${REL_MINOR}cvs${SRCDATE}"

SRC_URI = "cvs://anonymous@cvs.schwerkraft.elitedvb.net/cvsroot/enigma2-plugins;module=enigma2-plugins;method=pserver${TAG};date=${SRCDATE}"

FILES_${PN} += " /usr/share/enigma2 /usr/share/fonts "
FILES_${PN}-meta = "${datadir}/meta"
PACKAGES += "${PN}-meta"

inherit autotools

S = "${WORKDIR}/enigma2-plugins"

DEPENDS = "${@get_version_depends(bb, d)}"
DEPENDS += "enigma2"

def get_version_depends(bb, d):
	if bb.data.getVar('REL_MINOR', d, 1) > '4':
		return "python-pyopenssl python-gdata"
	return ""

python populate_packages_prepend () {
	enigma2_plugindir = bb.data.expand('${libdir}/enigma2/python/Plugins', d)

	do_split_packages(d, enigma2_plugindir, '(.*?/.*?)/.*', 'enigma2-plugin-%s', 'Enigma2 Plugin: %s', recursive=True, match_path=True, prepend=True)

	def getControlLines(mydir, d, package):
		import os
		try:
			src = open(mydir + package + "/CONTROL/control").read()
		except IOError:
			return
		for line in src.split("\n"):
			if line.startswith('Package: '):
				full_package = line[9:]
			if line.startswith('Depends: '):
				bb.data.setVar('RDEPENDS_' + full_package, ' '.join(line[9:].split(', ')), d)
			if line.startswith('Description: '):
				bb.data.setVar('DESCRIPTION_' + full_package, line[13:], d)

	mydir = bb.data.getVar('D', d, 1) + "/../enigma2-plugins/"
	for package in bb.data.getVar('PACKAGES', d, 1).split():
		getControlLines(mydir, d, package.split('-')[-1])
}
