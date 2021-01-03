package com.cxh.bean;

import java.io.Serializable;

/**
 * 商品的模型类
 */
public class Goods implements Serializable {
    private Integer goodsId;
    private String  goodsName;
    private String  goodsImg;
    private Integer status;
    private Integer saleNum;
    private Integer typeId;
    private Double  goodsPrice;
    private Integer isHot;
    private Integer isNew;

    private String[] goodsImgs;


    public String[] getGoodsImgs() {
        return goodsImgs;
    }

    public void setGoodsImgs(String[] goodsImgs) {
        this.goodsImgs = goodsImgs;
    }

    public Goods() {
    }
    public Goods(Integer goodsId, String goodsName, String goodsImg, Integer status, Integer saleNum, Integer typeId, Double goodsPrice, Integer isHot, Integer isNew) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsImg = goodsImg;
        this.status = status;
        this.saleNum = saleNum;
        this.typeId = typeId;
        this.goodsPrice = goodsPrice;
        this.isHot = isHot;
        this.isNew = isNew;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(Integer saleNum) {
        this.saleNum = saleNum;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Integer getIsHot() {
        return isHot;
    }

    public void setIsHot(Integer isHot) {
        this.isHot = isHot;
    }

    public Integer getIsNew() {
        return isNew;
    }

    public void setIsNew(Integer isNew) {
        this.isNew = isNew;
    }
}
