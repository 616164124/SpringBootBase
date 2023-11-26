package com.mikael.utils.exception;

public class DefineException extends Exception {
    private static final long serialVersionUID = -3387516993124229948L;

    public DefineException() {
        super();
    }

    public DefineException(String message) {
        super(message);
    }

    public DefineException(String message, Throwable cause) {
        super(message, cause);
    }

    public DefineException(Throwable cause) {
        super(cause);
    }

    protected DefineException(String message, Throwable cause,
                              boolean enableSuppression,
                              boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }


}
