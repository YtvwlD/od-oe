require xorg-lib-common.inc

DESCRIPTION = "X Display Manager Control Protocol library"
DEPENDS += "xproto"
PROVIDES = "xdmcp"
FILE_PR = "r1"
PE = "1"

XORG_PN = "libXdmcp"