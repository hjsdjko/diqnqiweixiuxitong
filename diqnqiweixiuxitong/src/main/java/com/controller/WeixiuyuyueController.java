
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
 * 物品维修预约
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/weixiuyuyue")
public class WeixiuyuyueController {
    private static final Logger logger = LoggerFactory.getLogger(WeixiuyuyueController.class);

    private static final String TABLE_NAME = "weixiuyuyue";

    @Autowired
    private WeixiuyuyueService weixiuyuyueService;


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
    private WeixiudingdanService weixiudingdanService;//物品维修订单
    @Autowired
    private WeixiuyuanService weixiuyuanService;//维修员
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
        PageUtils page = weixiuyuyueService.queryPage(params);

        //字典表数据转换
        List<WeixiuyuyueView> list =(List<WeixiuyuyueView>)page.getList();
        for(WeixiuyuyueView c:list){
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
        WeixiuyuyueEntity weixiuyuyue = weixiuyuyueService.selectById(id);
        if(weixiuyuyue !=null){
            //entity转view
            WeixiuyuyueView view = new WeixiuyuyueView();
            BeanUtils.copyProperties( weixiuyuyue , view );//把实体数据重构到view中
            //级联表 维修员
            //级联表
            WeixiuyuanEntity weixiuyuan = weixiuyuanService.selectById(weixiuyuyue.getWeixiuyuanId());
            if(weixiuyuan != null){
            BeanUtils.copyProperties( weixiuyuan , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "weixiuyuanId"
, "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setWeixiuyuanId(weixiuyuan.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(weixiuyuyue.getYonghuId());
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
    public R save(@RequestBody WeixiuyuyueEntity weixiuyuyue, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,weixiuyuyue:{}",this.getClass().getName(),weixiuyuyue.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("维修员".equals(role))
            weixiuyuyue.setWeixiuyuanId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        else if("用户".equals(role))
            weixiuyuyue.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<WeixiuyuyueEntity> queryWrapper = new EntityWrapper<WeixiuyuyueEntity>()
            .eq("yonghu_id", weixiuyuyue.getYonghuId())
            .eq("weixiuyuan_id", weixiuyuyue.getWeixiuyuanId())
            .eq("weixiuyuyue_name", weixiuyuyue.getWeixiuyuyueName())
            .eq("weixiuyuyue_types", weixiuyuyue.getWeixiuyuyueTypes())
            .in("weixiuyuyue_yesno_types", new Integer[]{1,2})
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WeixiuyuyueEntity weixiuyuyueEntity = weixiuyuyueService.selectOne(queryWrapper);
        if(weixiuyuyueEntity==null){
            weixiuyuyue.setInsertTime(new Date());
            weixiuyuyue.setWeixiuyuyueYesnoTypes(1);
            weixiuyuyue.setCreateTime(new Date());
            weixiuyuyueService.insert(weixiuyuyue);
            return R.ok();
        }else {
            if(weixiuyuyueEntity.getWeixiuyuyueYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(weixiuyuyueEntity.getWeixiuyuyueYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody WeixiuyuyueEntity weixiuyuyue, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,weixiuyuyue:{}",this.getClass().getName(),weixiuyuyue.toString());
        WeixiuyuyueEntity oldWeixiuyuyueEntity = weixiuyuyueService.selectById(weixiuyuyue.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("维修员".equals(role))
//            weixiuyuyue.setWeixiuyuanId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
//        else if("用户".equals(role))
//            weixiuyuyue.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(weixiuyuyue.getWeixiuyuyuePhoto()) || "null".equals(weixiuyuyue.getWeixiuyuyuePhoto())){
                weixiuyuyue.setWeixiuyuyuePhoto(null);
        }

            weixiuyuyueService.updateById(weixiuyuyue);//根据id更新
            return R.ok();
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody WeixiuyuyueEntity weixiuyuyueEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,weixiuyuyueEntity:{}",this.getClass().getName(),weixiuyuyueEntity.toString());

        WeixiuyuyueEntity oldWeixiuyuyue = weixiuyuyueService.selectById(weixiuyuyueEntity.getId());//查询原先数据

//        if(weixiuyuyueEntity.getWeixiuyuyueYesnoTypes() == 2){//通过
//            weixiuyuyueEntity.setWeixiuyuyueTypes();
//        }else if(weixiuyuyueEntity.getWeixiuyuyueYesnoTypes() == 3){//拒绝
//            weixiuyuyueEntity.setWeixiuyuyueTypes();
//        }
        weixiuyuyueEntity.setWeixiuyuanId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        weixiuyuyueEntity.setWeixiuyuyueShenheTime(new Date());//审核时间
        weixiuyuyueService.updateById(weixiuyuyueEntity);//审核

        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<WeixiuyuyueEntity> oldWeixiuyuyueList =weixiuyuyueService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        weixiuyuyueService.deleteBatchIds(Arrays.asList(ids));

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
            List<WeixiuyuyueEntity> weixiuyuyueList = new ArrayList<>();//上传的东西
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
                            WeixiuyuyueEntity weixiuyuyueEntity = new WeixiuyuyueEntity();
//                            weixiuyuyueEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            weixiuyuyueEntity.setWeixiuyuanId(Integer.valueOf(data.get(0)));   //维修员 要改的
//                            weixiuyuyueEntity.setWeixiuyuyueName(data.get(0));                    //物品名称 要改的
//                            weixiuyuyueEntity.setWeixiuyuyueUuidNumber(data.get(0));                    //预约编号 要改的
//                            weixiuyuyueEntity.setWeixiuyuyuePhoto("");//详情和图片
//                            weixiuyuyueEntity.setWeixiuyuyueTypes(Integer.valueOf(data.get(0)));   //物品维修类型 要改的
//                            weixiuyuyueEntity.setYuyueTime(sdf.parse(data.get(0)));          //预约维修时间 要改的
//                            weixiuyuyueEntity.setWeixiuyuyueContent("");//详情和图片
//                            weixiuyuyueEntity.setInsertTime(date);//时间
//                            weixiuyuyueEntity.setWeixiuyuyueYesnoTypes(Integer.valueOf(data.get(0)));   //预约状态 要改的
//                            weixiuyuyueEntity.setWeixiuyuyueYesnoText(data.get(0));                    //审核意见 要改的
//                            weixiuyuyueEntity.setWeixiuyuyueShenheTime(sdf.parse(data.get(0)));          //审核时间 要改的
//                            weixiuyuyueEntity.setCreateTime(date);//时间
                            weixiuyuyueList.add(weixiuyuyueEntity);


                            //把要查询是否重复的字段放入map中
                                //预约编号
                                if(seachFields.containsKey("weixiuyuyueUuidNumber")){
                                    List<String> weixiuyuyueUuidNumber = seachFields.get("weixiuyuyueUuidNumber");
                                    weixiuyuyueUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> weixiuyuyueUuidNumber = new ArrayList<>();
                                    weixiuyuyueUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("weixiuyuyueUuidNumber",weixiuyuyueUuidNumber);
                                }
                        }

                        //查询是否重复
                         //预约编号
                        List<WeixiuyuyueEntity> weixiuyuyueEntities_weixiuyuyueUuidNumber = weixiuyuyueService.selectList(new EntityWrapper<WeixiuyuyueEntity>().in("weixiuyuyue_uuid_number", seachFields.get("weixiuyuyueUuidNumber")));
                        if(weixiuyuyueEntities_weixiuyuyueUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(WeixiuyuyueEntity s:weixiuyuyueEntities_weixiuyuyueUuidNumber){
                                repeatFields.add(s.getWeixiuyuyueUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [预约编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        weixiuyuyueService.insertBatch(weixiuyuyueList);
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
        PageUtils page = weixiuyuyueService.queryPage(params);

        //字典表数据转换
        List<WeixiuyuyueView> list =(List<WeixiuyuyueView>)page.getList();
        for(WeixiuyuyueView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        WeixiuyuyueEntity weixiuyuyue = weixiuyuyueService.selectById(id);
            if(weixiuyuyue !=null){


                //entity转view
                WeixiuyuyueView view = new WeixiuyuyueView();
                BeanUtils.copyProperties( weixiuyuyue , view );//把实体数据重构到view中

                //级联表
                    WeixiuyuanEntity weixiuyuan = weixiuyuanService.selectById(weixiuyuyue.getWeixiuyuanId());
                if(weixiuyuan != null){
                    BeanUtils.copyProperties( weixiuyuan , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setWeixiuyuanId(weixiuyuan.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(weixiuyuyue.getYonghuId());
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
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody WeixiuyuyueEntity weixiuyuyue, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,weixiuyuyue:{}",this.getClass().getName(),weixiuyuyue.toString());
        Wrapper<WeixiuyuyueEntity> queryWrapper = new EntityWrapper<WeixiuyuyueEntity>()
            .eq("yonghu_id", weixiuyuyue.getYonghuId())
            .eq("weixiuyuan_id", weixiuyuyue.getWeixiuyuanId())
            .eq("weixiuyuyue_name", weixiuyuyue.getWeixiuyuyueName())
            .eq("weixiuyuyue_uuid_number", weixiuyuyue.getWeixiuyuyueUuidNumber())
            .eq("weixiuyuyue_types", weixiuyuyue.getWeixiuyuyueTypes())
            .in("weixiuyuyue_yesno_types", new Integer[]{1,2})
            .eq("weixiuyuyue_yesno_text", weixiuyuyue.getWeixiuyuyueYesnoText())
//            .notIn("weixiuyuyue_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WeixiuyuyueEntity weixiuyuyueEntity = weixiuyuyueService.selectOne(queryWrapper);
        if(weixiuyuyueEntity==null){
            weixiuyuyue.setInsertTime(new Date());
            weixiuyuyue.setWeixiuyuyueYesnoTypes(1);
            weixiuyuyue.setCreateTime(new Date());
        weixiuyuyueService.insert(weixiuyuyue);

            return R.ok();
        }else {
            if(weixiuyuyueEntity.getWeixiuyuyueYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(weixiuyuyueEntity.getWeixiuyuyueYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

}

