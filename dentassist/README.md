# DentAssist

DentAssist is a HIPAA-ready clinical companion for dentists built with Flutter.
It performs offline multimodal inference using MedGemma via the MLC-LLM runtime.

## Setup
1. Install Flutter 3.22 and enable desktop/ios/android targets.
2. Ensure Android NDK and iOS toolchains are installed for FFI.
3. Build the native library in `ffi/` for your platform and place the
   resulting shared library in `android/` and `ios/` folders.
4. Run `flutter pub get` to fetch Dart dependencies.

## Quantization Flags
The model is converted to `medgemma_4b_q4.gguf` using:
```
mediapipe_genai_converter \
  --model <MEDGEMMA_PATH> \
  --output_file medgemma_4b_q4.gguf \
  --quantization q4
```
Then push the model to the device:
```
scripts/convert_and_push.sh <MEDGEMMA_PATH>
```

## HIPAA Checklist
- **Offline Mode**: when `offline_mode` is true in `settings.yaml`, the app
  disables all network access.
- **Encrypted Database**: patient information is stored using `sqflite` with
  `sqlcipher` for AES-256 encryption.
- **Secure Wipe**: long-press on a patient record triggers permanent deletion.
- **No PHI in Logs**: ensure all logging removes or redacts patient data.

## Testing
Run Flutter tests:
```
flutter test
```
