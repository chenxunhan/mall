package com.cxh.bean;

import java.io.Serializable;

/**
 * 商品类型实体
 */
public class GoodsType implements Serializable {

    private Integer id;
    private String name;
    private Integer status;
    public GoodsType() {
    }

    public GoodsType(Integer id, String name, Integer status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
