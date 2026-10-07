SUMMARY = "Udev rule and group for GPIO device permissions"
DESCRIPTION = "Installs a udev rule to set the group of /dev/gpiochip* devices to 'gpio'"
LICENSE = "CLOSED"

SRC_URI = "file://99-gpio.rules"

S = "${WORKDIR}"

do_install() {
    install -d ${D}${sysconfdir}/udev/rules.d

    install -m 0644 ${WORKDIR}/99-gpio.rules ${D}${sysconfdir}/udev/rules.d/
}

FILES:${PN} += "${sysconfdir}/udev/rules.d/99-gpio.rules"