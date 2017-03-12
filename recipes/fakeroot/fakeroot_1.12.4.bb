DESCRIPTION = "Gives a fake root environment"
HOMEPAGE = "http://fakeroot.alioth.debian.org"
SECTION = "base"
LICENSE = "GPL"

SRC_URI = "\
  http://pkgs.fedoraproject.org/repo/pkgs/fakeroot/fakeroot_1.12.4.tar.gz/aaefede2405a40c87438e7e833d69b70/fakeroot_1.12.4.tar.gz \
  file://configure-libtool.patch;patch=1 \
"
	    
inherit autotools

do_stage() {
        install -d ${STAGING_INCDIR}/fakeroot
        install -m 644 *.h ${STAGING_INCDIR}/fakeroot
        autotools_stage_all
}

# fakeroot needs getopt which is provided by the util-linux package
RDEPENDS = "util-linux"

