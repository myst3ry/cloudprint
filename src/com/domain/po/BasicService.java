package com.domain.po;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 27608 on 2018/1/14.
 */
public class BasicService {
    private  Integer id;
    private  String paperType;
    private  String colorType;
    private  String singleDouble;
    private  Double price;
    private  Timestamp createTime = new Timestamp(System.currentTimeMillis());
    private  Timestamp updateTime = new Timestamp(System.currentTimeMillis());
    private  Set<Config> configs = new HashSet<>();//一个基础服务可以被多个配置应用

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPaperType() {
        return paperType;
    }

    public void setPaperType(String paperType) {
        this.paperType = paperType;
    }

    public String getColorType() {
        return colorType;
    }

    public void setColorType(String colorType) {
        this.colorType = colorType;
    }

    public String getSingleDouble() {
        return singleDouble;
    }

    public void setSingleDouble(String singleDouble) {
        this.singleDouble = singleDouble;
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
