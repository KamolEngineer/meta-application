DESCRIPTION = "CPU Temperature Web GUI for Raspberry Pi"
LICENSE = "CLOSED"

SRC_URI = "file://led-toggle.sh"
SRC_URI += "file://index.html"

RDEPENDS:${PN} += "bash"

do_install() {
    install -d ${D}/usr/lib/cgi-bin/
    install -m 0755 ${WORKDIR}/led-toggle.sh ${D}/usr/lib/cgi-bin/led-toggle.sh

    install -d ${D}/var/www/html/
    install -m 0755 ${WORKDIR}/index.html ${D}/var/www/html/
}

FILES:${PN} += "/var/www/html/index.html /usr/lib/cgi-bin/led-toggle.sh"