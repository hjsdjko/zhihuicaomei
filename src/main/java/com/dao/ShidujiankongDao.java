package com.dao;

import com.entity.ShidujiankongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShidujiankongView;

/**
 * 湿度监控 Dao 接口
 *
 * @author 
 */
public interface ShidujiankongDao extends BaseMapper<ShidujiankongEntity> {

   List<ShidujiankongView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
