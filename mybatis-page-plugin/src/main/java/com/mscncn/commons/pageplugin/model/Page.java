package com.mscncn.commons.pageplugin.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author king-pan
 * 
 *         对分页信息封装
 */
public class Page<T> {
	/**
	 * 页码，默认是第一页
	 */
	private int pageNo = 1;
	/**
	 * 每页显示的记录数，默认是15
	 */
	private int pageSize = 15;
	/**
	 * 总记录数
	 */
	private int totalRecord;
	/**
	 * 总页数
	 */
	private int totalPage;
	/**
	 * 对应的当前页记录
	 */
	private List<T> results;
	private Map<String, Object> params = new HashMap<String, Object>();// 其他的参数我们把它分装成一个Map对象

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	/**
	 * 设置总页数
	 * 
	 * @param totalRecord
	 *            总页数
	 */
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
		/**
		 * 在设置总页数的时候计算出对应的总页数，在下面的三目运算中加法拥有更高的优先级，所以最后可以不加括号。
		 */
		int totalPage = totalRecord % pageSize == 0 ? totalRecord / pageSize
				: totalRecord / pageSize + 1;
		if (pageNo > totalPage) {
			/**
			 * 如果pageNo超过了总页数，那么就返回最后一页的数据
			 */
			this.pageNo = totalPage;
			System.err.println("Page debug : pageNo超过了总页数，那么就返回最后一页的数据");
		}
		this.setTotalPage(totalPage);
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getResults() {
		return results;
	}

	public void setResults(List<T> results) {
		this.results = results;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Page [pageNo=").append(pageNo).append(", pageSize=")
				.append(pageSize).append(", results=").append(results)
				.append(", totalPage=").append(totalPage)
				.append(", totalRecord=").append(totalRecord).append("]");
		return builder.toString();
	}
}