require ${PN}.inc

FILE_PR = "r0"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/core/applets/multikeyapplet \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/apps"