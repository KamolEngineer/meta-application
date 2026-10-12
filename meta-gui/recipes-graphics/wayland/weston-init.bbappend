FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

do_install:append:rpi() {
    sed -i '$a\\n[autolaunch]\npath=/usr/bin/start_script' ${D}/${sysconfdir}/xdg/weston/weston.ini
    sed -i '/^\[core\]/a idle-time=0' ${D}/${sysconfdir}/xdg/weston/weston.ini
}