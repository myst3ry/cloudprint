package com.domain.po;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 27608 on 2018/1/14.
 */
public class AdvancedService {
    private Integer id;
    private String content;
    private Double price;
    private Timestamp createTime = new Timestamp(System.currentTimeMillis());
    private Timestamp updateTime = new Timestamp(System.currentTimeMillis());
    private Set<Config> configs = new HashSet<>();//一个高级服务可以被多个配置应用

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Set<Config> getConfigs() {
        return configs;
    }

    public void setConfigs(Set<Config> configs) {
        this.configs = configs;
    }
}
