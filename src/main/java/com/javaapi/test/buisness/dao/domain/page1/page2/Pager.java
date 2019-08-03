package com.javaapi.test.buisness.dao.domain.page1.page2;

import com.javaapi.test.buisness.dao.domain.page1.parent.Paginable;
import com.javaapi.test.buisness.dao.domain.page1.parent.SimplePage;

import java.util.List;

/**
 * 列表分页。包含list属性。
 *
 *
 */
public class Pager<T> extends SimplePage implements java.io.Serializable,
		Paginable {
        private int totalPage;

	public Pager() {
	}

	public Pager(int pageNo, int pageSize) {
		super(pageNo, pageSize);
	}


	/**
	 * 构造器
	 *
	 * @param pageNo
	 *            页码
	 * @param pageSize
	 *            每页几条数据
	 * @param totalCount
	 *            总共几条数据
	 */
	public Pager(int pageNo, int pageSize, int totalCount) {
		super(pageNo, pageSize, totalCount);
	}

	/**
	 * 构造器
	 *
	 * @param pageNo
	 *            页码
	 * @param pageSize
	 *            每页几条数据
	 * @param totalCount
	 *            总共几条数据
	 * @param list
	 *            分页内容
	 */
	public Pager(int pageNo, int pageSize, int totalCount, List<T> list) {
		super(pageNo, pageSize, totalCount);
		this.list = list;
                this.totalPage = super.getTotalPage();
	}

	@Override
	public void setTotalCount(int totalCount) {
		super.setTotalCount(totalCount);
		this.totalPage = super.getTotalPage();
	}

	/**
	 * 第一条数据位置
	 *
	 * @return
	 */
	public int getFirstResult() {
		return (pageNo - 1) * pageSize;
	}

	/**
	 * 当前页的数据
	 */
	private List<T> list;

	/**
	 * 获得分页内容
	 *
	 * @return
	 */
	public List<T> getList() {
		return list;
	}

	/**
	 * 设置分页内容
	 *
	 * @param list
	 */
	@SuppressWarnings("unchecked")
	public void setList(List<T> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Pager{");
		sb.append("totalPage=").append(totalPage);
		sb.append(", list=").append(list);
		sb.append(", totalCount=").append(totalCount);
		sb.append(", pageSize=").append(pageSize);
		sb.append(", pageNo=").append(pageNo);
		sb.append('}');
		return sb.toString();
	}
}
