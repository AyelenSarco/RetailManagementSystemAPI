package com.example.retail.retail_management_system.dto;

import com.example.retail.retail_management_system.exception.ApiError;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.ZonedDateTime;
import java.util.List;


public class ApiResponse<T> {
    private boolean success;
    private String message;
    private T data;
    private List<ApiError> errors;
    private Object meta;
    private ZonedDateTime dateTime;

    public ApiResponse(boolean success, String message, T data, List<ApiError> errors, Object meta) {
        this.success = success;
        this.message = message;
        this.data = data;
        this.errors = errors;
        this.meta = meta;
    }

    public ApiResponse(){}

    public static <T> ApiResponse<T> success (String message, T data){
        return new ApiResponse<>(true,message,data,null,null);
    }

    public static <T> ApiResponse<T> failure(String message, List<ApiError> errors){
        return new ApiResponse<>(false, message,null,errors,null);
    }

    public boolean isSuccess() { return success; }
    public String getMessage() { return message; }
    public T getData() { return data; }
    public List<ApiError> getErrors() { return errors; }
    public Object getMeta() { return meta; }

}
