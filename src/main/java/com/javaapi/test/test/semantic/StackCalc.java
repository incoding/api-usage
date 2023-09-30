package com.javaapi.test.test.semantic;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;


/**
 * 后续表达式解析计算逻辑
 */
public class StackCalc {
    private Stack<Object> dataStack;//数据栈
    private Stack<String> symbolStack;//符号栈
    private Map<String, Object> cache;//缓存引用数据

    public StackCalc() {
        this.dataStack = new Stack<>();
        this.symbolStack = new Stack<>();
        this.cache = new HashMap<>();
    }

    /**
     * 引用赋值,可以在表达式中使用 "$变量名" 获取变量值
     *
     * @param key   变量名称
     * @param value 变量值
     */
    public void setKV(String key, Object value) {
        this.cache.put(key, value);
    }

    /**
     * 获取引用数据
     *
     * @param key 变量名称
     * @return
     */
    private Object getV(String key) {
        return this.cache.get(key);
    }


    /**
     * 弹栈,单独提为方法的目的是可以加日志,查看弹出的数据是什么
     *
     * @param tStack
     * @param <T>
     * @return
     */
    private <T> T pop(Stack<T> tStack) {
        T pop = tStack.pop();
//        System.out.println(String.format("弹栈 %s", pop));
        return pop;

    }

    /**
     * 单独提为方法的目的是可以加日志,查看入栈的数据是什么
     *
     * @param tStack
     * @param data
     * @param <T>
     */
    private <T> void push(Stack<T> tStack, T data) {
//        System.out.println(String.format("入栈 %s", data));
        tStack.push(data);
    }

    /**
     * 数据入栈弹栈逻辑
     *
     * @param dataTypeStructures
     * @return
     * @throws Exception
     */
    public Object stackCalc(List<Decompose.DataTypeStructure> dataTypeStructures) throws Exception {
        for (Decompose.DataTypeStructure structure : dataTypeStructures) {
            switch (structure.getDataType()) {
                case Symbol:
                    String symbol = String.valueOf(structure.getDataContent());//入栈符号
                    this.pushSymbol(symbol);
                    break;
                case Index:
                    String index = String.valueOf(structure.getDataContent());
                    String key = index.substring(1);
                    structure.setDataContent(this.getV(key));
                case Number:
                    Object value = structure.getDataContent();//入栈数据
                    this.push(this.dataStack, value);
                    break;
            }
        }
        while (true) {//全部弹出为止
            if (this.symbolStack.empty()) {
                break;
            }
            exec();
        }
        return this.pop(this.dataStack);
    }

    /**
     * 符号入栈
     * @param symbol
     * @throws Exception
     */
    private void pushSymbol(String symbol) throws Exception {
        //如果是回括号,一直弹栈到去括号为止,回括号最高优先级
        if (Const.Bracket.rightBracket.equals(symbol)) {
            this.rightBracket();
            return;
        }
        //如果不是回括号,比较计算的优先级计算数值
        if (this.symbolStack.empty() || symbol.endsWith(Const.Bracket.leftBracket)) {//空符号或者左括号结尾,直接存入
            this.push(this.symbolStack, symbol);
            return;
        }
        //如果队列中有符号,比较优先级
        String popSymbol = this.symbolStack.peek();//弹出符号
        if (popSymbol.endsWith(Const.Bracket.leftBracket)) {//上一个是括号.直接跳过
            this.push(this.symbolStack, symbol);//存入符号
            return;
        }
        //比较优先级
        int popStatus = getLevel(popSymbol);//获取优先级别
        int pushStatus = getLevel(symbol);
        if (popStatus < pushStatus) {//上一个符号是高优先级,下一个符号是低优先级都会计算
            this.exec();//高优先级计算
            this.push(this.symbolStack, symbol);//存入符号
            return;
        }
        this.push(this.symbolStack, symbol);//下一个符号优先级更高,不计算
    }


    /**
     * 获取计算优先级
     * todo 这里优先级设置的比较简单,可以自己设置对应计算符号的优先级,
     * 括号不用比较,直接计算(出现括号走不到这个方法)
     * 1级优先级 乘除
     * 2级优先级,常用计算符号
     * 3级优先级,自定义方法中的逗号计算 用于拼接两个数据组成链表
     * 4级优先级,其他计算符号
     *
     * @return
     */
    private static int getLevel(String symbol) {
        if (Const.CalcLevel.calcLevelOne.contains(symbol)) {//1级优先级
            return 1;
        }
        if (Const.CalcLevel.calcLevelTwo.contains(symbol)) {//2级优先级
            return 2;
        }
        if (Const.CalcLevel.calcLevelThree.contains(symbol)) {//3级优先级
            return 3;
        }
        return 4;
    }

    /**
     * 计算表达式,并将表达式的结果存入到栈中
     */
    private void exec() throws Exception {
        String symbol = this.pop(this.symbolStack);
        Object two = this.pop(this.dataStack);
        Object one = this.pop(this.dataStack);
        this.push(this.dataStack, LogicalCalc.MathCalc.exec(symbol, one, two));
    }

    /**
     * 回括号计算逻辑
     */
    private void rightBracket() throws Exception {
        while (true) {//全部弹出为止
            String popSymbol = this.symbolStack.peek();
            if (popSymbol.endsWith(Const.Bracket.leftBracket)) {//找到回括号
                this.pop(this.symbolStack);
                if (popSymbol.length() != 1) {
                    Object pop = this.pop(this.dataStack);
                    Object result = LogicalCalc.FuncCalc.exec(popSymbol.substring(0, popSymbol.length() - 1), pop);
                    this.push(this.dataStack, result);
                }
                break;
            }
            exec();//计算表达式
        }
    }
}