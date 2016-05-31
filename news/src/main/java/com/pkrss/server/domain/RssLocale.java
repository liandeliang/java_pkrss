package com.pkrss.server.domain;

import javax.persistence.*;

@Table(name = "pkrss_rsslocale")
public class RssLocale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String locale;

    private String country;

    private String encoding;

    private Integer ucatid;

    /**
     * 功能可用标志 0:暂不可用. 1可用. 
     */
    private Integer rssstatus;

    /**
     * 时区
     */
    private String timezone;

    /**
     * english name
     */
    private String en;

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
     * @return locale
     */
    public String getLocale() {
        return locale;
    }

    /**
     * @param locale
     */
    public void setLocale(String locale) {
        this.locale = locale == null ? null : locale.trim();
    }

    /**
     * @return country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country
     */
    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    /**
     * @return encoding
     */
    public String getEncoding() {
        return encoding;
    }

    /**
     * @param encoding
     */
    public void setEncoding(String encoding) {
        this.encoding = encoding == null ? null : encoding.trim();
    }

    /**
     * @return ucatid
     */
    public Integer getUcatid() {
        return ucatid;
    }

    /**
     * @param ucatid
     */
    public void setUcatid(Integer ucatid) {
        this.ucatid = ucatid;
    }

    /**
     * 获取功能可用标志 0:暂不可用. 1可用. 
     *
     * @return rssstatus - 功能可用标志 0:暂不可用. 1可用. 
     */
    public Integer getRssstatus() {
        return rssstatus;
    }

    /**
     * 设置功能可用标志 0:暂不可用. 1可用. 
     *
     * @param rssstatus 功能可用标志 0:暂不可用. 1可用. 
     */
    public void setRssstatus(Integer rssstatus) {
        this.rssstatus = rssstatus;
    }

    /**
     * 获取时区
     *
     * @return timezone - 时区
     */
    public String getTimezone() {
        return timezone;
    }

    /**
     * 设置时区
     *
     * @param timezone 时区
     */
    public void setTimezone(String timezone) {
        this.timezone = timezone == null ? null : timezone.trim();
    }

    /**
     * 获取english name
     *
     * @return en - english name
     */
    public String getEn() {
        return en;
    }

    /**
     * 设置english name
     *
     * @param en english name
     */
    public void setEn(String en) {
        this.en = en == null ? null : en.trim();
    }
}