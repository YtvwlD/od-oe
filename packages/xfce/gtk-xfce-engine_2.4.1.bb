DESCRIPTION = "XFCE theme for GTK"

inherit xfce
XFCE_VERSION = 4.4.1

FILES_${PN} += "${libdir}/gtk-2.0/*/engines/libxfce.so \
                ${datadir}/themes/"
FILES_${PN}-dbg += "${libdir}/gtk-2.0/*/engines/.debug"