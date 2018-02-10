package com.domain.po;

import java.util.List;

/**
 * Created by Mystery on 2018/2/1.
 */
public class Pager<E> {
    private Integer pageIndex;//第几页
    private Integer pageOffset;//分页开始值
    private Integer pageSize;//每页显示多少条
    private Integer totalRecord;//共多少条
    private Integer totalPage;//共多少页
    private List<E> datas;//存数据

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageOffset() {
        return pageOffset;
    }

    public void setPageOffset(Integer pageOffset) {
        this.pageOffset = pageOffset;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(Integer totalRecord) {
        this.totalRecord = totalRecord;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<E> getDatas() {
        return datas;
    }

    public void setDatas(List<E> date) {
        this.datas = date;
    }
}
