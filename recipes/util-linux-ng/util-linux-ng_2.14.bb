require util-linux-ng.inc

PR = "r5"

SRC_URI += "file://util-linux-ng-uclibc-versionsort.patch;patch=1 \
	    file://util-linux-ng-replace-siginterrupt.patch;patch=1 \
	   "
LDFLAGS_append_linux-uclibc = " -lintl"
LDFLAGS_append_linux-uclibcgnueabi = " -lintl "
LDFLAGS_append_uclinux-uclibc = " -lintl"
