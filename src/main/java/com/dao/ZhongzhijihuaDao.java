package com.dao;

import com.entity.ZhongzhijihuaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhongzhijihuaView;

/**
 * 种植计划 Dao 接口
 *
 * @author 
 */
public interface ZhongzhijihuaDao extends BaseMapper<ZhongzhijihuaEntity> {

   List<ZhongzhijihuaView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
