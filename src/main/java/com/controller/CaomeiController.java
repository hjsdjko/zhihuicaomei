
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
 * 草莓
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/caomei")
public class CaomeiController {
    private static final Logger logger = LoggerFactory.getLogger(CaomeiController.class);

    private static final String TABLE_NAME = "caomei";

    @Autowired
    private CaomeiService caomeiService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private AddressService addressService;//收货地址
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
        params.put("caomeiDeleteStart",1);params.put("caomeiDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = caomeiService.queryPage(params);

        //字典表数据转换
        List<CaomeiView> list =(List<CaomeiView>)page.getList();
        for(CaomeiView c:list){
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
        CaomeiEntity caomei = caomeiService.selectById(id);
        if(caomei !=null){
            //entity转view
            CaomeiView view = new CaomeiView();
            BeanUtils.copyProperties( caomei , view );//把实体数据重构到view中
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
    public R save(@RequestBody CaomeiEntity caomei, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,caomei:{}",this.getClass().getName(),caomei.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<CaomeiEntity> queryWrapper = new EntityWrapper<CaomeiEntity>()
            .eq("caomei_name", caomei.getCaomeiName())
            .eq("caomei_types", caomei.getCaomeiTypes())
            .eq("caomei_kucun_number", caomei.getCaomeiKucunNumber())
            .eq("caomei_cangku", caomei.getCaomeiCangku())
            .eq("shangxia_types", caomei.getShangxiaTypes())
            .eq("caomei_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        CaomeiEntity caomeiEntity = caomeiService.selectOne(queryWrapper);
        if(caomeiEntity==null){
            caomei.setCaomeiClicknum(1);
            caomei.setShangxiaTypes(1);
            caomei.setCaomeiDelete(1);
            caomei.setInsertTime(new Date());
            caomei.setCreateTime(new Date());
            caomeiService.insert(caomei);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody CaomeiEntity caomei, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,caomei:{}",this.getClass().getName(),caomei.toString());
        CaomeiEntity oldCaomeiEntity = caomeiService.selectById(caomei.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(caomei.getCaomeiPhoto()) || "null".equals(caomei.getCaomeiPhoto())){
                caomei.setCaomeiPhoto(null);
        }
        if("".equals(caomei.getCaomeiContent()) || "null".equals(caomei.getCaomeiContent())){
                caomei.setCaomeiContent(null);
        }

            caomeiService.updateById(caomei);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<CaomeiEntity> oldCaomeiList =caomeiService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<CaomeiEntity> list = new ArrayList<>();
        for(Integer id:ids){
            CaomeiEntity caomeiEntity = new CaomeiEntity();
            caomeiEntity.setId(id);
            caomeiEntity.setCaomeiDelete(2);
            list.add(caomeiEntity);
        }
        if(list != null && list.size() >0){
            caomeiService.updateBatchById(list);
        }

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
            List<CaomeiEntity> caomeiList = new ArrayList<>();//上传的东西
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
                            CaomeiEntity caomeiEntity = new CaomeiEntity();
//                            caomeiEntity.setCaomeiName(data.get(0));                    //草莓名称 要改的
//                            caomeiEntity.setCaomeiUuidNumber(data.get(0));                    //草莓编号 要改的
//                            caomeiEntity.setCaomeiPhoto("");//详情和图片
//                            caomeiEntity.setCaomeiTypes(Integer.valueOf(data.get(0)));   //草莓类型 要改的
//                            caomeiEntity.setCaomeiKucunNumber(Integer.valueOf(data.get(0)));   //草莓库存 要改的
//                            caomeiEntity.setCaomeiOldMoney(data.get(0));                    //草莓原价 要改的
//                            caomeiEntity.setCaomeiNewMoney(data.get(0));                    //现价/斤 要改的
//                            caomeiEntity.setCaomeiCangku(data.get(0));                    //所属仓库 要改的
//                            caomeiEntity.setCaomeiClicknum(Integer.valueOf(data.get(0)));   //草莓热度 要改的
//                            caomeiEntity.setCaomeiContent("");//详情和图片
//                            caomeiEntity.setShangxiaTypes(Integer.valueOf(data.get(0)));   //是否上架 要改的
//                            caomeiEntity.setCaomeiDelete(1);//逻辑删除字段
//                            caomeiEntity.setInsertTime(date);//时间
//                            caomeiEntity.setCreateTime(date);//时间
                            caomeiList.add(caomeiEntity);


                            //把要查询是否重复的字段放入map中
                                //草莓编号
                                if(seachFields.containsKey("caomeiUuidNumber")){
                                    List<String> caomeiUuidNumber = seachFields.get("caomeiUuidNumber");
                                    caomeiUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> caomeiUuidNumber = new ArrayList<>();
                                    caomeiUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("caomeiUuidNumber",caomeiUuidNumber);
                                }
                        }

                        //查询是否重复
                         //草莓编号
                        List<CaomeiEntity> caomeiEntities_caomeiUuidNumber = caomeiService.selectList(new EntityWrapper<CaomeiEntity>().in("caomei_uuid_number", seachFields.get("caomeiUuidNumber")).eq("caomei_delete", 1));
                        if(caomeiEntities_caomeiUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(CaomeiEntity s:caomeiEntities_caomeiUuidNumber){
                                repeatFields.add(s.getCaomeiUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [草莓编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        caomeiService.insertBatch(caomeiList);
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
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<CaomeiView> returnCaomeiViewList = new ArrayList<>();

        //查询订单
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        params1.put("shangxiaTypes",1);
        params1.put("caomeiYesnoTypes",2);
        PageUtils pageUtils = caomeiOrderService.queryPage(params1);
        List<CaomeiOrderView> orderViewsList =(List<CaomeiOrderView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(CaomeiOrderView orderView:orderViewsList){
            Integer caomeiTypes = orderView.getCaomeiTypes();
            if(typeMap.containsKey(caomeiTypes)){
                typeMap.put(caomeiTypes,typeMap.get(caomeiTypes)+1);
            }else{
                typeMap.put(caomeiTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("caomeiTypes",type);
            params2.put("shangxiaTypes",1);
            params2.put("caomeiYesnoTypes",2);
            PageUtils pageUtils1 = caomeiService.queryPage(params2);
            List<CaomeiView> caomeiViewList =(List<CaomeiView>)pageUtils1.getList();
            returnCaomeiViewList.addAll(caomeiViewList);
            if(returnCaomeiViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        params.put("shangxiaTypes",1);
        params.put("caomeiYesnoTypes",2);
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = caomeiService.queryPage(params);
        if(returnCaomeiViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnCaomeiViewList.size();//要添加的数量
            List<CaomeiView> caomeiViewList =(List<CaomeiView>)page.getList();
            for(CaomeiView caomeiView:caomeiViewList){
                Boolean addFlag = true;
                for(CaomeiView returnCaomeiView:returnCaomeiViewList){
                    if(returnCaomeiView.getId().intValue() ==caomeiView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnCaomeiViewList.add(caomeiView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnCaomeiViewList = returnCaomeiViewList.subList(0, limit);
        }

        for(CaomeiView c:returnCaomeiViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnCaomeiViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = caomeiService.queryPage(params);

        //字典表数据转换
        List<CaomeiView> list =(List<CaomeiView>)page.getList();
        for(CaomeiView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        CaomeiEntity caomei = caomeiService.selectById(id);
            if(caomei !=null){

                //点击数量加1
                caomei.setCaomeiClicknum(caomei.getCaomeiClicknum()+1);
                caomeiService.updateById(caomei);

                //entity转view
                CaomeiView view = new CaomeiView();
                BeanUtils.copyProperties( caomei , view );//把实体数据重构到view中

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
    public R add(@RequestBody CaomeiEntity caomei, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,caomei:{}",this.getClass().getName(),caomei.toString());
        Wrapper<CaomeiEntity> queryWrapper = new EntityWrapper<CaomeiEntity>()
            .eq("caomei_name", caomei.getCaomeiName())
            .eq("caomei_uuid_number", caomei.getCaomeiUuidNumber())
            .eq("caomei_types", caomei.getCaomeiTypes())
            .eq("caomei_kucun_number", caomei.getCaomeiKucunNumber())
            .eq("caomei_cangku", caomei.getCaomeiCangku())
            .eq("caomei_clicknum", caomei.getCaomeiClicknum())
            .eq("shangxia_types", caomei.getShangxiaTypes())
            .eq("caomei_delete", caomei.getCaomeiDelete())
//            .notIn("caomei_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        CaomeiEntity caomeiEntity = caomeiService.selectOne(queryWrapper);
        if(caomeiEntity==null){
            caomei.setCaomeiClicknum(1);
            caomei.setCaomeiDelete(1);
            caomei.setInsertTime(new Date());
            caomei.setCreateTime(new Date());
        caomeiService.insert(caomei);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

