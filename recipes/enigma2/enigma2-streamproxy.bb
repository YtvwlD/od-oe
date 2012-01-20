DESCRIPTION = "streamproxy manages streaming data to a PC using enigma2"
MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>"

SRCDATE = "20111030"
PV = "1.0git${SRCDATE}"
SRCREV="b927ed8498a41a77e965abad099eb01dc5fef562"

SRC_URI = "git://schwerkraft.elitedvb.net/streamproxy/streamproxy.git;protocol=git;tag=${SRCREV}"

inherit autotools

S = "${WORKDIR}/git"
