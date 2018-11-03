package com.javaapi.test.util.net.http.client.retrofit2.get.service;

/**
 * Created by user on 18/1/20.
 */
public class Translation {
    private int status;

    private Content content;
    public static class Content {
        private String from;
        private String to;
        private String vendor;
        private String out;
        private int errNo;

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getTo() {
            return to;
        }

        public void setTo(String to) {
            this.to = to;
        }

        public String getVendor() {
            return vendor;
        }

        public void setVendor(String vendor) {
            this.vendor = vendor;
        }

        public String getOut() {
            return out;
        }

        public void setOut(String out) {
            this.out = out;
        }

        public int getErrNo() {
            return errNo;
        }

        public void setErrNo(int errNo) {
            this.errNo = errNo;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Content{");
            sb.append("from='").append(from).append('\'');
            sb.append(", to='").append(to).append('\'');
            sb.append(", vendor='").append(vendor).append('\'');
            sb.append(", out='").append(out).append('\'');
            sb.append(", errNo=").append(errNo);
            sb.append('}');
            return sb.toString();
        }
    }

    //定义 输出返回数据 的方法
    public void show() {
        System.out.println(status);

        System.out.println(content.from);
        System.out.println(content.to);
        System.out.println(content.vendor);
        System.out.println(content.out);
        System.out.println(content.errNo);
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }
}
