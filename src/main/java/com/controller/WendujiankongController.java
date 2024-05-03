
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
 * 温度监控
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/wendujiankong")
public class WendujiankongController {
    private static final Logger logger = LoggerFactory.getLogger(WendujiankongController.class);

    private static final String TABLE_NAME = "wendujiankong";

    @Autowired
    private WendujiankongService wendujiankongService;


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
    private YonghuService yonghuService;//用户
    @Autowired
    private YujingService yujingService;//病虫害预警
    @Autowired
    private ZhongzhijihuaService zhongzhijihuaService;//种植计划
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
        PageUtils page = wendujiankongService.queryPage(params);

        //字典表数据转换
        List<WendujiankongView> list =(List<WendujiankongView>)page.getList();
        for(WendujiankongView c:list){
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
        WendujiankongEntity wendujiankong = wendujiankongService.selectById(id);
        if(wendujiankong !=null){
            //entity转view
            WendujiankongView view = new WendujiankongView();
            BeanUtils.copyProperties( wendujiankong , view );//把实体数据重构到view中
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
    public R save(@RequestBody WendujiankongEntity wendujiankong, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,wendujiankong:{}",this.getClass().getName(),wendujiankong.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<WendujiankongEntity> queryWrapper = new EntityWrapper<WendujiankongEntity>()
            .eq("wendujiankong_address", wendujiankong.getWendujiankongAddress())
            .eq("wendujiankong_types", wendujiankong.getWendujiankongTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WendujiankongEntity wendujiankongEntity = wendujiankongService.selectOne(queryWrapper);
        if(wendujiankongEntity==null){
            wendujiankong.setInsertTime(new Date());
            wendujiankong.setCreateTime(new Date());
            wendujiankongService.insert(wendujiankong);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody WendujiankongEntity wendujiankong, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,wendujiankong:{}",this.getClass().getName(),wendujiankong.toString());
        WendujiankongEntity oldWendujiankongEntity = wendujiankongService.selectById(wendujiankong.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(wendujiankong.getWendujiankongFile()) || "null".equals(wendujiankong.getWendujiankongFile())){
                wendujiankong.setWendujiankongFile(null);
        }
        if("".equals(wendujiankong.getWendujiankongContent()) || "null".equals(wendujiankong.getWendujiankongContent())){
                wendujiankong.setWendujiankongContent(null);
        }

            wendujiankongService.updateById(wendujiankong);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<WendujiankongEntity> oldWendujiankongList =wendujiankongService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        wendujiankongService.deleteBatchIds(Arrays.asList(ids));

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
            List<WendujiankongEntity> wendujiankongList = new ArrayList<>();//上传的东西
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
                            WendujiankongEntity wendujiankongEntity = new WendujiankongEntity();
//                            wendujiankongEntity.setWendujiankongUuidNumber(data.get(0));                    //温度监控编号 要改的
//                            wendujiankongEntity.setWendujiankongAddress(data.get(0));                    //温度监控地点 要改的
//                            wendujiankongEntity.setWendujiankongTypes(Integer.valueOf(data.get(0)));   //温度监控类型 要改的
//                            wendujiankongEntity.setWendujiankongFile(data.get(0));                    //附件 要改的
//                            wendujiankongEntity.setWendujiankongShuzi(data.get(0));                    //温度 要改的
//                            wendujiankongEntity.setWendujiankongTime(sdf.parse(data.get(0)));          //监控时间 要改的
//                            wendujiankongEntity.setWendujiankongContent("");//详情和图片
//                            wendujiankongEntity.setInsertTime(date);//时间
//                            wendujiankongEntity.setCreateTime(date);//时间
                            wendujiankongList.add(wendujiankongEntity);


                            //把要查询是否重复的字段放入map中
                                //温度监控编号
                                if(seachFields.containsKey("wendujiankongUuidNumber")){
                                    List<String> wendujiankongUuidNumber = seachFields.get("wendujiankongUuidNumber");
                                    wendujiankongUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> wendujiankongUuidNumber = new ArrayList<>();
                                    wendujiankongUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("wendujiankongUuidNumber",wendujiankongUuidNumber);
                                }
                        }

                        //查询是否重复
                         //温度监控编号
                        List<WendujiankongEntity> wendujiankongEntities_wendujiankongUuidNumber = wendujiankongService.selectList(new EntityWrapper<WendujiankongEntity>().in("wendujiankong_uuid_number", seachFields.get("wendujiankongUuidNumber")));
                        if(wendujiankongEntities_wendujiankongUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(WendujiankongEntity s:wendujiankongEntities_wendujiankongUuidNumber){
                                repeatFields.add(s.getWendujiankongUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [温度监控编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        wendujiankongService.insertBatch(wendujiankongList);
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
        PageUtils page = wendujiankongService.queryPage(params);

        //字典表数据转换
        List<WendujiankongView> list =(List<WendujiankongView>)page.getList();
        for(WendujiankongView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        WendujiankongEntity wendujiankong = wendujiankongService.selectById(id);
            if(wendujiankong !=null){


                //entity转view
                WendujiankongView view = new WendujiankongView();
                BeanUtils.copyProperties( wendujiankong , view );//把实体数据重构到view中

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
    public R add(@RequestBody WendujiankongEntity wendujiankong, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,wendujiankong:{}",this.getClass().getName(),wendujiankong.toString());
        Wrapper<WendujiankongEntity> queryWrapper = new EntityWrapper<WendujiankongEntity>()
            .eq("wendujiankong_uuid_number", wendujiankong.getWendujiankongUuidNumber())
            .eq("wendujiankong_address", wendujiankong.getWendujiankongAddress())
            .eq("wendujiankong_types", wendujiankong.getWendujiankongTypes())
//            .notIn("wendujiankong_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WendujiankongEntity wendujiankongEntity = wendujiankongService.selectOne(queryWrapper);
        if(wendujiankongEntity==null){
            wendujiankong.setInsertTime(new Date());
            wendujiankong.setCreateTime(new Date());
        wendujiankongService.insert(wendujiankong);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

