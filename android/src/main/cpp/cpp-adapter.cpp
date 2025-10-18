#include <jni.h>
#include "NitroAddonsOnLoad.hpp"

JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM* vm, void*) {
  return margelo::nitro::addons::initialize(vm);
}
