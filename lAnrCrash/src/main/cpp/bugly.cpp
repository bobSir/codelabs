//
// Created by Administrator on 2020/11/5.
//


#include <jni.h>
#include <android/log.h>
#include "client/linux/handler/minidump_descriptor.h"
#include "client/linux/handler/exception_handler.h"

extern "C"
JNIEXPORT void JNICALL
Java_com_bob_lAnrCrash_nativeCrash_NativeCrashHandler_testNativeCrash(JNIEnv *env, jclass clazz) {
    __android_log_print(ANDROID_LOG_INFO, "native", "xxxxxxxxxx");
    int *p = NULL;
    *p = 10;
}

bool DumpCallback(const google_breakpad::MinidumpDescriptor &descriptor,
                  void *context,
                  bool succeeded) {
    __android_log_print(ANDROID_LOG_ERROR, "native", "native crash:%s", descriptor.path());
    return false;
}

extern "C"
JNIEXPORT void JNICALL
Java_com_bob_lAnrCrash_nativeCrash_NativeCrashHandler_initNativeCrash(JNIEnv *env, jclass clazz, jstring path_) {
    const char *path = env->GetStringUTFChars(path_, 0);

    __android_log_print(ANDROID_LOG_INFO, "native", "===> %s", path);
    google_breakpad::MinidumpDescriptor descriptor(path);
    static google_breakpad::ExceptionHandler eh(descriptor, NULL, DumpCallback,
                                                NULL, true, -1);

    env->ReleaseStringUTFChars(path_, path);

}