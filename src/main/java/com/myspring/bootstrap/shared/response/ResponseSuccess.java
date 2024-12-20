package com.myspring.bootstrap.shared.response;

import lombok.Data;

@Data
public class ResponseSuccess<T> {

    private String status;

    public ResponseSuccess() {
    }

    private T data;

    public ResponseSuccess(T data) {
        this.status = "success";
        this.data = data;
    }
}
