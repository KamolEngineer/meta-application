include recipes-core/images/core-image-base.bb

COMPATIBLE_MACHINE = "^rpi$"

ENABLE_UART = "1"

IMAGE_FEATURES:remove = "debug-tweaks splash"
EXTRA_IMAGE_FEATURES:remove = "debug-tweaks"

IMAGE_FEATURES:append = " read-only-rootfs"

inherit extrausers
EXTRA_USERS_PARAMS = "\
    usermod -p '\$6\$KCHCNXSIdsZxRuLp\$u7KaijJyF.3bTdCXew8XUI8UmhIFpuIPTPKy4M12o5LOJfsjpNFtutAbUgiG9QYVLdugA2tLzUJdXAuIZi2id/' root; \
    "