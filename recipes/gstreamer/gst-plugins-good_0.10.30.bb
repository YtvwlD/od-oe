require gst-plugins.inc

PR = "${INC_PR}.1"

DEPENDS += "gst-plugins-base"

RREPLACES_gst-plugin-audioparsers = "gst-plugin-audioparsersbad"
RCONFLICTS_gst-plugin-audioparsers = "gst-plugin-audioparsersbad"
RREPLACES_gst-plugin-isomp4 = "gst-plugin-qtdemux"
RCONFLICTS_gst-plugin-isomp4 = "gst-plugin-qtdemux"

SRC_URI_append_opendreambox += " file://audioparser-raise-ranks.patch;patch=1;pnum=1 \
"

do_configure_prepend() {
	sed -i -e s:docs::g Makefile.am
}

