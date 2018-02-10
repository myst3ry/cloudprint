package com.domain.po;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 27608 on 2018/1/14.
 */
public class Order {
    private  Integer id;
    private Double totalPrice;
    private String status;
    private Timestamp createTime = new Timestamp(System.currentTimeMillis());
    private Timestamp updateTime = new Timestamp(System.currentTimeMillis());
    private User user;//一个订单属于一个用户
    private Set<Config> configs= new HashSet<>();//一个订单拥有多个配置

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Config> getConfigs() {
        return configs;
    }

    public void setConfigs(Set<Config> configs) {
        this.configs = configs;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", totalPrice=" + totalPrice +
                ", status='" + status + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", user=" + user +
                ", configs=" + configs +
                '}';
    }
}
