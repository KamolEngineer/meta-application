SUMMARY = "Package group for graphics components"
DESCRIPTION = "Graphics components for Raspberry Pi only."

inherit packagegroup

RDEPENDS:${PN}:append:raspberrypi4-64 = " \
    gpio-permissions \
    start-script \
    web-toggle \
"