SUMMARY = "Package group for console games"
DESCRIPTION = "Games for Raspberry Pi only."

inherit packagegroup

RDEPENDS:${PN}:append:raspberrypi4-64 = " \
    nsnake \
    nudoku \
"