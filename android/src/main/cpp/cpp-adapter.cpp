#include <jni.h>
#include "AddonsOnLoad.hpp"

JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM* vm, void*) {
  return margelo::nitro::addons::initialize(vm);
}
