package com.rcb.service;
/**
 *    账号错误异常
 */
public class AdminCodeException extends RuntimeException {
    public AdminCodeException(String message) {
        super(message);
    }
}