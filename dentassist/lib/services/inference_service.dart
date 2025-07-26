import 'dart:typed_data';
import '../ffi/mlc_llm_bridge.dart';

class InferenceService {
  static final InferenceService instance = InferenceService._internal();
  InferenceService._internal();

  Future<String> runTextQuery(String text) async {
    // TODO: call FFI bridge with text-only query
    return 'Mock response';
  }

  Future<String> runImageQuery(Uint8List imageBytes, String prompt) async {
    // TODO: call FFI bridge with multimodal query
    return 'Mock response';
  }
}
