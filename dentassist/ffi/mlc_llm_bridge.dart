import 'dart:ffi' as ffi;
import 'dart:io';
import 'package:ffi/ffi.dart';

typedef _MlcInit = ffi.Int32 Function(ffi.Pointer<ffi.Char>);
typedef _MlcInitDart = int Function(ffi.Pointer<ffi.Char>);

typedef _MlcRunText = ffi.Int32 Function(ffi.Pointer<ffi.Char>, ffi.Pointer<ffi.Char>, ffi.Int32);
typedef _MlcRunTextDart = int Function(ffi.Pointer<ffi.Char>, ffi.Pointer<ffi.Char>, int);

typedef _MlcRunImage = ffi.Int32 Function(ffi.Pointer<ffi.Uint8>, ffi.Int32, ffi.Pointer<ffi.Char>, ffi.Pointer<ffi.Char>, ffi.Int32);
typedef _MlcRunImageDart = int Function(ffi.Pointer<ffi.Uint8>, int, ffi.Pointer<ffi.Char>, ffi.Pointer<ffi.Char>, int);

class MlcLlmBridge {
  late ffi.DynamicLibrary _lib;
  late _MlcInitDart _init;
  late _MlcRunTextDart _runText;
  late _MlcRunImageDart _runImage;

  MlcLlmBridge() {
    final libPath = Platform.isAndroid ? 'libmlc_llm.so' : 'libmlc_llm.dylib';
    _lib = ffi.DynamicLibrary.open(libPath);
    _init = _lib.lookupFunction<_MlcInit, _MlcInitDart>('mlc_init');
    _runText = _lib.lookupFunction<_MlcRunText, _MlcRunTextDart>('mlc_run_text');
    _runImage = _lib.lookupFunction<_MlcRunImage, _MlcRunImageDart>('mlc_run_image');
  }

  int init(String modelPath) {
    final ptr = modelPath.toNativeUtf8();
    final res = _init(ptr.cast());
    malloc.free(ptr);
    return res;
  }

  String runText(String text) {
    final inPtr = text.toNativeUtf8();
    final out = malloc.allocate<ffi.Char>(4096);
    _runText(inPtr.cast(), out, 4096);
    final result = out.cast<ffi.Utf8>().toDartString();
    malloc.free(out);
    malloc.free(inPtr);
    return result;
  }

  String runImage(List<int> imageBytes, String text) {
    final imagePtr = malloc.allocate<ffi.Uint8>(imageBytes.length);
    imagePtr.asTypedList(imageBytes.length).setAll(0, imageBytes);
    final textPtr = text.toNativeUtf8();
    final out = malloc.allocate<ffi.Char>(4096);
    _runImage(imagePtr, imageBytes.length, textPtr.cast(), out, 4096);
    final result = out.cast<ffi.Utf8>().toDartString();
    malloc.free(out);
    malloc.free(imagePtr);
    malloc.free(textPtr);
    return result;
  }
}
