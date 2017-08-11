package com.rcb.service;

/**
 *    密码错误异常
 */
public class PasswordException extends RuntimeException {
    public PasswordException(String message) {
        super(message);
    }
}