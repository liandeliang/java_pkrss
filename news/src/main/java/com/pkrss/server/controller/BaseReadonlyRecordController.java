package com.pkrss.server.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.pkrss.server.http.request.BasePageRequestUrlParams;
import com.pkrss.server.http.response.BasePageResponse;
import com.pkrss.server.http.response.BaseResponse;
import com.pkrss.server.http.response.EmptyResponse;
import com.pkrss.server.service.BaseService;
import com.pkrss.server.share.ResponseCode;
import com.pkrss.server.utils.PageUtil;
import com.pkrss.server.utils.ResponseUtils;

/**
 * 
 * <p>Title: 基础信息处理         </p>
 * <p>Description: Function Description </p>
 * <p>Copyright: Copyright (c) 2016     </p>
 * <p>Company: YJS Co., Ltd.     </p>
 * <p>Create Time: 2016年4月5日           </p>
 * @author liandeliang
 */
abstract class BaseReadonlyRecordController<T> {

    @Autowired
    protected BaseService<T> baseService;
    
    /**
     * 查询列表	
     * <p>Description:              </p>
     * <p>Create Time: 2016年4月6日   </p>
     * @author liandeliang
     * @param request
     * @param response
     * @return
     */
    @SuppressWarnings("unchecked")
    protected BasePageResponse<T> _getRecords(HttpServletRequest request, HttpServletResponse response) {
        try{
            // 设置分页参数
            
            BasePageRequestUrlParams basePageRequestUrlParams = PageUtil.getRequestParam(request);
            
            BasePageResponse.Data<T> data = baseService.selectAll(basePageRequestUrlParams);
            
            // 分页返回时，对  HttpServletResponse 添加RESTful风格的头
            PageUtil.handleRestfulResponse(data, response);
            
            // 返回成功
            return ResponseUtils.success(request, data, BasePageResponse.class);
            
        }catch(Exception e){
            // 返回错误
            return ResponseUtils.fail(request, e, BasePageResponse.class);
        }
    }

    /**
     * 查询纪录	
     * <p>Description:              </p>
     * <p>Create Time: 2016年4月6日   </p>
     * @author liandeliang
     * @param request
     * @param id
     * @return
     */
    @SuppressWarnings("unchecked")
    protected BaseResponse<T> _getRecordByID(HttpServletRequest request, @PathVariable Integer id) {
        try{
            T data = baseService.getById(id);
            
            return ResponseUtils.success(request, data, BaseResponse.class);
            
        }catch(Exception e){
            // 返回错误
            return ResponseUtils.fail(request, e, BaseResponse.class);
        }
    }
    
    /**
     * 添加纪录	
     * <p>Description:              </p>
     * <p>Create Time: 2016年4月6日   </p>
     * @author liandeliang
     * @param request
     * @param record
     * @return
     */
    @SuppressWarnings("unchecked")
    protected BaseResponse<T> _addRecord(HttpServletRequest request, @RequestBody T record){

        try{            
            if(baseService.addSelective(record) > 0){                
                return ResponseUtils.success(request, record, BaseResponse.class);                
            }
            
            return ResponseUtils.fail(request, BaseResponse.class);
            
        }catch(Exception e){
            // 返回错误
            return ResponseUtils.fail(request, e, BaseResponse.class);
        }
    }

    /**
     * 更新纪录	
     * <p>Description: 因为record是模板对象，没有setId.             </p>
     * <p>Create Time: 2016年4月6日   </p>
     * @author liandeliang
     * @param request
     * @param record
     * @param id
     * @return
     */
    @SuppressWarnings("unchecked")
    protected BaseResponse<T> _updateRecord(HttpServletRequest request, @RequestBody T record) {
        try{
            // 摩棒美
//            record.setId(id);
            
            if(baseService.modifyByIdSelective(record) > 0){
                
                return ResponseUtils.success(request, record, BaseResponse.class);
            }
            
            return ResponseUtils.fail(request, BaseResponse.class);
            
        }catch(Exception e){
            // 返回错误
            return ResponseUtils.fail(request, e, BaseResponse.class);
        }
    }

    /**
     * 删除纪录	
     * <p>Description:              </p>
     * <p>Create Time: 2016年4月6日   </p>
     * @author liandeliang
     * @param request
     * @param id
     * @return
     */
    protected EmptyResponse _deleteRecord(HttpServletRequest request, @PathVariable Integer id) {
        try{
            T record = baseService.getById(id);
            if(record==null)
                return ResponseUtils.fail(request, ResponseCode.DataNotExist, EmptyResponse.class);
            
            int rows = baseService.removeById(id);
            
            if(rows > 0){                
                return ResponseUtils.success(request, null, EmptyResponse.class);
            }
            
            return ResponseUtils.fail(request, ResponseCode.DataNotExist, EmptyResponse.class);
            
        }catch(Exception e){
            // 返回错误
            return ResponseUtils.fail(request, e, EmptyResponse.class);
        }
    }
    
//  /**
//   * 列表返回类
//   * <p>Title: Module Information         </p>
//   * <p>Description: Function Description </p>
//   * <p>Copyright: Copyright (c) 2016     </p>
//   * <p>Company: YJS Co., Ltd.     </p>
//   * <p>Create Time: 2016年4月6日           </p>
//   * @author liandeliang
//   */
//  public static final class GetRecordsResponse <T> extends BasePageResponse<T>{        
//      private static final long serialVersionUID = 1L;
//  }
//  
//  /**
//   * 纪录返回类
//   * <p>Title: Module Information         </p>
//   * <p>Description: Function Description </p>
//   * <p>Copyright: Copyright (c) 2016     </p>
//   * <p>Company: YJS Co., Ltd.     </p>
//   * <p>Create Time: 2016年4月6日           </p>
//   * @author liandeliang
//   */
//  public static final class RecordDetailResponse <T> extends BaseResponse<T>{
//      private static final long serialVersionUID = 1L;
//  }
}