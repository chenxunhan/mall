package com.sxt.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class Comment {

    private Integer commentId;
    private String userImg;
    private String comment;

    /**
     * 设置响应json数据格式
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date commentDate;
    private Integer goodsId;
    private int star;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }


    public Comment() {
    }
}
