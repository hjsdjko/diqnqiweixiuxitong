
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
 * 维修员
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/weixiuyuan")
public class WeixiuyuanController {
    private static final Logger logger = LoggerFactory.getLogger(WeixiuyuanController.class);

    private static final String TABLE_NAME = "weixiuyuan";

    @Autowired
    private WeixiuyuanService weixiuyuanService;


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
        PageUtils page = weixiuyuanService.queryPage(params);

        //字典表数据转换
        List<WeixiuyuanView> list =(List<WeixiuyuanView>)page.getList();
        for(WeixiuyuanView c:list){
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
        WeixiuyuanEntity weixiuyuan = weixiuyuanService.selectById(id);
        if(weixiuyuan !=null){
            //entity转view
            WeixiuyuanView view = new WeixiuyuanView();
            BeanUtils.copyProperties( weixiuyuan , view );//把实体数据重构到view中
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
    public R save(@RequestBody WeixiuyuanEntity weixiuyuan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,weixiuyuan:{}",this.getClass().getName(),weixiuyuan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<WeixiuyuanEntity> queryWrapper = new EntityWrapper<WeixiuyuanEntity>()
            .eq("username", weixiuyuan.getUsername())
            .or()
            .eq("weixiuyuan_phone", weixiuyuan.getWeixiuyuanPhone())
            .or()
            .eq("weixiuyuan_id_number", weixiuyuan.getWeixiuyuanIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WeixiuyuanEntity weixiuyuanEntity = weixiuyuanService.selectOne(queryWrapper);
        if(weixiuyuanEntity==null){
            weixiuyuan.setCreateTime(new Date());
            weixiuyuan.setPassword("123456");
            weixiuyuanService.insert(weixiuyuan);
            return R.ok();
        }else {
            return R.error(511,"账户或者维修员手机号或者维修员身份证号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody WeixiuyuanEntity weixiuyuan, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,weixiuyuan:{}",this.getClass().getName(),weixiuyuan.toString());
        WeixiuyuanEntity oldWeixiuyuanEntity = weixiuyuanService.selectById(weixiuyuan.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(weixiuyuan.getWeixiuyuanPhoto()) || "null".equals(weixiuyuan.getWeixiuyuanPhoto())){
                weixiuyuan.setWeixiuyuanPhoto(null);
        }

            weixiuyuanService.updateById(weixiuyuan);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<WeixiuyuanEntity> oldWeixiuyuanList =weixiuyuanService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        weixiuyuanService.deleteBatchIds(Arrays.asList(ids));

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
            List<WeixiuyuanEntity> weixiuyuanList = new ArrayList<>();//上传的东西
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
                            WeixiuyuanEntity weixiuyuanEntity = new WeixiuyuanEntity();
//                            weixiuyuanEntity.setUsername(data.get(0));                    //账户 要改的
//                            //weixiuyuanEntity.setPassword("123456");//密码
//                            weixiuyuanEntity.setWeixiuyuanName(data.get(0));                    //维修员姓名 要改的
//                            weixiuyuanEntity.setWeixiuyuanPhone(data.get(0));                    //维修员手机号 要改的
//                            weixiuyuanEntity.setWeixiuyuanIdNumber(data.get(0));                    //维修员身份证号 要改的
//                            weixiuyuanEntity.setWeixiuyuanPhoto("");//详情和图片
//                            weixiuyuanEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            weixiuyuanEntity.setWeixiuyuanEmail(data.get(0));                    //维修员邮箱 要改的
//                            weixiuyuanEntity.setCreateTime(date);//时间
                            weixiuyuanList.add(weixiuyuanEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //维修员手机号
                                if(seachFields.containsKey("weixiuyuanPhone")){
                                    List<String> weixiuyuanPhone = seachFields.get("weixiuyuanPhone");
                                    weixiuyuanPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> weixiuyuanPhone = new ArrayList<>();
                                    weixiuyuanPhone.add(data.get(0));//要改的
                                    seachFields.put("weixiuyuanPhone",weixiuyuanPhone);
                                }
                                //维修员身份证号
                                if(seachFields.containsKey("weixiuyuanIdNumber")){
                                    List<String> weixiuyuanIdNumber = seachFields.get("weixiuyuanIdNumber");
                                    weixiuyuanIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> weixiuyuanIdNumber = new ArrayList<>();
                                    weixiuyuanIdNumber.add(data.get(0));//要改的
                                    seachFields.put("weixiuyuanIdNumber",weixiuyuanIdNumber);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<WeixiuyuanEntity> weixiuyuanEntities_username = weixiuyuanService.selectList(new EntityWrapper<WeixiuyuanEntity>().in("username", seachFields.get("username")));
                        if(weixiuyuanEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(WeixiuyuanEntity s:weixiuyuanEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //维修员手机号
                        List<WeixiuyuanEntity> weixiuyuanEntities_weixiuyuanPhone = weixiuyuanService.selectList(new EntityWrapper<WeixiuyuanEntity>().in("weixiuyuan_phone", seachFields.get("weixiuyuanPhone")));
                        if(weixiuyuanEntities_weixiuyuanPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(WeixiuyuanEntity s:weixiuyuanEntities_weixiuyuanPhone){
                                repeatFields.add(s.getWeixiuyuanPhone());
                            }
                            return R.error(511,"数据库的该表中的 [维修员手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //维修员身份证号
                        List<WeixiuyuanEntity> weixiuyuanEntities_weixiuyuanIdNumber = weixiuyuanService.selectList(new EntityWrapper<WeixiuyuanEntity>().in("weixiuyuan_id_number", seachFields.get("weixiuyuanIdNumber")));
                        if(weixiuyuanEntities_weixiuyuanIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(WeixiuyuanEntity s:weixiuyuanEntities_weixiuyuanIdNumber){
                                repeatFields.add(s.getWeixiuyuanIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [维修员身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        weixiuyuanService.insertBatch(weixiuyuanList);
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
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        WeixiuyuanEntity weixiuyuan = weixiuyuanService.selectOne(new EntityWrapper<WeixiuyuanEntity>().eq("username", username));
        if(weixiuyuan==null || !weixiuyuan.getPassword().equals(password))
            return R.error("账号或密码不正确");
        String token = tokenService.generateToken(weixiuyuan.getId(),username, "weixiuyuan", "维修员");
        R r = R.ok();
        r.put("token", token);
        r.put("role","维修员");
        r.put("username",weixiuyuan.getWeixiuyuanName());
        r.put("tableName","weixiuyuan");
        r.put("userId",weixiuyuan.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody WeixiuyuanEntity weixiuyuan, HttpServletRequest request) {
//    	ValidatorUtils.validateEntity(user);
        Wrapper<WeixiuyuanEntity> queryWrapper = new EntityWrapper<WeixiuyuanEntity>()
            .eq("username", weixiuyuan.getUsername())
            .or()
            .eq("weixiuyuan_phone", weixiuyuan.getWeixiuyuanPhone())
            .or()
            .eq("weixiuyuan_id_number", weixiuyuan.getWeixiuyuanIdNumber())
            ;
        WeixiuyuanEntity weixiuyuanEntity = weixiuyuanService.selectOne(queryWrapper);
        if(weixiuyuanEntity != null)
            return R.error("账户或者维修员手机号或者维修员身份证号已经被使用");
        weixiuyuan.setCreateTime(new Date());
        weixiuyuanService.insert(weixiuyuan);

        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id, HttpServletRequest request) {
        WeixiuyuanEntity weixiuyuan = weixiuyuanService.selectById(id);
        weixiuyuan.setPassword("123456");
        weixiuyuanService.updateById(weixiuyuan);
        return R.ok();
    }


    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        WeixiuyuanEntity weixiuyuan = weixiuyuanService.selectOne(new EntityWrapper<WeixiuyuanEntity>().eq("username", username));
        if(weixiuyuan!=null){
            weixiuyuan.setPassword("123456");
            weixiuyuanService.updateById(weixiuyuan);
            return R.ok();
        }else{
           return R.error("账号不存在");
        }
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrWeixiuyuan(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        WeixiuyuanEntity weixiuyuan = weixiuyuanService.selectById(id);
        if(weixiuyuan !=null){
            //entity转view
            WeixiuyuanView view = new WeixiuyuanView();
            BeanUtils.copyProperties( weixiuyuan , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }



    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = weixiuyuanService.queryPage(params);

        //字典表数据转换
        List<WeixiuyuanView> list =(List<WeixiuyuanView>)page.getList();
        for(WeixiuyuanView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        WeixiuyuanEntity weixiuyuan = weixiuyuanService.selectById(id);
            if(weixiuyuan !=null){


                //entity转view
                WeixiuyuanView view = new WeixiuyuanView();
                BeanUtils.copyProperties( weixiuyuan , view );//把实体数据重构到view中

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
    public R add(@RequestBody WeixiuyuanEntity weixiuyuan, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,weixiuyuan:{}",this.getClass().getName(),weixiuyuan.toString());
        Wrapper<WeixiuyuanEntity> queryWrapper = new EntityWrapper<WeixiuyuanEntity>()
            .eq("username", weixiuyuan.getUsername())
            .or()
            .eq("weixiuyuan_phone", weixiuyuan.getWeixiuyuanPhone())
            .or()
            .eq("weixiuyuan_id_number", weixiuyuan.getWeixiuyuanIdNumber())
//            .notIn("weixiuyuan_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WeixiuyuanEntity weixiuyuanEntity = weixiuyuanService.selectOne(queryWrapper);
        if(weixiuyuanEntity==null){
            weixiuyuan.setCreateTime(new Date());
        weixiuyuan.setPassword("123456");
        weixiuyuanService.insert(weixiuyuan);

            return R.ok();
        }else {
            return R.error(511,"账户或者维修员手机号或者维修员身份证号已经被使用");
        }
    }

}

