#include "mlc_llm_bridge.h"
#include <string>

// TODO: include MLC-LLM runtime headers

int mlc_init(const char* model_path) {
  // TODO: initialize runtime with model
  return 0;
}

int mlc_run_text(const char* text, char* out, int out_len) {
  // TODO: run text inference
  std::string result = "Not implemented";
  int copy_len = result.size() < out_len ? result.size() : out_len - 1;
  memcpy(out, result.c_str(), copy_len);
  out[copy_len] = '\0';
  return 0;
}

int mlc_run_image(const uint8_t* image, int image_len, const char* text, char* out, int out_len) {
  // TODO: run multimodal inference
  std::string result = "Not implemented";
  int copy_len = result.size() < out_len ? result.size() : out_len - 1;
  memcpy(out, result.c_str(), copy_len);
  out[copy_len] = '\0';
  return 0;
}
