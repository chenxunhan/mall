package com.sxt.dao.impl;

import com.sxt.bean.Comment;
import com.sxt.dao.CommentDao;
import com.sxt.utils.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommentDaoImpl implements CommentDao {
    @Override
    public long selectCountByGoodsId(Integer goodsId) {

        String sql = "select count(*) from tb_comment where goods_id = ?";

        ResultSet rs = DBUtils.executeQuery(sql, goodsId);
        try {
            if(rs.next()){
                int rows = rs.getInt(1);
                return rows;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return 0;
    }

    @Override
    public List<Comment> selectCommentsByGoodsId(Integer goodsId, Integer page, Integer size) {

        //计算起始索引
        int beginIndex = (page - 1) * size;

        String sql = "select * from tb_comment where goods_id = ? limit ?,?";

        ResultSet rs = DBUtils.executeQuery(sql, goodsId, beginIndex, size);

        try {

            List<Comment> comments = new ArrayList<>();

            while (rs.next()){

                Comment comment = new Comment();
                comment.setGoodsId(goodsId);
                comment.setComment(rs.getString("comment"));
                comment.setUserImg(rs.getString("user_img"));
                comment.setCommentDate(rs.getDate("comment_date"));
                comment.setStar(rs.getInt("star"));
                comment.setUsername(rs.getString("username"));

                comments.add(comment);
            }
            return  comments;
        } catch (Exception e){
            e.printStackTrace();
        }


        return null;
    }
}
