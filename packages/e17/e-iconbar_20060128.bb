DESCRIPTION = "An Iconbar for the Enlightenment Window Manager"
DEPENDS = "edb eet evas-x11 ecore-x11 edje esmart-x11 imlib2-x11"
LICENSE = "MIT"
PR = "r1"

inherit e

SRC_URI = "${E_CVS};module=e17/apps/iconbar;date=${PV}"
S = "${WORKDIR}/iconbar"

EXTRA_OECONF = "--with-edje-cc=${STAGING_BINDIR}/edje_cc"

FILES_${PN} = "${bindir}/* ${libdir}/* ${datadir} ${sysconfdir} ${sbindir}"