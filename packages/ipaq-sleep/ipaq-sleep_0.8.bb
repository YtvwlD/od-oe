
LICENSE = "GPL"
inherit gpe pkgconfig

DEPENDS = "apmd virtual/xserver xextensions virtual/libx11 libxau xscrnsaverh libxss"
SECTION = "x11/base"
RDEPENDS = "apm"

DESCRIPTION = "Automatic sleep/suspend control daemon"
