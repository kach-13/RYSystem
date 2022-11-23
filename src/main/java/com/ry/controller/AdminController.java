package com.ry.controller;

import com.ry.Conf.JwtUnit;
import com.ry.mapper.SysMenuMapper;
import com.ry.mapper.SysRoleMapper;
import com.ry.mapper.SysUserRoleMapper;
import com.ry.mapper.sys_userMapper;
import com.ry.pojo.*;
import com.ry.vo.AjaxResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AdminController {
   @Autowired
    private sys_userMapper serMapper;
    private sys_userExample example = new sys_userExample();
    @PostMapping("login")
    public AjaxResult login(@RequestBody sys_user sys_users){
        AjaxResult ajaxResult;
        if (!sys_users.getCode().toLowerCase().equals(sys_users.getUuid().toLowerCase())){
            ajaxResult = AjaxResult.error("验证码错误");
            return ajaxResult;
        }
        sys_userExample.Criteria criteria = example.createCriteria();
        example.clear();
        criteria.andUsernameEqualTo(sys_users.getUsername()).andPasswordEqualTo(sys_users.getPassword());
        example.createCriteria().andPasswordEqualTo(sys_users.getPassword());
        List<sys_user> sys_users1 = serMapper.selectByExample(example);

        if(sys_users1.size() != 0){
            Integer id = Integer.valueOf(sys_users1.get(0).getUserId().intValue());
            String s = JwtUnit.SetToken(sys_users1.get(0).getUsername(), id);
            ajaxResult = AjaxResult.success();
            ajaxResult.put("token",s);
            return ajaxResult;
        }
        ajaxResult = AjaxResult.error("密码错误");
        ajaxResult.put("403","账号或密码错误");
        return ajaxResult;

    }
    private SysUserRoleExample sysUserRoleExample = new SysUserRoleExample();
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @GetMapping("getInfo")
    public AjaxResult getInfo(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for(int i = 0 ; i < cookies.length ; i ++){
            if("Admin-Token".equals(cookies[i].getName())){
                String s = JwtUnit.parseToken(cookies[i].getValue());
                int id = Integer.valueOf(s);
                sys_user sys_user = serMapper.selectByPrimaryKey(Long.valueOf(id));
                if(sys_user != null){
                    AjaxResult ajaxResult = AjaxResult.success();
                    ajaxResult.put("user",sys_user);
                    sysUserRoleExample.clear();
                    sysUserRoleExample.createCriteria().andUserIdEqualTo(sys_user.getUserId());
                   List<SysUserRoleKey> sysUserRoleKey =  sysUserRoleMapper.selectByExample(sysUserRoleExample);
                   SysRole sysRole = sysRoleMapper.selectByPrimaryKey(sysUserRoleKey.get(0).getRoleId());
                    ajaxResult.put("roles",sysRole);
                    return ajaxResult;
                }
            }
        }
        AjaxResult ajaxResult = AjaxResult.error();
        ajaxResult.put("402","未登录");
        return ajaxResult;
    }
    private SysMenuExample sysMenuExample = new SysMenuExample();
    @Autowired
    private SysMenuMapper sysMenuMapper;
    @ResponseBody
    @GetMapping("/getRouters")//获取菜单
    public AjaxResult getRouter(){
        //List<SysMenu> list = new ArrayList<>();
        sysMenuExample.clear();
        sysMenuExample.createCriteria().andParentIdEqualTo(0L);
        List<SysMenu> FsysMenus = sysMenuMapper.selectByExample(sysMenuExample);//所有父级菜单
        sysMenuExample.clear();
        sysMenuExample.createCriteria().andParentIdNotEqualTo(0L);
        List<SysMenu> CsysMenus = sysMenuMapper.selectByExample(sysMenuExample);//所有子级菜单
        for(SysMenu sysMenu : FsysMenus){
            List<SysMenu> list1 = iterateMenus(CsysMenus, sysMenu.getMenuId().toString());
            sysMenu.setChildList(list1);
        }
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("data",FsysMenus);
        return ajaxResult;
    }


    /**
     * 多级菜单查询方法
     *
     * @param menuVoList 不包含最高层次菜单的菜单集合
     * @param pid        父类id
     * @return
     */
    public List<SysMenu> iterateMenus(List<SysMenu> menuVoList, String pid) {
        List<SysMenu> result = new ArrayList<>();
        for (SysMenu menu : menuVoList) {
            //获取菜单的id
            Long menuid = menu.getMenuId();
            //获取菜单的父id
            String  parentid =String.valueOf(menu.getParentId());
            if (StringUtils.isNotBlank(parentid)) {
                if (parentid.equals(pid)) {
                    //递归查询当前子菜单的子菜单
                    List<SysMenu> iterateMenu = iterateMenus(menuVoList, String.valueOf(menuid));
                    menu.setChildList(iterateMenu);
                    result.add(menu);
                }
            }
        }
        return result;
    }
    @PostMapping("/logout") // 退出登录
    public  AjaxResult LUGOUT(HttpServletRequest request, HttpSession session , HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        //session.setAttribute("Admin-Token",null);
        for(int i = 0 ; i < cookies.length ; i ++){
            if(cookies[i].getName().equals("Admin-Token")){//判断登录状态
                //redisTemplate.delete(cookies[i].getValue());
                cookies[i].setValue(null);
                cookies[i].setPath("/");
                response.addCookie( cookies[i]);
                break;
            }
        }
        AjaxResult ajaxResult = AjaxResult.success();
        return ajaxResult;
    }


}
