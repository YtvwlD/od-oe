require ${PN}.inc

FILE_PR = "r0"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/noncore/applets/networkapplet \
	   ${HANDHELDS_CVS};tag=${TAG};module=opie/pics"