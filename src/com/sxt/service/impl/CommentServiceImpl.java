package com.sxt.service.impl;

import com.sxt.bean.Comment;
import com.sxt.dao.CommentDao;
import com.sxt.dao.impl.CommentDaoImpl;
import com.sxt.service.CommentService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommentServiceImpl implements CommentService {


    private CommentDao commentDao = new CommentDaoImpl();


    @Override
    public Map<String, Object> selectCommentsByGoodsId(Integer goodsId, Integer page, Integer size) {

        //1.查询总数
        long count = commentDao.selectCountByGoodsId(goodsId);


        //2.查询当前页的结果
        List<Comment> comments = commentDao.selectCommentsByGoodsId(goodsId,page,size);


        //创建Map集合封装总数和结果
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("count",count);
        resultMap.put("data",comments);


        return resultMap;
    }
}
