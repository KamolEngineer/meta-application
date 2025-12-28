# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI = "git://github.com/alexdantas/nSnake.git;branch=master"

# Modify these as desired
PV = "1.0+git"
SRCREV = "d018237c22beabb99ec727e73c3e04e580edcebf"

DEPENDS += " ncurses"

S = "${WORKDIR}/git"

# NOTE: this is a Makefile-only piece of software, so we cannot generate much of the
# recipe automatically - you will need to examine the Makefile yourself and ensure
# that the appropriate arguments are passed in.
#
# do_configure () {
# 	:
# }

# do_compile () {
# 	oe_runmake
# }

TARGET_CC_ARCH += "${LDFLAGS}"

do_install () {
    install -d ${D}${bindir}
    install -m 0755 ${B}/bin/nsnake ${D}${bindir}/nsnake
}

FILES_${PN} += "${bindir}/nsnake"
