package com.myspring.bootstrap.shared.response;

import lombok.Data;

@Data
public class ResponseFail<T> {

    private String status;
    private T data;

    public ResponseFail(T data) {
        this.status = "fail";
        this.data = data;
    }
}
