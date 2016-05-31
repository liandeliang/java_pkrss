package com.pkrss.server.domain;

import javax.persistence.*;

@Table(name = "pkrss_kv")
public class KV {
    /**
     * key
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String key;

    /**
     * value
     */
    private String value;

    /**
     * 获取key
     *
     * @return key - key
     */
    public String getKey() {
        return key;
    }

    /**
     * 设置key
     *
     * @param key key
     */
    public void setKey(String key) {
        this.key = key == null ? null : key.trim();
    }

    /**
     * 获取value
     *
     * @return value - value
     */
    public String getValue() {
        return value;
    }

    /**
     * 设置value
     *
     * @param value value
     */
    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }
}