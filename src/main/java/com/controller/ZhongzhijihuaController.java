
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 种植计划
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/zhongzhijihua")
public class ZhongzhijihuaController {
    private static final Logger logger = LoggerFactory.getLogger(ZhongzhijihuaController.class);

    private static final String TABLE_NAME = "zhongzhijihua";

    @Autowired
    private ZhongzhijihuaService zhongzhijihuaService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private AddressService addressService;//收货地址
    @Autowired
    private CaomeiService caomeiService;//草莓
    @Autowired
    private CaomeiCollectionService caomeiCollectionService;//草莓收藏
    @Autowired
    private CaomeiCommentbackService caomeiCommentbackService;//草莓评价
    @Autowired
    private CaomeiOrderService caomeiOrderService;//草莓订单
    @Autowired
    private CartService cartService;//购物车
    @Autowired
    private DictionaryService dictionaryService;//字典表
    @Autowired
    private GonggaoService gonggaoService;//公告信息
    @Autowired
    private ShidujiankongService shidujiankongService;//湿度监控
    @Autowired
    private WendujiankongService wendujiankongService;//温度监控
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private YujingService yujingService;//病虫害预警
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = zhongzhijihuaService.queryPage(params);

        //字典表数据转换
        List<ZhongzhijihuaView> list =(List<ZhongzhijihuaView>)page.getList();
        for(ZhongzhijihuaView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ZhongzhijihuaEntity zhongzhijihua = zhongzhijihuaService.selectById(id);
        if(zhongzhijihua !=null){
            //entity转view
            ZhongzhijihuaView view = new ZhongzhijihuaView();
            BeanUtils.copyProperties( zhongzhijihua , view );//把实体数据重构到view中
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ZhongzhijihuaEntity zhongzhijihua, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,zhongzhijihua:{}",this.getClass().getName(),zhongzhijihua.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ZhongzhijihuaEntity> queryWrapper = new EntityWrapper<ZhongzhijihuaEntity>()
            .eq("zhongzhijihua_name", zhongzhijihua.getZhongzhijihuaName())
            .eq("zhongzhijihua_address", zhongzhijihua.getZhongzhijihuaAddress())
            .eq("zhongzhijihua_types", zhongzhijihua.getZhongzhijihuaTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhongzhijihuaEntity zhongzhijihuaEntity = zhongzhijihuaService.selectOne(queryWrapper);
        if(zhongzhijihuaEntity==null){
            zhongzhijihua.setInsertTime(new Date());
            zhongzhijihua.setCreateTime(new Date());
            zhongzhijihuaService.insert(zhongzhijihua);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ZhongzhijihuaEntity zhongzhijihua, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,zhongzhijihua:{}",this.getClass().getName(),zhongzhijihua.toString());
        ZhongzhijihuaEntity oldZhongzhijihuaEntity = zhongzhijihuaService.selectById(zhongzhijihua.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(zhongzhijihua.getZhongzhijihuaFile()) || "null".equals(zhongzhijihua.getZhongzhijihuaFile())){
                zhongzhijihua.setZhongzhijihuaFile(null);
        }
        if("".equals(zhongzhijihua.getZhongzhijihuaContent()) || "null".equals(zhongzhijihua.getZhongzhijihuaContent())){
                zhongzhijihua.setZhongzhijihuaContent(null);
        }

            zhongzhijihuaService.updateById(zhongzhijihua);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ZhongzhijihuaEntity> oldZhongzhijihuaList =zhongzhijihuaService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        zhongzhijihuaService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<ZhongzhijihuaEntity> zhongzhijihuaList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            ZhongzhijihuaEntity zhongzhijihuaEntity = new ZhongzhijihuaEntity();
//                            zhongzhijihuaEntity.setZhongzhijihuaUuidNumber(data.get(0));                    //种植计划编号 要改的
//                            zhongzhijihuaEntity.setZhongzhijihuaName(data.get(0));                    //计划标题 要改的
//                            zhongzhijihuaEntity.setZhongzhijihuaAddress(data.get(0));                    //计划地点 要改的
//                            zhongzhijihuaEntity.setZhongzhijihuaFile(data.get(0));                    //附件 要改的
//                            zhongzhijihuaEntity.setZhongzhijihuaTypes(Integer.valueOf(data.get(0)));   //种植计划类型 要改的
//                            zhongzhijihuaEntity.setZhongzhijihuaKaishiTime(sdf.parse(data.get(0)));          //计划开始时间 要改的
//                            zhongzhijihuaEntity.setZhongzhijihuaContent("");//详情和图片
//                            zhongzhijihuaEntity.setInsertTime(date);//时间
//                            zhongzhijihuaEntity.setCreateTime(date);//时间
                            zhongzhijihuaList.add(zhongzhijihuaEntity);


                            //把要查询是否重复的字段放入map中
                                //种植计划编号
                                if(seachFields.containsKey("zhongzhijihuaUuidNumber")){
                                    List<String> zhongzhijihuaUuidNumber = seachFields.get("zhongzhijihuaUuidNumber");
                                    zhongzhijihuaUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> zhongzhijihuaUuidNumber = new ArrayList<>();
                                    zhongzhijihuaUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("zhongzhijihuaUuidNumber",zhongzhijihuaUuidNumber);
                                }
                        }

                        //查询是否重复
                         //种植计划编号
                        List<ZhongzhijihuaEntity> zhongzhijihuaEntities_zhongzhijihuaUuidNumber = zhongzhijihuaService.selectList(new EntityWrapper<ZhongzhijihuaEntity>().in("zhongzhijihua_uuid_number", seachFields.get("zhongzhijihuaUuidNumber")));
                        if(zhongzhijihuaEntities_zhongzhijihuaUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ZhongzhijihuaEntity s:zhongzhijihuaEntities_zhongzhijihuaUuidNumber){
                                repeatFields.add(s.getZhongzhijihuaUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [种植计划编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        zhongzhijihuaService.insertBatch(zhongzhijihuaList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = zhongzhijihuaService.queryPage(params);

        //字典表数据转换
        List<ZhongzhijihuaView> list =(List<ZhongzhijihuaView>)page.getList();
        for(ZhongzhijihuaView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ZhongzhijihuaEntity zhongzhijihua = zhongzhijihuaService.selectById(id);
            if(zhongzhijihua !=null){


                //entity转view
                ZhongzhijihuaView view = new ZhongzhijihuaView();
                BeanUtils.copyProperties( zhongzhijihua , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody ZhongzhijihuaEntity zhongzhijihua, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,zhongzhijihua:{}",this.getClass().getName(),zhongzhijihua.toString());
        Wrapper<ZhongzhijihuaEntity> queryWrapper = new EntityWrapper<ZhongzhijihuaEntity>()
            .eq("zhongzhijihua_uuid_number", zhongzhijihua.getZhongzhijihuaUuidNumber())
            .eq("zhongzhijihua_name", zhongzhijihua.getZhongzhijihuaName())
            .eq("zhongzhijihua_address", zhongzhijihua.getZhongzhijihuaAddress())
            .eq("zhongzhijihua_types", zhongzhijihua.getZhongzhijihuaTypes())
//            .notIn("zhongzhijihua_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhongzhijihuaEntity zhongzhijihuaEntity = zhongzhijihuaService.selectOne(queryWrapper);
        if(zhongzhijihuaEntity==null){
            zhongzhijihua.setInsertTime(new Date());
            zhongzhijihua.setCreateTime(new Date());
        zhongzhijihuaService.insert(zhongzhijihua);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

