package com.nowcoder.community.entity;

/**
 * 封装分页相关的信息
 */
public class Page {

    private int current = 1;  // 当前页码
    private int limit = 10;  // 显示上限，每页显示多少个数据
    private int rows;  // 数据总数，用于计算总页数
    private String path;  // 查询路径(用于复用分页链接）

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        if (current >= 1) {
            this.current = current;
        }
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if (limit >= 1 && limit <= 100) {
            this.limit = limit;
        }
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        if (rows >= 0) {
            this.rows = rows;
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 获取当前页的起始行
     * @return
     */
    public int getOffset() {
        // current * limit - limit
        return (current - 1) * limit;
    }

    /**
     * 获取总的页数
     * @return
     */
    public int getTotal() {
        return rows % limit == 0 ? rows / limit : rows / limit + 1;
    }

    /**
     * 获取起始页码
     * @return
     */
    public int getFrom() {
        int from = current - 2;
        return from < 1 ? 1 : from;
    }

    /**
     * 获取终止页码
     * @return
     */
    public int getTo() {
        int to = current + 2;
        return to > getTotal() ? getTotal() : to;
    }
}
