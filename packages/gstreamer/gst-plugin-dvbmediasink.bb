DESCRIPTION = "Plugin for gstreamer: dvbmediasink"
SECTION = "multimedia"
PRIORITY = "optional"
MAINTAINER = "Felix Domke <tmbinc@openembedded.org>"
DEPENDS = "gstreamer"
PV = "0.10+${SRCDATE}"
PR = "r0"

inherit autotools pkgconfig

SRCDATE = "20070628"

SRC_URI = "cvs://anonymous@cvs.schwerkraft.elitedvb.net/cvsroot/dvbmediasink;module=dvbmediasink;method=pserver"
S = "${WORKDIR}/dvbmediasink"

FILES_${PN} = "${libdir}/gstreamer-0.10/*.so*"

do_stage() {
	autotools_stage_all
}