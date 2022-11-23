package com.ry.Conf;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUnit {
    private static final long MAX_TIME = 15 * 60 * 1000;//設置過期時間
    //token秘钥
    private static final String TOKEN_SECRET = "ZCEQIUBFKSJBFJH2020BQWE";
    public static String SetToken(String username , Integer userid) {//登录成功写入token返回前台
    String token = "";
    try{
        Date date = new Date(System.currentTimeMillis() +MAX_TIME );
        //秘钥及加密算法
        Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
        //设置头部信息
        Map<String,Object> header = new HashMap<>();
        header.put("typ","JWT");
        header.put("alg","HS256");
        //携带username，password信息，生成签名
        token = JWT.create().withHeader(header)
                          .withClaim("uesrname",username)
                          .withClaim("userid",userid).withExpiresAt(date)
                          .sign(algorithm);

    }catch (Exception e)
    { e.printStackTrace();
    return  null;
    }
    return token;
    }
    public static String parseToken(String token) {//获取token指定名称的数据
        DecodedJWT jwt = JWT.decode(token);
        String userid = jwt.getClaim("userid").toString();
        return userid;
    }
    //读取Token信息
    public static String getTokenCookie(String cookieName, HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for(int i = 0 ; i < cookies.length ; i ++){
            if(cookieName.equals(cookies[i].getName())){
                String s = JwtUnit.parseToken(cookies[i].getValue());
                return s;
            }
        }
        return null;
    }
}
