require gst-plugins.inc

SRC_URI_append_opendreambox = " file://samihack.patch;patch=1 \
file://d3a44541749f413343d5717c464083cef22a74f1.patch;patch=1 \
file://1e0ddb12aa1c2b13c4bc4a13712ebd7f06a6346e.patch;patch=1 \
"

PR = "${INC_PR}.0"

PROVIDES += "gst-plugins"

# gst-plugins-base only builds the alsa plugin
# if alsa has been built and is present.  You will
# not get an error if this is not present, just 
# a missing alsa plugin
DEPENDS += "${@base_contains('DISTRO', 'opendreambox', 'alsa-lib', 'cdparanoia pango libtheora alsa-lib libsm virtual/libx11 freetype gnome-vfs libxv', d)}"
EXTRA_OECONF_opendreambox += "--disable-theora --disable-pango --with-audioresample-format=int"
