package org.yuanding.pagination;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageSerializable;

import java.util.List;

public class SimplePageInfo<T> extends PageSerializable<T> {

    //当前页
    private int pageNum;
    //每页的数量
    private int pageSize;
    //总页数
    private int pages;

    //是否有前一页
    private boolean hasPreviousPage = false;
    //是否有下一页
    private boolean hasNextPage = false;


    public SimplePageInfo(List<T> list) {
        super(list);
        if (list instanceof Page) {
            Page page = (Page) list;
            this.pageNum = page.getPageNum();
            this.pageSize = page.getPageSize();
            this.pages = page.getPages();
        } else {
            this.pageNum = 1;
            this.pageSize = list.size();
            this.pages = this.pageSize > 0 ? 1 : 0;
            //判断页面边界
        }
        judgePageBoudary();
    }

    public static <T> SimplePageInfo<T> of(List<T> list) {
        return new SimplePageInfo<T>(list);
    }

    /**
     * 判定页面边界
     */
    private void judgePageBoudary() {
        hasPreviousPage = pageNum > 1;
        hasNextPage = pageNum < pages;
    }


    @JsonProperty("results")
    public List<T> getList() {
        return list;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public boolean isHasPreviousPage() {
        return hasPreviousPage;
    }

    public void setHasPreviousPage(boolean hasPreviousPage) {
        this.hasPreviousPage = hasPreviousPage;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

}