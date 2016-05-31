package com.pkrss.server.domain;

import java.util.Date;
import javax.persistence.*;

import tk.mybatis.mapper.entity.IDynamicTableName;

@Table
public class RssItem implements IDynamicTableName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer tid;

    /**
     * pkrss_rsscatalog.id
     */
    private Integer cid;

    @Column(name = "item_pubdate")
    private Date itemPubdate;

    @Column(name = "item_title")
    private String itemTitle;

    @Column(name = "item_desc")
    private String itemDesc;

    @Column(name = "item_link")
    private String itemLink;

    @Column(name = "item_authors")
    private String itemAuthors;

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
     * @return tid
     */
    public Integer getTid() {
        return tid;
    }

    /**
     * @param tid
     */
    public void setTid(Integer tid) {
        this.tid = tid;
    }

    /**
     * 获取pkrss_rsscatalog.id
     *
     * @return cid - pkrss_rsscatalog.id
     */
    public Integer getCid() {
        return cid;
    }

    /**
     * 设置pkrss_rsscatalog.id
     *
     * @param cid pkrss_rsscatalog.id
     */
    public void setCid(Integer cid) {
        this.cid = cid;
    }

    /**
     * @return item_pubdate
     */
    public Date getItemPubdate() {
        return itemPubdate;
    }

    /**
     * @param itemPubdate
     */
    public void setItemPubdate(Date itemPubdate) {
        this.itemPubdate = itemPubdate;
    }

    /**
     * @return item_title
     */
    public String getItemTitle() {
        return itemTitle;
    }

    /**
     * @param itemTitle
     */
    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle == null ? null : itemTitle.trim();
    }

    /**
     * @return item_desc
     */
    public String getItemDesc() {
        return itemDesc;
    }

    /**
     * @param itemDesc
     */
    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc == null ? null : itemDesc.trim();
    }

    /**
     * @return item_link
     */
    public String getItemLink() {
        return itemLink;
    }

    /**
     * @param itemLink
     */
    public void setItemLink(String itemLink) {
        this.itemLink = itemLink == null ? null : itemLink.trim();
    }

    /**
     * @return item_authors
     */
    public String getItemAuthors() {
        return itemAuthors;
    }

    /**
     * @param itemAuthors
     */
    public void setItemAuthors(String itemAuthors) {
        this.itemAuthors = itemAuthors == null ? null : itemAuthors.trim();
    }
    
    @Transient
    private Integer dynamicTableLocaleId;

    @Override
    public String getDynamicTableName() {
        return "pkrss_rssitem_l" + dynamicTableLocaleId;
    }

    /**
     * 
     * @param dynamicTableName pkrss_rssitem_lxxx
     */
    public void setDynamicTableLocaleId(Integer dynamicTableLocaleId) {
        this.dynamicTableLocaleId = dynamicTableLocaleId;
    }
}