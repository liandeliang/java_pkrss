package com.pkrss.server.domain;

import javax.persistence.*;

@Table(name = "pkrss_rsstable")
public class RssTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer catalogid;

    private String title;

    private String url;

    /**
     * 空:rss rob1:1号机器人处理
     */
    private String type;

    /**
     * 0:system 1:user can delete
     */
    private Integer level;

    /**
     * 0:no log 1:ok <0:error >10 http error code
     */
    private Integer status;

    /**
     * last item date,null is no items
     */
    @Column(name = "item_lastpubdate")
    private String itemLastpubdate;

    /**
     * last access date,null is not accessed
     */
    private String lastaccessdate;

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
     * @return catalogid
     */
    public Integer getCatalogid() {
        return catalogid;
    }

    /**
     * @param catalogid
     */
    public void setCatalogid(Integer catalogid) {
        this.catalogid = catalogid;
    }

    /**
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
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
     * 获取空:rss rob1:1号机器人处理
     *
     * @return type - 空:rss rob1:1号机器人处理
     */
    public String getType() {
        return type;
    }

    /**
     * 设置空:rss rob1:1号机器人处理
     *
     * @param type 空:rss rob1:1号机器人处理
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 获取0:system 1:user can delete
     *
     * @return level - 0:system 1:user can delete
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * 设置0:system 1:user can delete
     *
     * @param level 0:system 1:user can delete
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * 获取0:no log 1:ok <0:error >10 http error code
     *
     * @return status - 0:no log 1:ok <0:error >10 http error code
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置0:no log 1:ok <0:error >10 http error code
     *
     * @param status 0:no log 1:ok <0:error >10 http error code
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取last item date,null is no items
     *
     * @return item_lastpubdate - last item date,null is no items
     */
    public String getItemLastpubdate() {
        return itemLastpubdate;
    }

    /**
     * 设置last item date,null is no items
     *
     * @param itemLastpubdate last item date,null is no items
     */
    public void setItemLastpubdate(String itemLastpubdate) {
        this.itemLastpubdate = itemLastpubdate == null ? null : itemLastpubdate.trim();
    }

    /**
     * 获取last access date,null is not accessed
     *
     * @return lastaccessdate - last access date,null is not accessed
     */
    public String getLastaccessdate() {
        return lastaccessdate;
    }

    /**
     * 设置last access date,null is not accessed
     *
     * @param lastaccessdate last access date,null is not accessed
     */
    public void setLastaccessdate(String lastaccessdate) {
        this.lastaccessdate = lastaccessdate == null ? null : lastaccessdate.trim();
    }
}