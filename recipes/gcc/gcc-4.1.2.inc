require gcc-common.inc

DEPENDS = "mpfr gmp"
NATIVEDEPS = "mpfr-native gmp-native"

INC_PR = "r22"

INC_PR = "r25"

SRC_URI = "${GNU_MIRROR}/gcc/gcc-${PV}/gcc-${PV}.tar.bz2;name=archive \
	file://100-uclibc-conf.patch \
	file://110-arm-eabi.patch \
	file://200-uclibc-locale.patch \
	file://300-libstdc++-pic.patch \
	file://301-missing-execinfo_h.patch \
	file://302-c99-snprintf.patch \
	file://303-c99-complex-ugly-hack.patch \
	file://304-index_macro.patch \
	file://602-sdk-libstdc++-includes.patch \
	file://740-sh-pr24836.patch \
	file://800-arm-bigendian.patch \
	file://arm-nolibfloat.patch \
	file://arm-softfloat.patch \
	file://gcc41-configure.in.patch \
	file://arm-thumb.patch \
	file://arm-thumb-cache.patch \
	file://zecke-xgcc-cpp.patch \
	file://unbreak-armv4t.patch \
        file://fix-ICE-in-arm_unwind_emit_set.diff \
	file://cache-amnesia.patch \
	file://gfortran.patch \
        file://gcc-4.0.2-e300c2c3.patch \
        file://pr34130.patch \
	file://Makefile.in.patch \
       "

SRC_URI_append_sh3  = " file://sh3-installfix-fixheaders.patch;patch=1 "

SRC_URI_avr32 = "http://www.angstrom-distribution.org/unstable/sources/gcc-4.1.2-atmel.1.1.0.tar.gz \
#           file://100-uclibc-conf.patch;patch=1 \
#           file://200-uclibc-locale.patch;patch=1 \
#           file://300-libstdc++-pic.patch;patch=1 \
           file://301-missing-execinfo_h.patch;patch=1 \
           file://302-c99-snprintf.patch;patch=1 \
           file://303-c99-complex-ugly-hack.patch;patch=1 \
           file://304-index_macro.patch;patch=1 \
           file://602-sdk-libstdc++-includes.patch;patch=1 \
           file://gcc41-configure.in.patch;patch=1 \
           file://zecke-xgcc-cpp.patch;patch=1 \
           file://cache-amnesia.patch;patch=1 \
           "

do_compile_prepend_avr32() {
       ln -sf ${S}/libstdc++-v3/config/os/uclibc/ ${S}/libstdc++-v3/config/os/uclibc-linux
}


# Language Overrides
FORTRAN = ""
JAVA = ""

EXTRA_OECONF_BASE = "--disable-libssp --disable-libmudflap"
EXTRA_OECONF_INITIAL = "--disable-libmudflap --disable-libssp"
EXTRA_OECONF_INTERMEDIATE = "--disable-libmudflap --disable-libssp"


ARM_INSTRUCTION_SET = "arm"
