
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
 * 湿度监控
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/shidujiankong")
public class ShidujiankongController {
    private static final Logger logger = LoggerFactory.getLogger(ShidujiankongController.class);

    private static final String TABLE_NAME = "shidujiankong";

    @Autowired
    private ShidujiankongService shidujiankongService;


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
    private WendujiankongService wendujiankongService;//温度监控
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
        PageUtils page = shidujiankongService.queryPage(params);

        //字典表数据转换
        List<ShidujiankongView> list =(List<ShidujiankongView>)page.getList();
        for(ShidujiankongView c:list){
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
        ShidujiankongEntity shidujiankong = shidujiankongService.selectById(id);
        if(shidujiankong !=null){
            //entity转view
            ShidujiankongView view = new ShidujiankongView();
            BeanUtils.copyProperties( shidujiankong , view );//把实体数据重构到view中
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
    public R save(@RequestBody ShidujiankongEntity shidujiankong, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,shidujiankong:{}",this.getClass().getName(),shidujiankong.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ShidujiankongEntity> queryWrapper = new EntityWrapper<ShidujiankongEntity>()
            .eq("shidujiankong_address", shidujiankong.getShidujiankongAddress())
            .eq("shidujiankong_types", shidujiankong.getShidujiankongTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShidujiankongEntity shidujiankongEntity = shidujiankongService.selectOne(queryWrapper);
        if(shidujiankongEntity==null){
            shidujiankong.setInsertTime(new Date());
            shidujiankong.setCreateTime(new Date());
            shidujiankongService.insert(shidujiankong);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShidujiankongEntity shidujiankong, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,shidujiankong:{}",this.getClass().getName(),shidujiankong.toString());
        ShidujiankongEntity oldShidujiankongEntity = shidujiankongService.selectById(shidujiankong.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(shidujiankong.getShidujiankongFile()) || "null".equals(shidujiankong.getShidujiankongFile())){
                shidujiankong.setShidujiankongFile(null);
        }
        if("".equals(shidujiankong.getShidujiankongContent()) || "null".equals(shidujiankong.getShidujiankongContent())){
                shidujiankong.setShidujiankongContent(null);
        }

            shidujiankongService.updateById(shidujiankong);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ShidujiankongEntity> oldShidujiankongList =shidujiankongService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        shidujiankongService.deleteBatchIds(Arrays.asList(ids));

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
            List<ShidujiankongEntity> shidujiankongList = new ArrayList<>();//上传的东西
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
                            ShidujiankongEntity shidujiankongEntity = new ShidujiankongEntity();
//                            shidujiankongEntity.setShidujiankongUuidNumber(data.get(0));                    //湿度监控编号 要改的
//                            shidujiankongEntity.setShidujiankongAddress(data.get(0));                    //湿度监控地点 要改的
//                            shidujiankongEntity.setShidujiankongTypes(Integer.valueOf(data.get(0)));   //湿度监控类型 要改的
//                            shidujiankongEntity.setShidujiankongFile(data.get(0));                    //附件 要改的
//                            shidujiankongEntity.setShidujiankongShuzi(data.get(0));                    //湿度 要改的
//                            shidujiankongEntity.setShidujiankongTime(sdf.parse(data.get(0)));          //监控时间 要改的
//                            shidujiankongEntity.setShidujiankongContent("");//详情和图片
//                            shidujiankongEntity.setInsertTime(date);//时间
//                            shidujiankongEntity.setCreateTime(date);//时间
                            shidujiankongList.add(shidujiankongEntity);


                            //把要查询是否重复的字段放入map中
                                //湿度监控编号
                                if(seachFields.containsKey("shidujiankongUuidNumber")){
                                    List<String> shidujiankongUuidNumber = seachFields.get("shidujiankongUuidNumber");
                                    shidujiankongUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> shidujiankongUuidNumber = new ArrayList<>();
                                    shidujiankongUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("shidujiankongUuidNumber",shidujiankongUuidNumber);
                                }
                        }

                        //查询是否重复
                         //湿度监控编号
                        List<ShidujiankongEntity> shidujiankongEntities_shidujiankongUuidNumber = shidujiankongService.selectList(new EntityWrapper<ShidujiankongEntity>().in("shidujiankong_uuid_number", seachFields.get("shidujiankongUuidNumber")));
                        if(shidujiankongEntities_shidujiankongUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ShidujiankongEntity s:shidujiankongEntities_shidujiankongUuidNumber){
                                repeatFields.add(s.getShidujiankongUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [湿度监控编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        shidujiankongService.insertBatch(shidujiankongList);
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
        PageUtils page = shidujiankongService.queryPage(params);

        //字典表数据转换
        List<ShidujiankongView> list =(List<ShidujiankongView>)page.getList();
        for(ShidujiankongView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ShidujiankongEntity shidujiankong = shidujiankongService.selectById(id);
            if(shidujiankong !=null){


                //entity转view
                ShidujiankongView view = new ShidujiankongView();
                BeanUtils.copyProperties( shidujiankong , view );//把实体数据重构到view中

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
    public R add(@RequestBody ShidujiankongEntity shidujiankong, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,shidujiankong:{}",this.getClass().getName(),shidujiankong.toString());
        Wrapper<ShidujiankongEntity> queryWrapper = new EntityWrapper<ShidujiankongEntity>()
            .eq("shidujiankong_uuid_number", shidujiankong.getShidujiankongUuidNumber())
            .eq("shidujiankong_address", shidujiankong.getShidujiankongAddress())
            .eq("shidujiankong_types", shidujiankong.getShidujiankongTypes())
//            .notIn("shidujiankong_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShidujiankongEntity shidujiankongEntity = shidujiankongService.selectOne(queryWrapper);
        if(shidujiankongEntity==null){
            shidujiankong.setInsertTime(new Date());
            shidujiankong.setCreateTime(new Date());
        shidujiankongService.insert(shidujiankong);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

