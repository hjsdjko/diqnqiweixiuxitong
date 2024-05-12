package com.dao;

import com.entity.WeixiudingdanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.WeixiudingdanView;

/**
 * 物品维修订单 Dao 接口
 *
 * @author 
 */
public interface WeixiudingdanDao extends BaseMapper<WeixiudingdanEntity> {

   List<WeixiudingdanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
