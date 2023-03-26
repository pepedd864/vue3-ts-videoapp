package com.pepedd.vue3tsvideoappspringboot.utils;

import io.jsonwebtoken.*;
import org.springframework.util.StringUtils;

import java.util.Date;

public class JwtHelper {
  private static long tokenExpiration = 24*60*60*1000;  // token过期时间
  private static String tokenSignKey = "123456";  // token签名密钥

  /***
   * 生成token
   * @param userId  用户id
   * @param userType  用户类型
   * @return  返回token
   */
  public static String createToken(Long userId, Integer userType) {
    String token = Jwts.builder()
        // 设置头信息
        .setSubject("YYGH-USER")
        // 设置过期时间
        .setExpiration(new Date(System.currentTimeMillis() + tokenExpiration))
        // 设置token主体部分，存储用户信息
        .claim("userId", userId)
//                .claim("userName", userName)
        .claim("userType", userType)
        // 设置签名密钥
        .signWith(SignatureAlgorithm.HS512, tokenSignKey)
        .compressWith(CompressionCodecs.GZIP)
        .compact();
    return token;
  }

  /***
   * 从token中获取用户id
   * @param token token字符串
   * @return  返回用户id
   */

  public static Long getUserId(String token) {
    if(StringUtils.isEmpty(token)) return null;
    Jws<Claims> claimsJws = Jwts.parser().setSigningKey(tokenSignKey).parseClaimsJws(token);
    Claims claims = claimsJws.getBody();
    Integer userId = (Integer)claims.get("userId");
    return userId.longValue();
  }

  /***
   * 从token字符串获取userType
   * @param token token字符串
   * @return  返回userType
   */

  public static Integer getUserType(String token) {
    if(StringUtils.isEmpty(token)) return null;
    Jws<Claims> claimsJws
        = Jwts.parser().setSigningKey(tokenSignKey).parseClaimsJws(token);
    Claims claims = claimsJws.getBody();
    return (Integer)(claims.get("userType"));
  }

  //从token字符串获取userName
  public static String getUserName(String token) {
    if(StringUtils.isEmpty(token)) return "";
    Jws<Claims> claimsJws
        = Jwts.parser().setSigningKey(tokenSignKey).parseClaimsJws(token);
    Claims claims = claimsJws.getBody();
    return (String)claims.get("userName");
  }

  /***
   * 判断token是否有效
   * @param token token字符串
   * @return  返回是否有效
   */

  public static boolean isExpiration(String token){
    try {
      boolean isExpire = Jwts.parser()
          .setSigningKey(tokenSignKey)
          .parseClaimsJws(token)
          .getBody()
          .getExpiration().before(new Date());
      //没有过期，有效，返回false
      return isExpire;
    }catch(Exception e) {
      //过期出现异常，返回true
      return true;
    }
  }


  /**
   * 刷新Token
   * @param token 旧token
   * @return  返回新token
   */
  public String refreshToken(String token) {
    String refreshedToken;
    try {
      final Claims claims = Jwts.parser()
          .setSigningKey(tokenSignKey)
          .parseClaimsJws(token)
          .getBody();
      refreshedToken = JwtHelper.createToken(getUserId(token), getUserType(token));
    } catch (Exception e) {
      refreshedToken = null;
    }
    return refreshedToken;
  }

  // 测试
  public static void main(String[] args) {
//        String token = JwtHelper.createToken(1L, "lucy");
//        System.out.println(token);
//        System.out.println(JwtHelper.getUserId(token));
//        System.out.println(JwtHelper.getUserName(token));
  }
}


