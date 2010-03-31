require gcc-cross_${PV}.bb
require gcc-cross-intermediate.inc

EXTRA_OECONF += " --disable-libmudflap --disable-libgomp --disable-libssp"
EXTRA_OECONF_INITIAL += " --disable-libmudflap --disable-libgomp --disable-libssp"
EXTRA_OECONF_INTERMEDIATE += " --disable-libmudflap --disable-libgomp --disable-libssp"
