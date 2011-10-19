DESCRIPTION = "KompexSQLiteWrapper by SvenBroeske@web.de"
MAINTAINER = "Andreas Monzner <andreas.monzner@dream-property.net>"
HOMEPAGE = "http://sqlitewrapper.kompex-online.com"
LICENSE = "LGPL"

SRC_URI = "http://sqlitewrapper.kompex-online.com/counter/download.php?dl=KompexSQLiteWrapper-Source_1.7.8.tar.gz \
	file://add_automake.patch;patch=1;pnum=1"

PV = "1.7.8"
S = "${WORKDIR}/KompexSQLiteWrapper-Source_${PV}"

inherit autotools pkgconfig

do_stage() {
	oe_runmake install prefix=${STAGING_DIR} \
	       bindir=${STAGING_BINDIR} \
	       includedir=${STAGING_INCDIR} \
	       libdir=${STAGING_LIBDIR} \
	       datadir=${STAGING_DATADIR}
}

EXTRA_OECONF = "--with-target=native"
