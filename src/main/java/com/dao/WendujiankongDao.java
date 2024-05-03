package com.dao;

import com.entity.WendujiankongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.WendujiankongView;

/**
 * 温度监控 Dao 接口
 *
 * @author 
 */
public interface WendujiankongDao extends BaseMapper<WendujiankongEntity> {

   List<WendujiankongView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
