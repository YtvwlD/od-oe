require gcc-cross_${PV}.bb
require gcc-cross-initial.inc

DEPENDS += "gmp-native mpfr-native"

EXTRA_OECONF += "--disable-multilib --disable-libssp --disable-libmudflap"
EXTRA_OECONF_INITIAL += "--disable-multilib --disable-libssp --disable-libmudflap"
EXTRA_OECONF_INTERMEDIATE += "--disable-multilib --disable-libssp --disable-libmudflap"
