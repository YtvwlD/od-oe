DESCRIPTION = "Flex is a tool for generating programs that recognize lexical patterns in text."
SECTION = "devel"
LICENSE = "BSD"

SRC_URI = "https://github.com/westes/flex/archive/flex-2-5-31.tar.gz \
           file://flex-lvalue.diff;patch=1 \
           file://fix-gen.patch;patch=1"
S = "${WORKDIR}/flex-${PV}"

inherit autotools

