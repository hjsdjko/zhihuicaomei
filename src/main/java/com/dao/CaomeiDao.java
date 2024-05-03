package com.dao;

import com.entity.CaomeiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.CaomeiView;

/**
 * 草莓 Dao 接口
 *
 * @author 
 */
public interface CaomeiDao extends BaseMapper<CaomeiEntity> {

   List<CaomeiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
