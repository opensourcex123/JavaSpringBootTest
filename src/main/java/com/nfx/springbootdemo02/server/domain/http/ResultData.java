package com.nfx.springbootdemo02.server.domain.http;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ResultData {
    private Integer code;
    private String message;
    private Object data;

    public static ResultData success(Object data) {
        return ResultData.builder().data(data).code(200).message("success").build();
    }

    public static ResultData success() {
        return ResultData.builder().code(200).message("success").build();
    }

    public static ResultData failure(String message) {
        return ResultData.builder().code(400).message(message).build();
    }
}
