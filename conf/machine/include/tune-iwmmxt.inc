# Configurations for the Intel PXA27x Appications Processor Family. 
# Please use tune-xscale for PXA255/PXA26x based processors.
TARGET_CC_ARCH = "-march=iwmmxt -mcpu=iwmmxt -mtune=iwmmxt"
BASE_PACKAGE_ARCH = "iwmmxt"
PACKAGE_EXTRA_ARCHS += "iwmmxt"
FEED_ARCH = "iwmmxt"
