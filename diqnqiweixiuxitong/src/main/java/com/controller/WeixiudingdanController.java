
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
 * 物品维修订单
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/weixiudingdan")
public class WeixiudingdanController {
    private static final Logger logger = LoggerFactory.getLogger(WeixiudingdanController.class);

    private static final String TABLE_NAME = "weixiudingdan";

    @Autowired
    private WeixiudingdanService weixiudingdanService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private ChatService chatService;//客服聊天
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private GonggaoService gonggaoService;//公告
    @Autowired
    private NewsService newsService;//新闻信息
    @Autowired
    private WeixiuyuanService weixiuyuanService;//维修员
    @Autowired
    private WeixiuyuyueService weixiuyuyueService;//物品维修预约
    @Autowired
    private YonghuService yonghuService;//用户
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
        else if("维修员".equals(role))
            params.put("weixiuyuanId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = weixiudingdanService.queryPage(params);

        //字典表数据转换
        List<WeixiudingdanView> list =(List<WeixiudingdanView>)page.getList();
        for(WeixiudingdanView c:list){
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
        WeixiudingdanEntity weixiudingdan = weixiudingdanService.selectById(id);
        if(weixiudingdan !=null){
            //entity转view
            WeixiudingdanView view = new WeixiudingdanView();
            BeanUtils.copyProperties( weixiudingdan , view );//把实体数据重构到view中
            //级联表 维修员
            //级联表
            WeixiuyuanEntity weixiuyuan = weixiuyuanService.selectById(weixiudingdan.getWeixiuyuanId());
            if(weixiuyuan != null){
            BeanUtils.copyProperties( weixiuyuan , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "weixiuyuanId"
, "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setWeixiuyuanId(weixiuyuan.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(weixiudingdan.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "weixiuyuanId"
, "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
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
    public R save(@RequestBody WeixiudingdanEntity weixiudingdan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,weixiudingdan:{}",this.getClass().getName(),weixiudingdan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("维修员".equals(role)){
            weixiudingdan.setWeixiudingdanTypes(1);
            weixiudingdan.setWeixiuyuanId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        }
        else if("用户".equals(role))
            weixiudingdan.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            weixiudingdan.setInsertTime(new Date());
            weixiudingdan.setCreateTime(new Date());
            weixiudingdanService.insert(weixiudingdan);
            return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody WeixiudingdanEntity weixiudingdan, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,weixiudingdan:{}",this.getClass().getName(),weixiudingdan.toString());
        WeixiudingdanEntity oldWeixiudingdanEntity = weixiudingdanService.selectById(weixiudingdan.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("维修员".equals(role))
//            weixiudingdan.setWeixiuyuanId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
//        else if("用户".equals(role))
//            weixiudingdan.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(weixiudingdan.getWeixiudingdanPhoto()) || "null".equals(weixiudingdan.getWeixiudingdanPhoto())){
                weixiudingdan.setWeixiudingdanPhoto(null);
        }

            weixiudingdanService.updateById(weixiudingdan);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<WeixiudingdanEntity> oldWeixiudingdanList =weixiudingdanService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        weixiudingdanService.deleteBatchIds(Arrays.asList(ids));

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
        try {
            List<WeixiudingdanEntity> weixiudingdanList = new ArrayList<>();//上传的东西
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
                            WeixiudingdanEntity weixiudingdanEntity = new WeixiudingdanEntity();
//                            weixiudingdanEntity.setWeixiuyuanId(Integer.valueOf(data.get(0)));   //维修员 要改的
//                            weixiudingdanEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            weixiudingdanEntity.setWeixiudingdanUuidNumber(data.get(0));                    //维修编号 要改的
//                            weixiudingdanEntity.setWeixiudingdanName(data.get(0));                    //物品名称 要改的
//                            weixiudingdanEntity.setWeixiudingdanPhoto("");//详情和图片
//                            weixiudingdanEntity.setWeixiuyuyueTypes(Integer.valueOf(data.get(0)));   //维修类型 要改的
//                            weixiudingdanEntity.setWeixiudingdanBaojia(data.get(0));                    //维修价格 要改的
//                            weixiudingdanEntity.setYuyueTime(sdf.parse(data.get(0)));          //维修时间 要改的
//                            weixiudingdanEntity.setWeixiudingdanContent("");//详情和图片
//                            weixiudingdanEntity.setWeixiudingdanTypes(Integer.valueOf(data.get(0)));   //维修状态 要改的
//                            weixiudingdanEntity.setInsertTime(date);//时间
//                            weixiudingdanEntity.setCreateTime(date);//时间
                            weixiudingdanList.add(weixiudingdanEntity);


                            //把要查询是否重复的字段放入map中
                                //维修编号
                                if(seachFields.containsKey("weixiudingdanUuidNumber")){
                                    List<String> weixiudingdanUuidNumber = seachFields.get("weixiudingdanUuidNumber");
                                    weixiudingdanUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> weixiudingdanUuidNumber = new ArrayList<>();
                                    weixiudingdanUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("weixiudingdanUuidNumber",weixiudingdanUuidNumber);
                                }
                        }

                        //查询是否重复
                         //维修编号
                        List<WeixiudingdanEntity> weixiudingdanEntities_weixiudingdanUuidNumber = weixiudingdanService.selectList(new EntityWrapper<WeixiudingdanEntity>().in("weixiudingdan_uuid_number", seachFields.get("weixiudingdanUuidNumber")));
                        if(weixiudingdanEntities_weixiudingdanUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(WeixiudingdanEntity s:weixiudingdanEntities_weixiudingdanUuidNumber){
                                repeatFields.add(s.getWeixiudingdanUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [维修编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        weixiudingdanService.insertBatch(weixiudingdanList);
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
        PageUtils page = weixiudingdanService.queryPage(params);

        //字典表数据转换
        List<WeixiudingdanView> list =(List<WeixiudingdanView>)page.getList();
        for(WeixiudingdanView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        WeixiudingdanEntity weixiudingdan = weixiudingdanService.selectById(id);
            if(weixiudingdan !=null){


                //entity转view
                WeixiudingdanView view = new WeixiudingdanView();
                BeanUtils.copyProperties( weixiudingdan , view );//把实体数据重构到view中

                //级联表
                    WeixiuyuanEntity weixiuyuan = weixiuyuanService.selectById(weixiudingdan.getWeixiuyuanId());
                if(weixiuyuan != null){
                    BeanUtils.copyProperties( weixiuyuan , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setWeixiuyuanId(weixiuyuan.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(weixiudingdan.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }



    /**
     * 支付
     */
    @RequestMapping("/zhifu")
    public R zhifu(Integer id, HttpServletRequest request){
        WeixiudingdanEntity weixiudingdan = weixiudingdanService.selectById(id);
        if(weixiudingdan == null)
            return R.error("查不到维修订单");
        if(weixiudingdan.getWeixiudingdanTypes() !=2)
            return R.error("只有已维修的可以支付");

        YonghuEntity yonghuEntity = yonghuService.selectById(weixiudingdan.getYonghuId());
        if(yonghuEntity == null)
            return R.error("查不到用户");
        double balance = yonghuEntity.getNewMoney() - weixiudingdan.getWeixiudingdanBaojia();
        if(balance<0)
            return R.error("余额不够支付,请充值后再支付");
        yonghuEntity.setNewMoney(balance);
        yonghuService.updateById(yonghuEntity);
        weixiudingdan.setWeixiudingdanTypes(3);
        weixiudingdanService.updateById(weixiudingdan);
        return R.ok();
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody WeixiudingdanEntity weixiudingdan, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,weixiudingdan:{}",this.getClass().getName(),weixiudingdan.toString());
        Wrapper<WeixiudingdanEntity> queryWrapper = new EntityWrapper<WeixiudingdanEntity>()
            .eq("weixiuyuan_id", weixiudingdan.getWeixiuyuanId())
            .eq("yonghu_id", weixiudingdan.getYonghuId())
            .eq("weixiudingdan_uuid_number", weixiudingdan.getWeixiudingdanUuidNumber())
            .eq("weixiudingdan_name", weixiudingdan.getWeixiudingdanName())
            .eq("weixiuyuyue_types", weixiudingdan.getWeixiuyuyueTypes())
            .eq("weixiudingdan_types", weixiudingdan.getWeixiudingdanTypes())
//            .notIn("weixiudingdan_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WeixiudingdanEntity weixiudingdanEntity = weixiudingdanService.selectOne(queryWrapper);
        if(weixiudingdanEntity==null){
            weixiudingdan.setInsertTime(new Date());
            weixiudingdan.setCreateTime(new Date());
        weixiudingdanService.insert(weixiudingdan);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}
