#
# Copyright (C) 2011-2015 - Stacy Devino - All Rights Reserved
#

LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)

LOCAL_MODULE_TAGS := optional

LOCAL_JAVA_LIBRARIES := conscrypt

LOCAL_STATIC_JAVA_LIBRARIES := android-support-v13 jsr305 android-support-v4

LOCAL_SRC_FILES := $(call all-java-files-under, src)

LOCAL_CERTIFICATE := platform
LOCAL_PRIVILEGED_MODULE := true

#LOCAL_PROGUARD_FLAG_FILES := proguard.flags

LOCAL_PACKAGE_NAME := FastAppDialog

include $(BUILD_PACKAGE)

include $(CLEAR_VARS)

#LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES := 

#include $(BUILD_MULTI_PREBUILT)
##################################################
