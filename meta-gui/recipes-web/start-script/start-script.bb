SUMMARY = "Adds a startup script for the Cog browser"
DESCRIPTION = "Installs an executable script to /usr/bin/start_script to launch Cog in fullscreen mode."
LICENSE = "CLOSED"

RDEPENDS:${PN} += "bash"

SRC_URI = "file://start_script"

S = "${WORKDIR}"

do_install() {
    install -d ${D}${bindir}

    install -m 0755 ${S}/start_script ${D}${bindir}/
}

FILES:${PN} += "${bindir}/start_script"


#
# IMAGE_INSTALL:append = " start-script"
#