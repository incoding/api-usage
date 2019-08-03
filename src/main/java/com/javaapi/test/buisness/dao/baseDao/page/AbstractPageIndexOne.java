package com.javaapi.test.buisness.dao.baseDao.page;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;

/**
 * Created by user on 16/8/4.
 */
public abstract class AbstractPageIndexOne<T> implements Pageable, Serializable {

    public static final int DEF_COUNT = 10;


    private static final long serialVersionUID = 1232825578694716871L;

    private int page;
    private int size;


    public AbstractPageIndexOne(int page, int size) {
        setPageNo(page);
        setPageSize(size);
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.domain.Pageable#getPageSize()
     */
    public int getPageSize() {
        return size;
    }

    /**
     * if pageSize< 1 then pageSize=DEF_COUNT
     *
     * @param pageSize
     */
    public void setPageSize(int pageSize) {
        if (pageSize < 1) {
            this.size = DEF_COUNT;
        } else {
            this.size = pageSize;
        }
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.domain.Pageable#getPageNumber()
     */
    public int getPageNumber() {
        return page;
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.domain.Pageable#getOffset()
     */
    public int getOffset() {
        return  (page - 1) * size;
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.domain.Pageable#hasPrevious()
     */
    public boolean hasPrevious() {
        return page > 1;
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.domain.Pageable#previousOrFirst()
     */
    public Pageable previousOrFirst() {
        return hasPrevious() ? previous() : first();
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.data.domain.Pageable#next()
     */
    public abstract Pageable next();

    /**
     * Returns the {@link Pageable} requesting the previous {@link Page}.
     *
     * @return
     */
    public abstract Pageable previous();

    /*
     * (non-Javadoc)
     * @see org.springframework.data.domain.Pageable#first()
     */
    public abstract Pageable first();

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;

        result = prime * result + page;
        result = prime * result + size;

        return result;
    }


    /**
     * if totalCount<0 then totalCount=0
     *
     * @param totalCount
     */
//    public void setTotalCount(int totalCount) {
//        if (totalCount < 0) {
//            this.totalCount = 0;
//        } else {
//            this.totalCount = totalCount;
//        }
//    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        AbstractPageIndexOne other = (AbstractPageIndexOne) obj;
        return this.page == other.page && this.size == other.size;
    }

    /**
     * if pageNo < 1 then pageNo=1
     *
     * @param pageNo
     */
    public void setPageNo(int pageNo) {
        if (pageNo < 1) {
            this.page = 1;
        } else {
            this.page = pageNo;
        }
    }
}
