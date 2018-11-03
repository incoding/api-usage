package com.javaapi.test.util.net.http.client.retrofit2.rxjava.service;

import java.util.List;

public class Translation1 {

    private String type;
    private int errorCode;
    private int elapsedTime;
    private List<List<TranslateResultBean>> translateResult;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public int getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(int elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public List<List<TranslateResultBean>> getTranslateResult() {
        return translateResult;
    }

    public void setTranslateResult(List<List<TranslateResultBean>> translateResult) {
        this.translateResult = translateResult;
    }

    public static class TranslateResultBean {
        /**
         * src : merry me
         * tgt : 我快乐
         */

        public String src;
        public String tgt;

        public String getSrc() {
            return src;
        }

        public void setSrc(String src) {
            this.src = src;
        }

        public String getTgt() {
            return tgt;
        }

        public void setTgt(String tgt) {
            this.tgt = tgt;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("TranslateResultBean{");
            sb.append("src='").append(src).append('\'');
            sb.append(", tgt='").append(tgt).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Translation1{");
        sb.append("type='").append(type).append('\'');
        sb.append(", errorCode=").append(errorCode);
        sb.append(", elapsedTime=").append(elapsedTime);
        sb.append(", translateResult=").append(translateResult);
        sb.append('}');
        return sb.toString();
    }
}