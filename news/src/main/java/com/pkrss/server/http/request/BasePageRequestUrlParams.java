package com.pkrss.server.http.request;

import java.io.Serializable;

import com.pkrss.server.share.SharedConstants;

/**
 * 
 * <p>Title: 基本分页参数         </p>
 * <p>Description: Function Description </p>
 * <p>Copyright: Copyright (c) 2016     </p>
 * <p>Company: YJS Co., Ltd.     </p>
 * <p>Create Time: 2016年3月15日           </p>
 * @author liandeliang
 */
public class BasePageRequestUrlParams implements Serializable {
    
    /**	
     * Member Description
     */
    
    private static final long serialVersionUID = 1L;
    
    /**
     * 查询起始，默认：0
     */
    private Integer offset;

    /**
     * 限制多少条数，默认：20
     */
    private Integer limit;

    public Integer getOffset() {
        if(offset == null)
            return SharedConstants.UrlRequestParams.offsetParam_default;
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        if(limit == null)
            return SharedConstants.UrlRequestParams.limitParam_default;
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
    
    
}
