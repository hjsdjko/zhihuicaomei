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
import com.dao.CaomeiOrderDao;
import com.entity.CaomeiOrderEntity;
import com.service.CaomeiOrderService;
import com.entity.view.CaomeiOrderView;

/**
 * 草莓订单 服务实现类
 */
@Service("caomeiOrderService")
@Transactional
public class CaomeiOrderServiceImpl extends ServiceImpl<CaomeiOrderDao, CaomeiOrderEntity> implements CaomeiOrderService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        Page<CaomeiOrderView> page =new Query<CaomeiOrderView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
