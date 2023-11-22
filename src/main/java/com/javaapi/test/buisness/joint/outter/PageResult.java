package com.javaapi.test.buisness.joint.outter;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 *
 * 分页结果
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
public class PageResult<T> implements Serializable {

    private static final long serialVersionUID = -6158906031771836499L;

    /**
     * 页码
     */
    private long pageNum = 1L;

    /**
     * 单页记录数
     */
    private long pageSize = 10L;

    /**
     * 总页数
     */
    private long totalPage = 1L;

    /**
     * 总记录数
     */
    private long totalSize = 0L;

    /**
     * 数据列表
     */
    private List<T> records = Collections.emptyList();
}

