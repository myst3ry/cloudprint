package com.domain.po;

import java.sql.Timestamp;

/**
 * Created by Mystery on 2018/1/23.
 */
public class Config {
    private Integer id;
    private Integer copyNum;
    private Double price;
    private Timestamp createTime = new Timestamp(System.currentTimeMillis());
    private Timestamp updateTime = new Timestamp(System.currentTimeMillis());
    private Order order;//一个配置属于一个订单
    private Document document;//一个配置对应一个文档
    private BasicService basicService;//一个配置对应一个基础服务
    private AdvancedService advancedService;//一个配置对应一个高级服务

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCopyNum() {
        return copyNum;
    }

    public void setCopyNum(Integer copyNum) {
        this.copyNum = copyNum;
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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public BasicService getBasicService() {
        return basicService;
    }

    public void setBasicService(BasicService basicService) {
        this.basicService = basicService;
    }

    public AdvancedService getAdvancedService() {
        return advancedService;
    }

    public void setAdvancedService(AdvancedService advancedService) {
        this.advancedService = advancedService;
    }
}
