package com.javaapi.test.test.semantic;


import java.util.Stack;

/**
 * 计算器语法解析
 */
public class GrammarUtil {
    private Stack<String> dataStack;//数据栈
    private Stack<Character> symbolStack;//符号栈

    public GrammarUtil() {
        dataStack = new Stack<>();
        symbolStack = new Stack<>();
        dataStack = new Stack<>();
        dataStack = new Stack<>();
    }

    /**
     * 栈是否为空,为空异常
     *
     * @param stack
     * @param msg
     * @param <T>
     * @throws Exception
     */
    public <T> void checkStackIsNull(Stack<T> stack, String msg) throws Exception {
        if (stack.empty()) {
            throw new Exception(msg);
        }

    }

    /**
     * 弹栈,单独提为方法的目的是可以加日志,查看弹出的数据是什么
     *
     * @param tStack
     * @param <T>
     * @return
     */
    public <T> T pop(Stack<T> tStack) {
        T pop = tStack.pop();
        return pop;

    }

    /**
     * 单独提为方法的目的是可以加日志,查看入栈的数据是什么
     *
     * @param tStack
     * @param data
     * @param <T>
     */
    public <T> void push(Stack<T> tStack, T data) {
        tStack.push(data);

    }

    /**
     * 存放数据
     *
     * @param data
     */
    public void pushData(String data) {
        push(this.dataStack, data);
    }

    /**
     * 存放符号,并返回是否需要弹栈
     *
     * @param data
     * @return
     */
    public void pushSymbol(Character data) throws Exception {
        if (')' == data) {//弹栈
            while (true) {
                checkStackIsNull(this.symbolStack, "缺少对应的括号 '('");
                Character pop = pop(this.symbolStack);
                if ('(' == pop) {//找到去括号,退出循环
                    return;
                } else {
                    //不是回括号,弹出两个值
                    checkStackIsNull(this.dataStack, "括号内缺少对应的数值");
                    String two = pop(this.dataStack);
                    checkStackIsNull(this.dataStack, "括号内缺少对应的数值");
                    String one = pop(this.dataStack);
                    Double result = exec(one, two, pop);
                    push(this.dataStack, String.valueOf(result));
                }
            }
        } else {
            Integer priority = priority(data);
            Integer lastSymbol;
            if (this.symbolStack.empty()) {
                lastSymbol = null;
            } else {
                Character pop = pop(this.symbolStack);
                lastSymbol = priority(pop);
                push(this.symbolStack, pop);
            }
            if (lastSymbol == null || priority == null || priority > lastSymbol) {
                push(this.symbolStack, data);
                return;
            }
            if (!this.symbolStack.empty()) {
                Character pop = pop(this.symbolStack);
                this.symbolStack.push(data);
                String two = pop(this.dataStack);
                checkStackIsNull(this.dataStack, "括号内缺少对应的数值");
                String one = pop(this.dataStack);
                Double result = exec(one, two, pop);
                push(this.dataStack, String.valueOf(result));
            }

        }
    }

    /**
     * 获取计算的最终结果
     *
     * @return
     * @throws Exception
     */
    public Double getResult() throws Exception {
        String two = pop(this.dataStack);
        if (this.symbolStack.empty()) {
            return Double.valueOf(two);
        }
        Character symbol = pop(this.symbolStack);
        String one = pop(this.dataStack);
        return exec(one, two, symbol);
    }

    /**
     * 原理,采用后续遍历的方式计算
     *
     * @param data
     * @return
     */
    private Double decompose(String data) throws Exception {
        char[] c = data.toCharArray();
        StringBuffer tmp = new StringBuffer();//记录当前元素
        for (int i = 0; i < c.length; i++) {
            char current = c[i];
            if (current == ' ') {
                if (tmp.length() == 0) {
                    continue;
                }
                pushData(tmp.toString());
                tmp.setLength(0);
                continue;
            }
            if (CalcType.allSymbol.contains(current)) {
                if (tmp.length() != 0) {
                    pushData(tmp.toString());
                    tmp.setLength(0);
                }
                pushSymbol(current);
                continue;
            }
            tmp.append(current);
        }
        if (tmp != null && tmp.length() != 0) {
            pushData(tmp.toString());
            tmp.setLength(0);
        }
        return getResult();
    }

    /**
     * 根据符号个数据进行数值逻辑计算
     *
     * @param one    第一个参数
     * @param two    第二个参数
     * @param symbol 计算符号
     * @return
     * @throws Exception
     */
    public Double exec(String one, String two, Character symbol) throws Exception {
//        switch (symbol) {
//            case CalcType.Add.getSymbol()://加法
//                return DataUtil.add(one, two);
//            case CalcType.Subtract://减法
//                return DataUtil.subtract(one, two);
//            case CalcType.Multiply://乘法
//                return DataUtil.multiply(one, two);
//            case CalcType.Divide://除法
//                return DataUtil.divide(one, two);
//            default:
//                throw new Exception(String.format("不支持的计算,符号 %s", symbol));

        switch (symbol) {
            case CalcType.Add://加法
                return DataUtil.add(one, two);
            case CalcType.Subtract://减法
                return DataUtil.subtract(one, two);
            case CalcType.Multiply://乘法
                return DataUtil.multiply(one, two);
            case CalcType.Divide://除法
                return DataUtil.divide(one, two);
            default:
                throw new Exception(String.format("不支持的计算,符号 %s", symbol));
        }
    }

    /**
     * 获取当前符号的计算优先级
     *
     * @param symbol
     * @return
     */
    public Integer priority(Character symbol) {
        if ((symbol == CalcType.Add || symbol == CalcType.Subtract)) {//优先级为加与减的优先级为1
            return 1;
        }
        if ((symbol == CalcType.Multiply || symbol == CalcType.Divide)) {//优先级为乘与除优先级为2
            return 2;
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        String data = "((2+1))* (3*(2+1))";
        Double decompose = new GrammarUtil().decompose(data);//字符串分解
        System.out.println(decompose);
    }
}

