package com.javaapi.test.businessdesign.howtoextend.exception;

/**
 * 继承后的方法 抛出的异常,如果是运行时异常则无限制
 */
class BaseballRuntimeException extends RuntimeException {
}

abstract class InningRuntime {
    public void event() throws BaseballRuntimeException {
    }
}

class StormyInningRuntime extends InningRuntime {
    @Override
    public void event() throws RuntimeException {
    }
}


