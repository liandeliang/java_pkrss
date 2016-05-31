package com.pkrss.server.utils;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.pagehelper.PageInfo;
import com.pkrss.server.http.request.BasePageRequestUrlParams;
import com.pkrss.server.http.response.BasePageResponse;
import com.pkrss.server.share.SharedConstants;


public final class PageUtil {
    
    /**
     * 	创建默认 RequestParams 分页参数
     * <p>Description:              </p>
     * <p>Create Time: 2016年2月23日   </p>
     * @author liandeliang
     * @return
     */
    public static BasePageRequestUrlParams createDefaultRequestParam(){
        BasePageRequestUrlParams ret = new BasePageRequestUrlParams();
        
        ret.setOffset(SharedConstants.UrlRequestParams.offsetParam_default);
        ret.setLimit(SharedConstants.UrlRequestParams.limitParam_default);
        
        return ret;
    }
    
    /**
     * 从 HttpServletRequest 中获取 RequestParams 分页参数
     * <p>Description:              </p>
     * <p>Create Time: 2016年2月23日   </p>
     * @author liandeliang
     * @param request
     * @return
     */
    public static BasePageRequestUrlParams getRequestParam(HttpServletRequest request){
        return getRequestParam(request,BasePageRequestUrlParams.class);
    }
    
    /**
     * 从 HttpServletRequest 中获取 RequestParams 分页参数
     * <p>Description:              </p>
     * <p>Create Time: 2016年2月23日   </p>
     * @author liandeliang
     * @param request
     * @return
     */
    public static <T extends BasePageRequestUrlParams> T getRequestParam(HttpServletRequest request,Class<T> cls){
        T ret = null;
        try {
            ret = cls.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(ret == null)
            return null;
        
        String offsetStr = request.getParameter(SharedConstants.UrlRequestParams.offsetParam);
        int offset = SharedConstants.UrlRequestParams.offsetParam_default;
        if(offsetStr!=null && offsetStr.length()>0)
            offset = Integer.parseInt(offsetStr);
        
        String limitStr = request.getParameter(SharedConstants.UrlRequestParams.limitParam);
        int limit = SharedConstants.UrlRequestParams.limitParam_default;
        if(limitStr!=null && limitStr.length()>0)
            limit = Integer.parseInt(limitStr);
        
        ret.setOffset(offset);
        ret.setLimit(limit);
        
        return ret;
    }
    
    /**
     * 根据分页请求查询分页返回数据	
     * <p>Description:              </p>
     * <p>Create Time: 2016年2月23日   </p>
     * @author liandeliang
     * @param requestPageParams
     * @param list
     * @return
     */
    public static <T> BasePageResponse.Data<T> createPageResponse(BasePageRequestUrlParams requestPageParams, List<T> list){
        BasePageResponse.Data<T> ret = new BasePageResponse.Data<T>();
        
        int listSize = 0;
        if(list!=null)
            listSize = list.size();
        
        PageInfo<T> page = new PageInfo<T>(list);
        
        ret.setList(list);
        
        ret.setListSize(listSize);
        
        // 查询起始，默认：0
        ret.setOffset(requestPageParams.getOffset());
        
        // 限制多少条数，默认：20
        ret.setLimit(requestPageParams.getLimit());
        
        // 总记录数
        ret.setTotalItemsCount((int)page.getTotal());
        
        // 总页数
        ret.setTotalPagesCount(page.getPages());
        
//        page.getFirstPage();
        
        return ret;
    }
    
    /**
     * 分页返回时，对	HttpServletResponse 添加RESTful风格的头
     * <p>Description:              </p>
     * <p>Create Time: 2016年2月23日   </p>
     * @author liandeliang
     * @param data
     * @param response
     */
    public static <T> void handleRestfulResponse(BasePageResponse.Data<T> data, HttpServletResponse response){
        response.addHeader(SharedConstants.HttpHeader.HTTP_TOTAL_COUNT, "" + data.getTotalItemsCount());
    }
}
