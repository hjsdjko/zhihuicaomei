package com.dao;

import com.entity.CaomeiCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.CaomeiCollectionView;

/**
 * 草莓收藏 Dao 接口
 *
 * @author 
 */
public interface CaomeiCollectionDao extends BaseMapper<CaomeiCollectionEntity> {

   List<CaomeiCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
