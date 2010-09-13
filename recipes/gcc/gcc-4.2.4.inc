require gcc-common.inc
LICENSE = "GPLv3"

DEPENDS = "mpfr gmp"
NATIVEDEPS = "mpfr-native gmp-native"

INC_PR = "r14"

SRC_URI = "${GNU_MIRROR}/gcc/gcc-${PV}/gcc-${PV}.tar.bz2;name=archive \
	file://100-uclibc-conf.patch \
	file://103-uclibc-conf-noupstream.patch \
	file://200-uclibc-locale.patch \
	file://203-uclibc-locale-no__x.patch \
	file://204-uclibc-locale-wchar_fix.patch \
	file://205-uclibc-locale-update.patch \
	file://300-libstdc++-pic.patch \
	file://301-missing-execinfo_h.patch \
	file://302-c99-snprintf.patch \
	file://303-c99-complex-ugly-hack.patch \
	file://304-index_macro.patch \
	file://305-libmudflap-susv3-legacy.patch \
	file://306-libstdc++-namespace.patch \
	file://307-locale_facets.patch \
	file://402-libbackend_dep_gcov-iov.h.patch \
	file://602-sdk-libstdc++-includes.patch \
	file://740-sh-pr24836.patch \
	file://800-arm-bigendian.patch \
	file://801-arm-bigendian-eabi.patch \
	file://904-flatten-switch-stmt-00.patch \
	file://arm-nolibfloat.patch \
	file://arm-softfloat.patch \
	file://gcc41-configure.in.patch \
	file://arm-thumb.patch \
	file://arm-thumb-cache.patch \
	file://zecke-xgcc-cpp.patch \
	file://unbreak-armv4t.patch \
	file://cache-amnesia.patch \
	file://gfortran.patch \
	file://gcc-4.0.2-e300c2c3.patch \
	file://fortran-static-linking.patch \
	file://intermask-bigendian.patch \
	file://libstdc++-hack-libtool-remove-lstdc++.patch \
	file://Makefile.in.patch \
"

SRC_URI_append_ep93xx = " \
        file://ep93xx/arm-crunch-readme.patch;patch=1 \
        file://ep93xx/arm-crunch-saveregs.patch;patch=1 \
        file://ep93xx/arm-crunch-scratch.patch;patch=1 \
        file://ep93xx/arm-crunch-eabi-ieee754-endian-littleword-littlebyte.patch;patch=1 \
        file://ep93xx/arm-crunch-eabi-mvf0-scratch-ieee754.patch;patch=1 \
        file://ep93xx/arm-crunch-20000320.patch;patch=1 \
        file://ep93xx/arm-crunch-disable-cmpdi.patch;patch=1 \
        file://ep93xx/arm-crunch-fix-64bit-const-offsets.patch;patch=1 \
        file://ep93xx/arm-crunch-fp_consts.patch;patch=1 \
        file://ep93xx/arm-crunch-neg-enable.patch;patch=1 \
        file://ep93xx/arm-crunch-neg-protect.patch;patch=1 \
        file://ep93xx/arm-crunch-repair-truncxfsi.patch;patch=1 \
        file://ep93xx/arm-crunch-floatsi-no-scratch.patch;patch=1 \
        file://ep93xx/arm-crunch-movsf-movdf-Uy.patch;patch=1 \
        file://ep93xx/arm-crunch-drop-thumb2.patch;patch=1 \
        file://ep93xx/arm-crunch-arm_dbx_register_number.patch;patch=1 \
        file://ep93xx/arm-crunch-pipeline.patch;patch=1 \
        file://ep93xx/arm-crunch-ccmav-mode.patch;patch=1 \
        file://ep93xx/arm-crunch-cfcpy-with-cfsh64.patch;patch=1 \
        file://ep93xx/arm-crunch-mieee.patch;patch=1 \
        file://ep93xx/arm-size-bugfix.patch;patch=1 \
        file://ep93xx/arm-prologue_use-length.patch;patch=1 \
        file://ep93xx/arm-crunch-cftruncd32-attr.patch;patch=1 \
        file://ep93xx/arm-crunch-fix-cirrus-reorg7.patch;patch=1 \
        file://ep93xx/arm-crunch-cirrus-di-flag.patch;patch=1 \
        file://ep93xx/arm-crunch-disable-floatsi.patch;patch=1 \
       "

PACKAGE_ARCH_ep93xx = "${MACHINE_ARCH}"

SRC_URI_append_sh3  = " file://sh3-installfix-fixheaders.patch;patch=1 "

SRC_URI_append_sh4  = " file://sh_unwind.patch;patch=1 \
			file://cppdefault_cross.patch;patch=1 \
		      "


# Language Overrides
FORTRAN = ""
FORTRAN_linux-gnueabi = ",fortran"
JAVA = ""

EXTRA_OECONF_BASE = "--enable-libssp --disable-bootstrap --enable-libgomp --disable-libmudflap"
EXTRA_OECONF_INITIAL = "--disable-libmudflap --disable-libgomp --disable-libssp"
EXTRA_OECONF_INTERMEDIATE = "--disable-libmudflap --disable-libgomp --disable-libssp"

ARM_INSTRUCTION_SET = "arm"
