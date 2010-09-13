require gcc-common.inc

INC_PR = "r1"

SRC_URI = "${GNU_MIRROR}/gcc/gcc-${PV}/gcc-${PV}.tar.bz2;name=archive \
	   file://gcc34-reverse-compare.patch \
	   file://gcc34-arm-ldm.patch \
	   file://gcc34-arm-ldm-peephole.patch \
	   file://gcc34-arm-tune.patch \
	   file://gcc-3.4.1-uclibc-100-conf.patch \
	   file://gcc-3.4.1-uclibc-200-locale.patch \
	   file://gcc-3.4.0-arm-lib1asm.patch \
	   file://gcc-3.4.0-arm-nolibfloat.patch \
	   file://gcc-3.4.0-arm-bigendian.patch \
	   file://gcc-3.4.0-arm-bigendian-uclibc.patch \
	   file://GCC3.4.0VisibilityPatch.diff \
	   file://jarfix.patch \
	   file://always-fixincperm.patch \
	   file://GCOV_PREFIX_STRIP-cross-profile_3.4.patch \
	   file://zecke-xgcc-cpp.patch \
	   file://gcc-posix-open-fix.patch \
	   file://gcc4-mtune-compat.patch"

SRC_URI += "file://gcc34-configure.in.patch;patch=1"
SRC_URI += "file://gcc34-thumb-support.patch;patch=1"
SRC_URI_append_fail-fast = " file://zecke-no-host-includes.patch;patch=1 "
