package com.ry.controller;

import com.ry.Conf.JwtUnit;
import com.ry.mapper.sys_userMapper;
import com.ry.pojo.sys_user;
import com.ry.vo.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/system/user")
public class UserController {
    @Autowired
    private sys_userMapper sys_userMapper;
    @GetMapping("/profile")//获取当前登录用户信息
    public AjaxResult getUserprofile(HttpServletRequest request){
        String UserID = JwtUnit.getTokenCookie("Admin-Token", request);
        sys_user sys_user = sys_userMapper.selectByPrimaryKey(Long.valueOf(UserID));
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("data",sys_user);
        return ajaxResult;
    }

    @PutMapping("/profile")//用户更新
    public AjaxResult updataUser(@RequestBody sys_user sys_user){
        int i = sys_userMapper.updateByPrimaryKey(sys_user);
        AjaxResult ajaxResult;
        if(i == 1){
            ajaxResult = AjaxResult.success();
            return ajaxResult;
        }

        ajaxResult = AjaxResult.error();
        return ajaxResult;
    }

    @PostMapping("/profile/avatar")//头像修改
    public AjaxResult UpdataAvatar(@RequestParam("avatarfile") MultipartFile file, HttpServletRequest request , HttpServletResponse response){
        String UserID = JwtUnit.getTokenCookie("Admin-Token", request);
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
//		 用户ID + uuid + 图片名称
        String filename = UserID + uuid + file.getOriginalFilename() + ".jpg";
        sys_user sys_user = sys_userMapper.selectByPrimaryKey(Long.valueOf(UserID));
        //要删除掉用户之前的头像
        int index = sys_user.getAvatar().lastIndexOf("/");
        String oldImageName = sys_user.getAvatar().substring(index);
        File file1 = new File("D:\\UserImage\\" + oldImageName);
        file1.delete();

        sys_user.setAvatar("/image/" + filename);
        sys_userMapper.updateByPrimaryKey(sys_user);//更新数据库头像
//        将前端文件  保存到本地
        try {
            file.transferTo(new File("D:\\UserImage\\", filename));
            AjaxResult ajaxResult = AjaxResult.success();
//在读取一次给前端
           /* //使用字节流读取本地图片
            ServletOutputStream out=null;
            BufferedInputStream buf=null;
            //创建一个文件对象，对应的文件就是python把词云图片生成后的路径以及对应的文件名
            sys_user newsys_user = sys_userMapper.selectByPrimaryKey(Long.valueOf(UserID));
            //要删除掉用户之前的头像
            int newindex = newsys_user.getAvatar().lastIndexOf("/");
            String newImageName = newsys_user.getAvatar().substring(index);
            File file2 = new File("C:\\Users\\Hasee\\Pictures\\Saved Pictures\\" + newImageName);
            try {
                //使用输入读取缓冲流读取一个文件输入流
                buf=new BufferedInputStream(new FileInputStream(file2));
                //利用response获取一个字节流输出对象
                out=response.getOutputStream();
                //定义个数组，由于读取缓冲流中的内容
                byte[] buffer=new byte[1024];
                //while循环一直读取缓冲流中的内容到输出的对象中
                while(buf.read(buffer)!=-1) {
                    out.write(buffer);
                }
                //写出到请求的地方
                out.flush();
            }catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }finally {
                if(buf!=null) buf.close();
                if(out!=null) out.close();
            }*/
            return ajaxResult;

        } catch (IOException e) {
            e.printStackTrace();
        }
    return null;
    }


}
