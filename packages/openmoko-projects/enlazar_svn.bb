DESCRIPTION = "Enlazar - Network part for Assasin"
HOMEPAGE = "http://enlazar.projects.openmoko.org/"
LICENSE = "GPL"
DEPENDS = "evas edje ecore edbus"
RDEPENDS = "networkmanager"
PV = "0.1+svn${SRCREV}"
FILE_PR = "r3"
PE = "1"

SRC_URI = "svn://svn.projects.openmoko.org/svnroot/enlazar;module=trunk;proto=http"

S = "${WORKDIR}/trunk"

inherit autotools pkgconfig

EXTRA_OECONF = ""