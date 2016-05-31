package com.pkrss.server.service;

import java.util.List;

import com.pkrss.server.http.request.BasePageRequestUrlParams;
import com.pkrss.server.http.response.BasePageResponse;

public interface BaseService<T> {
    /**
     * 
    * @Title: getById 
    * @Description: query by id
    * @param @param id Integer|Long
    * @param @return    data 
    * @return T   return type
    * @throws
     */
    T getById(Object id);

    /**
     * 
    * @Title: addUserSelective 
    * @Description: add record，can check record field is null,only add data field is not null
    * @param @param record
    * @param @return    data
    * @return int    effected row count
    * @throws
     */
    int addSelective(T record);

    /**
     * 
    * @Title: removeById 
    * @Description: 
    * @param @param id
    * @param @return    
    * @return int    effected row count
    * @throws
     */
    int removeById(Object id);

    /**
     * 
    * @Title: modifyByIdSelective 
    * @Description: 
    * @param @param record
    * @param @return     
    * @return int    effected row count
    * @throws
     */
    int modifyByIdSelective(T record);
    
    /**
     * 
    * @Title: updateByPrimaryKey 
    * @Description: 
    * @param @param record
    * @param @return    
    * @return int    effected row count
    * @throws
     */
    int updateByPrimaryKey(T record);
    
    /**
     * select all data
     * <p>Description:              </p>
     * @author liandeliang
     * @return
     */
    List<T> selectAll();
    
    /**
     * select many data, have pager function
     * <p>Description:              </p>
     * @author liandeliang
     * @param offset offset value, default 0
     * @param limit limit max return count
     * @return
     */
    List<T> selectAll(int offset, int limit);
    
    /**
     * select many data, have pager function
     * <p>Description:              </p>
     * @author liandeliang
     * @param requestPageParams
     * @return
     */
    BasePageResponse.Data<T> selectAll(BasePageRequestUrlParams requestPageParams);
}