package com.dao;

import com.entity.CaomeiCommentbackEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.CaomeiCommentbackView;

/**
 * 草莓评价 Dao 接口
 *
 * @author 
 */
public interface CaomeiCommentbackDao extends BaseMapper<CaomeiCommentbackEntity> {

   List<CaomeiCommentbackView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
