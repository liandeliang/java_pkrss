package com.pkrss.server.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "pkrss_rsstable_mv")
public class RssTableMv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * pkrss_rsstable.id
     */
    private Integer tid;

    /**
     * new category id, pkrss_rsscategory.id
     */
    private Integer cid;

    private Integer count;

    /**
     * 0:no handle 1:apprived -1:deny
     */
    private Integer status;

    /**
     * create time
     */
    @Column(name = "createTime")
    private Date createtime;

    /**
     * last update time
     */
    @Column(name = "updateTime")
    private Date updatetime;

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
     * 获取pkrss_rsstable.id
     *
     * @return tid - pkrss_rsstable.id
     */
    public Integer getTid() {
        return tid;
    }

    /**
     * 设置pkrss_rsstable.id
     *
     * @param tid pkrss_rsstable.id
     */
    public void setTid(Integer tid) {
        this.tid = tid;
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
     * @return count
     */
    public Integer getCount() {
        return count;
    }

    /**
     * @param count
     */
    public void setCount(Integer count) {
        this.count = count;
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
     * 获取create time
     *
     * @return createTime - create time
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置create time
     *
     * @param createtime create time
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取last update time
     *
     * @return updateTime - last update time
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * 设置last update time
     *
     * @param updatetime last update time
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}