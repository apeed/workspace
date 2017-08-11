package com.globalexpress.web.cms.exception;

/**
 * 存在子类栏目异常
 * 
 * @author Administrator
 * @author 赵滨
 */
public class ExistChildrenBlockChannelException extends RuntimeException{

    /**
     * 实现序列号接口
     */
    private static final long serialVersionUID = 133738235990047310L;

    public ExistChildrenBlockChannelException() {
        super();
    }

    public ExistChildrenBlockChannelException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ExistChildrenBlockChannelException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExistChildrenBlockChannelException(String message) {
        super(message);
    }

    public ExistChildrenBlockChannelException(Throwable cause) {
        super(cause);
    }
    
    
}
