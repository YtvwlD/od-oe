DESCRIPTION = "Swfdec plugin for browsers using NPAPI. Swfdec is a decoder/renderer for Macromedia Flash animations."
LICENSE = "LGPL"

FILE_PR = "r1"

DEPENDS = "gst-ffmpeg swfdec gstreamer libsoup-2.4 pango cairo liboil zlib libmad gtk+ alsa-lib"
RDEPENDS = "gst-ffmpeg"

SRC_URI = "http://swfdec.freedesktop.org/download/swfdec-mozilla/0.7/${P}.tar.gz \
"

inherit autotools pkgconfig 

do_stage() {
	autotools_stage_all
}

FILES_${PN} += "${libdir}/mozilla/plugins/*.so"
FILES_${PN}-dev += "${libdir}/mozilla/plugins/*a"
FILES_${PN}-dbg += "${libdir}/mozilla/plugins/.debug"
