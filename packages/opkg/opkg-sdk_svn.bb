require opkg.inc

DEPENDS = "curl-sdk"
FILE_PR = "r1"

inherit sdk

EXTRA_OECONF += "--with-opkglibdir=${target_libdir}/opkg --disable-gpg"