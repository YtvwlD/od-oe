MAINTAINER = "Koen Kooi <koen@linuxtogo.org>"
PV = ${DISTRO_VERSION}

do_compile() {
	mkdir -p ${D}${sysconfdir}
	echo "Familiar ${DISTRO_VERSION}" > ${D}${sysconfdir}/familiar-version

}