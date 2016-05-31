package com.pkrss.server.domain;

import java.util.Date;
import javax.persistence.*;

import tk.mybatis.mapper.entity.IDynamicTableName;

@Table
public class Media implements IDynamicTableName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * rss item id
     */
    private Integer iid;

    /**
     * table id
     */
    private Integer tid;

    /**
     * catalog id
     */
    private Integer cid;

    /**
     * item publish date
     */
    private Date pubdate;

    private String url;

    /**
     * is the standard MIME type of the object
     */
    private String type;

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
     * 获取rss item id
     *
     * @return iid - rss item id
     */
    public Integer getIid() {
        return iid;
    }

    /**
     * 设置rss item id
     *
     * @param iid rss item id
     */
    public void setIid(Integer iid) {
        this.iid = iid;
    }

    /**
     * 获取table id
     *
     * @return tid - table id
     */
    public Integer getTid() {
        return tid;
    }

    /**
     * 设置table id
     *
     * @param tid table id
     */
    public void setTid(Integer tid) {
        this.tid = tid;
    }

    /**
     * 获取catalog id
     *
     * @return cid - catalog id
     */
    public Integer getCid() {
        return cid;
    }

    /**
     * 设置catalog id
     *
     * @param cid catalog id
     */
    public void setCid(Integer cid) {
        this.cid = cid;
    }

    /**
     * 获取item publish date
     *
     * @return pubdate - item publish date
     */
    public Date getPubdate() {
        return pubdate;
    }

    /**
     * 设置item publish date
     *
     * @param pubdate item publish date
     */
    public void setPubdate(Date pubdate) {
        this.pubdate = pubdate;
    }

    /**
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 获取is the standard MIME type of the object
     *
     * @return type - is the standard MIME type of the object
     */
    public String getType() {
        return type;
    }

    /**
     * 设置is the standard MIME type of the object
     *
     * @param type is the standard MIME type of the object
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
    
    @Transient
    private Integer dynamicTableLocaleId;

    @Override
    public String getDynamicTableName() {
        return "pkrss_media_l" + dynamicTableLocaleId;
    }

    /**
     * 
     * @param dynamicTableName pkrss_rssitem_lxxx
     */
    public void setDynamicTableLocaleId(Integer dynamicTableLocaleId) {
        this.dynamicTableLocaleId = dynamicTableLocaleId;
    }
}