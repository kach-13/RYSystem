package com.ry.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

@RestController
public class Image {//获取
    @GetMapping("/image/{name}")
    public void getImage(@PathVariable("name") String name , HttpServletResponse response) throws IOException {
        //使用字节流读取本地图片
        ServletOutputStream out=null;
        BufferedInputStream buf=null;
        //创建一个文件对象，对应的文件就是python把词云图片生成后的路径以及对应的文件名
        File file = new File("D:\\UserImage\\" +  name );
        try {
            //使用输入读取缓冲流读取一个文件输入流
            buf=new BufferedInputStream(new FileInputStream(file));
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
        }
        //传输结束后，删除文件，可以不删除，在生成的图片中回对此进行覆盖
    }
    @GetMapping("/captchaImage")//获取验证码图片
    public Map GetCodeImage(HttpServletResponse response) throws IOException {
        //创建文件输出流对象
        File file = new File("D:\\UserImage\\code\\"+System.currentTimeMillis()+".jpg");//创建一个空的JPG对象
        FileOutputStream out = null;
        CreateCodeImae createCodeImae = new CreateCodeImae();
        //使用字节流读取本地图片
        Map<String,Object> Codmap = createCodeImae.generateCodeAndPic();//创建验证码图片
        Map ReturnMap = new HashMap(); //存储返回参数
        if (!file.exists()) {
            // 先得到文件的上级目录，并创建上级目录，在创建文件
            //file.getParentFile().mkdir();
            file.createNewFile();
        }
        FileInputStream inputstream = new FileInputStream(file);
        try {
            out = new FileOutputStream(file);//向创建的空图片对象输入信息
            ImageIO.write((RenderedImage) Codmap.get("img"), "jpeg", out);
            //读取创建完的图像
            byte[] bytes = new byte[inputstream.available()];
            inputstream.read(bytes, 0, inputstream.available());
            ReturnMap.put("img",bytes); //返回图片有两种方式，通过 out.flush();，或返回字节数组
            ReturnMap.put("uuid",Codmap.get("code"));//验证码答案

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            out.close();
            inputstream.close();
        }
        file.delete();
        return ReturnMap;
    }
}
