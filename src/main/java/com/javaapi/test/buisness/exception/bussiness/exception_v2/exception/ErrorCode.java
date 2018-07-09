package com.javaapi.test.buisness.exception.bussiness.exception_v2.exception;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 错误码唯一标识为字符串
 */
public class ErrorCode implements Serializable {

    public static final String BUSINESS_COMMON_ERROR = "business.common.error";
    public static final ErrorCode DB_ERROR = new ErrorCode("business.db.error", "数据库异常");
    public static final ErrorCode MEMBER_ERROR = new ErrorCode("business.member.error", "会员异常");
    public static final ErrorCode VIDEO_STATUS_ERROR = new ErrorCode("video.status.error", "视频状态异常");

    private static final long serialVersionUID = 1L;
    private String key;
    private String msg;
    private Map<String,Object> extra = new HashMap<>();

	public static ErrorCode commonError(String msg) {
		return new ErrorCode(BUSINESS_COMMON_ERROR, msg);
	}

    public String getId() {
        return key;
    }

    public void setId(String id) {
        this.key = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String info) {
        this.msg = info;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Map<String, Object> getExtra() {
        return extra;
    }

    public void setExtra(Map<String, Object> extra) {
        this.extra = extra;
    }

    public ErrorCode(String key, String info) {
        super();
        this.key = key;
        this.msg = info;
    }
    public ErrorCode(String key, String info,Map extra) {
        super();
        this.key = key;
        this.msg = info;
        this.extra = extra;
    }


    public ErrorCode addExtra(String extraKey,String extraValue) {
        this.extra.put(extraKey, extraValue);
        return this;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ErrorCode other = (ErrorCode) obj;
        if (key == null) {
            if (other.key != null)
                return false;
        } else if (!key.equals(other.key))
            return false;
        return true;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ErrorCode{");
        sb.append("key='").append(key).append('\'');
        sb.append(", msg='").append(msg).append('\'');
        sb.append(", extra=").append(extra);
        sb.append('}');
        return sb.toString();
    }
}
