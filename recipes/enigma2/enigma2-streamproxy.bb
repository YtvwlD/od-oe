DESCRIPTION = "streamproxy manages streaming data to a PC using enigma2"
MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>"

SRCDATE = "20120816"
PV = "1.0git${SRCDATE}"
SRCREV="37a3f198a22d90cdfebf07cf56409cf93a4e74ba"

SRC_URI = "git://schwerkraft.elitedvb.net/streamproxy/streamproxy.git;protocol=git;tag=${SRCREV}"

inherit autotools

S = "${WORKDIR}/git"
