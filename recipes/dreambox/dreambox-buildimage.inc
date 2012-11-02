DESCRIPTION = "create Dreambox NAND boot images"
SECTION = "console/utils"
LICENSE = "GPL"

PV="1.4"
SRC_URI = "git://git.opendreambox.org/git/buildimage.git;protocol=git"

SRCREV = "7b3b94efd09d49330fe46521c6c8afb5445dbfc4"
S = "${WORKDIR}/git"

inherit autotools

