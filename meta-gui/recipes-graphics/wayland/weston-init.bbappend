FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

do_install:append:rpi() {
    sed -i '$a\\n[autolaunch]\npath=/usr/bin/start_script' ${D}/${sysconfdir}/xdg/weston/weston.ini
}
