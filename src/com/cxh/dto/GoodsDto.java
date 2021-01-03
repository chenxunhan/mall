package com.cxh.dto;

/**
 * 接收页面上传过来的参数
 */
public class GoodsDto {

    //查询的关键字
    private String keywords;
    //商品类型  0 查询所有类型
    private Integer typeId;
    //价格的排序规则   0 正常  1 价格升序  2价格降序
    private Integer priceSortType;

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getPriceSortType() {
        return priceSortType;
    }

    public void setPriceSortType(Integer priceSortType) {
        this.priceSortType = priceSortType;
    }
}
