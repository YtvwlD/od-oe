DESCRIPTION = "writes dreambox nand flash images to flash"
SECTION = "console/utils"
LICENSE = "GPL"

PV="1.0"
SRC_URI = "git://git.opendreambox.org/git/writenfi.git;protocol=git"

SRCREV = "a86f920b388acfe76c77f24515dbbbd2a7bef5eb"
S = "${WORKDIR}/git"

inherit autotools
