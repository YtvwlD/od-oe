DESCRIPTION = "writes dreambox nand flash images to flash"
SECTION = "console/utils"
LICENSE = "GPL"

PV="1.1"
SRC_URI = "git://git.opendreambox.org/git/writenfi.git;protocol=git"

SRCREV = "62d5d878c16dd524a17c04251f4a51ed0d7572ed"
S = "${WORKDIR}/git"

inherit autotools
