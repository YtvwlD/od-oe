require gcc-cross_${PV}.bb
require gcc-cross-initial.inc

EXTRA_OECONF += " --disable-libmudflap --disable-libgomp --enable-decimal-float=no --disable-libssp"
EXTRA_OECONF_INITIAL += " --disable-libmudflap --disable-libgomp --enable-decimal-float=no --disable-libssp"
EXTRA_OECONF_INTERMEDIATE += " --disable-libmudflap --disable-libgomp --enable-decimal-float=no --disable-libssp"
