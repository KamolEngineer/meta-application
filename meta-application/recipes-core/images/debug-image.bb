include recipes-core/images/core-image-base.bb

COMPATIBLE_MACHINE = "^rpi$"

# Firstly remove to ensure than those features will not be duplicated
# IMAGE_FEATURES:remove = "read-only-rootfs debug-tweaks tools-debug dev-pkgs dbg-pkgs"
# EXTRA_IMAGE_FEATURES:remove = "read-only-rootfs debug-tweaks tools-debug dev-pkgs dbg-pkgs ssh-server-dropbear"

IMAGE_FEATURES:remove = "read-only-rootfs"
EXTRA_IMAGE_FEATURES:remove = "read-only-rootfs"

# Now these packages can be added into the image
IMAGE_FEATURES:append = " debug-tweaks tools-debug dev-pkgs dbg-pkgs ssh-server-dropbear splash"

BAD_RECOMMENDATIONS += "openssh-sftp-server"

ENABLE_UART = "1"
RPI_USE_U_BOOT = "1"