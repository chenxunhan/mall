package com.cxh.service;

import java.util.Map;

public interface CommentService {
    /**
     * 根据商品id查询对应的评论信息
     * @param goodsId 商品id
     * @param page 页码默认1
     * @param size 每页条数
     * @return  查询结果（包含每页评论和评论总数）
     */
    Map<String, Object> selectCommentsByGoodsId(Integer goodsId, Integer page, Integer size);
}
