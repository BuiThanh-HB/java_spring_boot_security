package com.demo.thanhbv.demo.model;

public class BaseResponse<T> {
    public int status = 1;
    public String message="Success !";
    public T data;
}
