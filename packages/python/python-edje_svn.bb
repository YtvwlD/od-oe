require python-efl.inc
DEPENDS += "edje python-evas"
RDEPENDS += "python-evas"
PV = "0.3.0+svnr${SRCREV}"
FILE_PR = "r0"

SRC_URI += "file://0001-fix-unicode-conversion.patch;patch=1"