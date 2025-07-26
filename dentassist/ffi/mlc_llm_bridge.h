#pragma once
#include <stdint.h>

#ifdef __cplusplus
extern "C" {
#endif

int mlc_init(const char* model_path);
int mlc_run_text(const char* text, char* out, int out_len);
int mlc_run_image(const uint8_t* image, int image_len, const char* text, char* out, int out_len);

#ifdef __cplusplus
}
#endif
