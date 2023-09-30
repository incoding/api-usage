package com.javaapi.test.test.semantic;



import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.List;

/**
 * 语法分解
 */
public class Decompose {
    /**
     * 将计算表达式进行分割成单个元素组成的集合
     *
     * @param data
     * @return
     */
    public List<DataTypeStructure> paramCut(String data) {
        char[] chars = data.toCharArray();
        StringBuilder sbr = new StringBuilder();//整体字符串
        List<DataTypeStructure> arr = new ArrayList<>();
        String last = Const.empty;
        String charString;
        for (char aChar : chars) {
            if (aChar == ' ') continue;//跳过空格
            charString = String.valueOf(aChar);
            if (Const.CalcSymbol.calcSymbolSet.contains(charString)) {//如果是符号
                if (Const.CalcSymbol.calcSymbolSet.contains(last)) {//如果上一个也是符号
                    sbr.append(charString);
                    last = charString;
                    continue;
                }
                DataTypeStructure.Type type = sbr.length() > 0 && sbr.charAt(0) == '$' ? DataTypeStructure.Type.Index : DataTypeStructure.Type.Number;//检查是否有引用
                cacheRecord(sbr, arr, type);//flush缓存
                sbr.append(charString);
                last = charString;
                continue;
            }
            if (Const.Bracket.bracketSymbolSet.contains(charString)) {//如果是括号
                if (Const.Bracket.rightBracket.equals(charString)) {
                    DataTypeStructure.Type type = sbr.length() > 0 && sbr.charAt(0) == '$' ? DataTypeStructure.Type.Index : DataTypeStructure.Type.Number;//检查是否有引用
                    cacheRecord(sbr, arr, type);//回括号:必须flush缓存
                }
                if (Const.CalcSymbol.calcSymbolSet.contains(last)) {
                    cacheRecord(sbr, arr, DataTypeStructure.Type.Symbol);//上一个是符号:必须flush缓存
                }
                sbr.append(charString);
                cacheRecord(sbr, arr, DataTypeStructure.Type.Symbol);//flush缓存
                last = Const.empty;
                continue;
            }
            //当前为数据
            if (Const.CalcSymbol.calcSymbolSet.contains(last)) {//如果上一个是符号
                cacheRecord(sbr, arr, DataTypeStructure.Type.Symbol);//flush缓存
            }
            sbr.append(charString);
            last = charString;
        }
        DataTypeStructure.Type type = sbr.length() > 0 && sbr.charAt(0) == '$' ? DataTypeStructure.Type.Index : DataTypeStructure.Type.Number;//检查是否有引用
        cacheRecord(sbr, arr, type);//flush缓存
        return arr;
    }

    /**
     * 将缓存中的数据当成一个整体写入集合
     *
     * @param sbr  缓存数据
     * @param arr  当前集合
     * @param type 当前数据的类型  分为符号类型,引用类型,数值类型
     */
    private void cacheRecord(StringBuilder sbr, List<DataTypeStructure> arr, DataTypeStructure.Type type) {
        if (sbr.length() != 0) {
            DataTypeStructure dataTypeStructure = new DataTypeStructure();
            dataTypeStructure.setDataType(type);
            dataTypeStructure.setDataContent(sbr.toString());
            this.addData(arr, dataTypeStructure);
            sbr.setLength(0);
        }
    }

    /**
     * 添加数据
     */
    private void addData(List<DataTypeStructure> arr, DataTypeStructure line) {
        arr.add(line);
    }


    /**
     * 符号与数据记录的数据结构
     */
    public static class DataTypeStructure {
        /**
         * 数据类型
         */
        public enum Type {
            Symbol,//符号
            Number,//数值
            Index,//引用变量
        }


        private Type dataType;//数据类型 符号,数据
        private Object dataContent;//数据内容

        public Type getDataType() {
            return dataType;
        }

        private void setDataType(Type dataType) {
            this.dataType = dataType;
        }

        public Object getDataContent() {
            return dataContent;
        }

        public void setDataContent(Object dataContent) {
            this.dataContent = dataContent;
        }

        @Override
        public String toString() {
            JSONObject result = new JSONObject();
            result.put("dataType", dataType);
            result.put("dataContent", dataContent);
            return result.toJSONString();
        }
    }
}