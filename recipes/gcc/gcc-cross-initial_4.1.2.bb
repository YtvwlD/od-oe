require gcc-cross_${PV}.bb
require gcc-cross-initial.inc

EXTRA_OECONF += "--disable-libmudflap --disable-libssp"
EXTRA_OECONF_INITIAL += "--disable-libmudflap --disable-libssp"
EXTRA_OECONF_INTERMEDIATE += "--disable-libmudflap --disable-libssp"
