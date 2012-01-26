DESCRIPTION = "Preloadable library to improve large file operations"
SECTION = "base"

SRCREV = "3fb3a842b6de53f75a153b14a8716cb6bafd8436"

inherit autotools opendreambox-git lib_package

do_install_append() {
        install -d ${D}${sysconfdir}
        echo "libpagecache.so.0.0.0" > ${D}${sysconfdir}/ld.so.preload
}
