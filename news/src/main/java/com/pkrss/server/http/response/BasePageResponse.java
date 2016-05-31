package com.pkrss.server.http.response;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * <p>Title: 返回分页对象基类,RESTful分格         </p>
 * <p>Description: 子类必须传递模板参数T </p>
 * <p>Copyright: Copyright (c) 2016     </p>
 * <p>Company: YJS Co., Ltd.     </p>
 * <p>Create Time: 2016年1月26日           </p>
 * @author liandeliang
 */
public class BasePageResponse<T> extends BaseResponse<BasePageResponse.Data<T> >{
    /**	
     * Member Description
     */
    
    private static final long serialVersionUID = 1L;

    /**
     * 
     * <p>Title: 返回分页对象,RESTful分格         </p>
     * <p>Description: Function Description </p>
     * <p>Copyright: Copyright (c) 2016     </p>
     * <p>Company: YJS Co., Ltd.     </p>
     * <p>Create Time: 2016年2月23日           </p>
     * @author liandeliang
     */
    public static final class Data<T> implements Serializable{

        private static final long serialVersionUID = 1L;
        
        /**
         * 当前查询返回 list 的数据。
         */
        private List<T> list;
        
        /**
         * 当前查询返回 list 的条数
         */
        private int listSize;
        
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
        
        /*
         * 上下页查询的链接，参考RESTful风格
         */
        private Map<String,String> links;

        public List<T> getList() {
            return list;
        }

        public void setList(List<T> list) {
            this.list = list;
        }

        public int getListSize() {
            return listSize;
        }

        public void setListSize(int listSize) {
            this.listSize = listSize;
        }

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public int getLimit() {
            return limit;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }

        public int getTotalPagesCount() {
            return totalPagesCount;
        }

        public void setTotalPagesCount(int totalPagesCount) {
            this.totalPagesCount = totalPagesCount;
        }

        public int getTotalItemsCount() {
            return totalItemsCount;
        }

        public void setTotalItemsCount(int totalItemsCount) {
            this.totalItemsCount = totalItemsCount;
        }

        public Map<String, String> getLinks() {
            return links;
        }

        public void setLinks(Map<String, String> links) {
            this.links = links;
        }

        
        
    }
}
