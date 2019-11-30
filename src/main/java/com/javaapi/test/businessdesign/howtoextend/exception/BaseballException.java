package com.javaapi.test.businessdesign.howtoextend.exception;

/**
 * refer
 * https://www.jianshu.com/p/d70541917bd7
 */
class BaseballException extends Exception {
}

class Foul extends BaseballException {
}

class Strike extends BaseballException {
}

abstract class Inning {

    public Inning() throws BaseballException {
    }

    public Inning(String s) {
    }

    public void event() throws BaseballException {
    }

    public void walk() {
    }

    public abstract void atBat() throws Strike, Foul;

}


class StormException extends Exception {
}

class RainedOut extends StormException {
}

class PopFoul extends Foul {
}

interface Storm {
    public void event() throws RainedOut;

    public void rainHard() throws RainedOut;
}


class StormyInning extends Inning implements Storm {

    public StormyInning() throws RainedOut, BaseballException {
        // 构造方法必须throws父类构造方法的Exception
        // 子类构造方法调用super，不可捕获父类的异常
    }

    public StormyInning(String s) {
        super("");
    }

    @Override
    public void event() {
        // 父类event方法和接口event方法抛出的异常不一致，所以只能重写方法，不抛出任何异常
    }

    @Override
    public void rainHard() {
        // 子类重写方法，可以将抛出的异常范围缩小或者不抛出异常
    }

    @Override
    public void atBat() throws PopFoul {
        // 子类重写方法，可以抛出父类抛出异常的子类异常
        // PopFoul extends Foul
    }

    // @Override
    // public void walk() throws StormException {
    // 如果父类方法未抛出异常，子类重写方法不可抛出异常
    // }
}