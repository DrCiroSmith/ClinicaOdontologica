# DentAssist Usage Guide

This guide walks through setting up and running DentAssist on a local device.
It assumes Flutter 3.22 and appropriate Android/iOS toolchains are installed.

## 1. Clone the Repository
```bash
git clone <repo-url>
cd ClinicaOdontologica/dentassist
```

## 2. Install Flutter Dependencies
```bash
flutter pub get
```

## 3. Build the Native Library
Compile the C++ bridge for your platform and place the resulting library
(`libmlc_llm.so` on Android, `libmlc_llm.dylib` on iOS/macOS) into the
corresponding `android/` or `ios/` folders.

```
# Example using ndk-build or CMake (commands will vary)
```

## 4. Convert the Model
Run the helper script with the path to your MedGemma model:
```bash
scripts/convert_and_push.sh /path/to/medgemma
```
This converts the model to `medgemma_4b_q4.gguf` and pushes it to a connected
Android device under `/sdcard/DentAssist/models/`.
For iOS, copy the file into the app bundle using Xcode.

## 5. Configure Feature Flags
Edit `settings.yaml` to enable or disable optional features such as offline
mode or cloud fallback.

## 6. Run DentAssist
Launch the app on an attached device or simulator:
```bash
flutter run
```
The UI will open to the chat screen where you can type or record a query.

## 7. Secure Wipe
To delete all patient data for a record, long‑press on the entry and confirm
"Secure Wipe". The encrypted database file is removed permanently.

## 8. Testing
Run unit tests with:
```bash
flutter test
```
