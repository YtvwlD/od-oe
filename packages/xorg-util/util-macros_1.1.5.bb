require xorg-util-common.inc

DESCRIPTION = "X autotools macros"
FILE_PR = "r1"
PE = "1"

SRC_URI += "file://unbreak_cross_compile.patch;patch=1"