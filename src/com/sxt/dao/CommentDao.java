package com.sxt.dao;

import com.sxt.bean.Comment;

import java.util.List;

public interface CommentDao {
    /**
     * 根据商品id查询出评论总数
     * @param goodsId 商品id
     * @return 评论总数
     */
    long selectCountByGoodsId(Integer goodsId);

    /**
     * 根据商品id查询出当前页结果
     * @param goodsId 商品id
     * @param page 页码
     * @param size 每页条数
     * @return
     */
    List<Comment> selectCommentsByGoodsId(Integer goodsId, Integer page, Integer size);
}
