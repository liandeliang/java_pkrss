package com.pkrss.server.helper;

import javax.servlet.http.HttpServletRequest;

import com.pkrss.server.constant.PageConstant;

public class Pager {

    /**
     * 查询起始，默认：0
     * 同请求时 offset 参数
     */
    private int offset;

    /**
     * 限制多少条数，默认：20
     * 同请求时 limit 参数
     */
    private int limit;

    /**
     * 总页数
     */
    private int totalPagesCount;

    /**
     * 总条数
     */
    private int totalItemsCount;

    public Pager() {
        this.offset = PageConstant.OFFSET_DEF;
        this.limit = PageConstant.LIMIT_DEF;
        this.totalPagesCount = PageConstant.TOTAL_PAGE_COUNT_DEF;
        this.totalItemsCount = PageConstant.TOTAL_ITEM_COUNT_DEF;
    }

    public static Pager initFromRequest(HttpServletRequest request) {
        Pager pager = new Pager();
        if (request != null) {
            pager.setOffset(getIntParam(request, PageConstant.OFFSET_TAG, PageConstant.OFFSET_DEF));
            pager.setLimit(getIntParam(request, PageConstant.LIMIT_TAG, PageConstant.LIMIT_DEF));
            pager.setTotalPagesCount(getIntParam(request, PageConstant.TOTAL_PAGE_COUNT_TAG, PageConstant.TOTAL_PAGE_COUNT_DEF));
            pager.setTotalItemsCount(getIntParam(request, PageConstant.TOTAL_ITEM_COUNT_TAG, PageConstant.TOTAL_ITEM_COUNT_DEF));
        }

        return pager;
    }

    private static int getIntParam(HttpServletRequest request, String tag, int defValue) {
    	String v = request.getParameter(tag);
    	if((v == null) || (v.length()==0))
    		return defValue;
    	return Integer.parseInt(v);
    }

    /**
     * @return Returns the offset.
     */
    public int getOffset() {
        return offset;
    }

    /**
     * @param offset The offset to set.
     */
    public void setOffset(int offset) {
        this.offset = offset;
    }

    /**
     * @return Returns the limit.
     */
    public int getLimit() {
        return limit;
    }

    /**
     * @param limit The limit to set.
     */
    public void setLimit(int limit) {
        this.limit = limit;
    }

    /**
     * @return Returns the totalPagesCount.
     */
    public int getTotalPagesCount() {
        return totalPagesCount;
    }

    /**
     * @param totalPagesCount The totalPagesCount to set.
     */
    public void setTotalPagesCount(int totalPagesCount) {
        this.totalPagesCount = totalPagesCount;
    }

    /**
     * @return Returns the totalItemsCount.
     */
    public int getTotalItemsCount() {
        return totalItemsCount;
    }

    /**
     * @param totalItemsCount The totalItemsCount to set.
     */
    public void setTotalItemsCount(int totalItemsCount) {
        this.totalItemsCount = totalItemsCount;
    }

}
