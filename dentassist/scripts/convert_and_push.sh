#!/bin/bash
# Sample pipeline for converting MedGemma to gguf and pushing to device
set -e

MODEL_SRC=$1
OUTPUT=medgemma_4b_q4.gguf
DEVICE_PATH=/sdcard/DentAssist/models

if [ -z "$MODEL_SRC" ]; then
  echo "Usage: $0 <path-to-medgemma>" >&2
  exit 1
fi

# Convert using MediaPipe GenAI Converter
mediapipe_genai_converter \
  --model $MODEL_SRC \
  --output_file $OUTPUT \
  --quantization q4

# Push to connected Android device
adb push $OUTPUT $DEVICE_PATH/

echo "Model pushed to $DEVICE_PATH/$OUTPUT"
