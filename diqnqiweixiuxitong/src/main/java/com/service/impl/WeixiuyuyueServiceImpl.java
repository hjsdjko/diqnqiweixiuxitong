package com.service.impl;

import com.utils.StringUtil;
import com.service.DictionaryService;
import com.utils.ClazzDiff;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import com.dao.WeixiuyuyueDao;
import com.entity.WeixiuyuyueEntity;
import com.service.WeixiuyuyueService;
import com.entity.view.WeixiuyuyueView;

/**
 * 物品维修预约 服务实现类
 */
@Service("weixiuyuyueService")
@Transactional
public class WeixiuyuyueServiceImpl extends ServiceImpl<WeixiuyuyueDao, WeixiuyuyueEntity> implements WeixiuyuyueService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        Page<WeixiuyuyueView> page =new Query<WeixiuyuyueView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
