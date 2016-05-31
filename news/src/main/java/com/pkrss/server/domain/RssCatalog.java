package com.pkrss.server.domain;

import javax.persistence.*;

@Table(name = "pkrss_rsscatalog")
public class RssCatalog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String text;

    private Integer localeid;

    /**
     * 类别,1:表示rss,2:故事书
     */
    private Integer type;

    /**
     * catalog class
     */
    private String key;

    /**
     * translated
     */
    private Integer translate;

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
     * @return text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text
     */
    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    /**
     * @return localeid
     */
    public Integer getLocaleid() {
        return localeid;
    }

    /**
     * @param localeid
     */
    public void setLocaleid(Integer localeid) {
        this.localeid = localeid;
    }

    /**
     * 获取类别,1:表示rss,2:故事书
     *
     * @return type - 类别,1:表示rss,2:故事书
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置类别,1:表示rss,2:故事书
     *
     * @param type 类别,1:表示rss,2:故事书
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取catalog class
     *
     * @return key - catalog class
     */
    public String getKey() {
        return key;
    }

    /**
     * 设置catalog class
     *
     * @param key catalog class
     */
    public void setKey(String key) {
        this.key = key == null ? null : key.trim();
    }

    /**
     * 获取translated
     *
     * @return translate - translated
     */
    public Integer getTranslate() {
        return translate;
    }

    /**
     * 设置translated
     *
     * @param translate translated
     */
    public void setTranslate(Integer translate) {
        this.translate = translate;
    }
}