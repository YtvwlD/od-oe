DESCRIPTION = "Skins for Enigma2"
MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>"

PACKAGES_DYNAMIC = "enigma2-skin-*"

SRCREV="bab18de12856222a13abe8ab3856cfe1ceb1572e"
SRCDATE="20101206"
BRANCH="3.0"
PV = "3.0-git${SRCDATE}"

PR = "r0"
SRC_URI="git://schwerkraft.elitedvb.net/enigma2-skins/enigma2-skins.git;protocol=git;branch=${BRANCH};tag=${SRCREV}"

FILES_${PN} += " /usr/share/enigma2 /usr/share/fonts "
FILES_${PN}-meta = "${datadir}/meta"
PACKAGES += "${PN}-meta"
PACKAGE_ARCH = "all"

inherit autotools

S = "${WORKDIR}/git"

python populate_packages_prepend () {
	enigma2_skindir = bb.data.expand('${datadir}/enigma2', d)

	do_split_packages(d, enigma2_skindir, '(.*?)/.*', 'enigma2-skin-%s', 'Enigma2 Skin: %s', recursive=True, match_path=True, prepend=True)
}

python populate_packages_append () {
	enigma2_skindir = bb.data.expand('${datadir}/enigma2', d)

	#clear rdepends by default
	for package in bb.data.getVar('PACKAGES', d, 1).split():
		bb.data.setVar('RDEPENDS_' + package, '', d)

	#todo add support for control files in skindir.. like plugins
}
