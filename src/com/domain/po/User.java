package com.domain.po;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 27608 on 2018/1/14.
 */
public class User implements Serializable {
    private Integer id;//必须写成Integer类型而不是int，double、float同理
    private String email;
    private String name;
    private String password;
    private Integer printCount;
    private String tel;//电话的类型用String
    private Timestamp createTime = new Timestamp(System.currentTimeMillis());//Timastamp类型是最准确的类型，跟数据库里的时间类型一致
    private Timestamp updateTime = new Timestamp(System.currentTimeMillis());
    private Provider provider;//所有用户对应一个商家
    private Set<Document> documents = new HashSet<>();//一个用户有多个文档
    private Set<Order> orders = new HashSet<>();//一个用户有多个订单

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPrintCount() {
        return printCount;
    }

    public void setPrintCount(Integer printCount) {
        this.printCount = printCount;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
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

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Set<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(Set<Document> documents) {
        this.documents = documents;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", printCount=" + printCount +
                ", tel='" + tel + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", provider=" + provider +
                ", documents=" + documents +
                ", orders=" + orders +
                '}';
    }
}
