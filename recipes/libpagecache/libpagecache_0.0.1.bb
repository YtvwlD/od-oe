DESCRIPTION = "Preloadable library to improve large file operations"
SECTION = "base"

SRCREV = "6fbe553f58e8f2c8ce941636d520abb7926c6fa5"

inherit autotools opendreambox-git lib_package

do_install_append() {
        install -d ${D}${sysconfdir}
        echo "libpagecache.so.0.0.0" > ${D}${sysconfdir}/ld.so.preload
}
