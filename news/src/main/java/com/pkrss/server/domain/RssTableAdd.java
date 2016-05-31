package com.pkrss.server.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "pkrss_rsstable_add")
public class RssTableAdd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * new category id, pkrss_rsscategory.id
     */
    private Integer cid;

    /**
     * url
     */
    private String url;

    private String type;

    /**
     * 0:no handle 1:apprived -1:deny
     */
    private Integer status;

    /**
     * last update time
     */
    @Column(name = "createTime")
    private Date createtime;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取new category id, pkrss_rsscategory.id
     *
     * @return cid - new category id, pkrss_rsscategory.id
     */
    public Integer getCid() {
        return cid;
    }

    /**
     * 设置new category id, pkrss_rsscategory.id
     *
     * @param cid new category id, pkrss_rsscategory.id
     */
    public void setCid(Integer cid) {
        this.cid = cid;
    }

    /**
     * 获取url
     *
     * @return url - url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置url
     *
     * @param url url
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 获取0:no handle 1:apprived -1:deny
     *
     * @return status - 0:no handle 1:apprived -1:deny
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置0:no handle 1:apprived -1:deny
     *
     * @param status 0:no handle 1:apprived -1:deny
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取last update time
     *
     * @return createTime - last update time
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置last update time
     *
     * @param createtime last update time
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}