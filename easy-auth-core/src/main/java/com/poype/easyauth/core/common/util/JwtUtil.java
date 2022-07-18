package com.poype.easyauth.core.common.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JwtUtil {

    // JWT超时时间 5 分钟
    private static final long EXPIRATION = 1000 * 60 * 5;

    private static final Algorithm algorithm = Algorithm.HMAC256("h5#9%3%^*FxA");

    public static String createJWT(String userId, List<String> permissionNameList, String token) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("userId", userId);
        payload.put("pList", permissionNameList);
        payload.put("token", token);

        return JWT.create()
                .withPayload(payload)
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION))
                .sign(algorithm);
    }

    public static void parseJWT(String jwtStr) {
        DecodedJWT decodedJWT = JWT.decode(jwtStr);
        // 验证签名
        algorithm.verify(decodedJWT);

        Date expiresAt = decodedJWT.getExpiresAt();
        Date now = new Date();
        if (now.after(expiresAt)) {
            // todo JWT已过期，使用token对其进行刷新

        }

        System.out.println(decodedJWT.getClaim("userId"));
        System.out.println(decodedJWT.getClaim("pList"));
        System.out.println(decodedJWT.getClaim("token"));
    }
}

/*
    JWT: json web token
    JWT组成： header.payload.signature，各个部分会用base64编码
    header中包含令牌类型(JWT)和签名算法:
    {
        "alg": "HS256",
        "typ": "JWT"
    }
    payload有效负载，不要在payload中包含特别敏感的信息:
    {
        "sub": "1234567890",
        "name": "john",
        "admin": true
    }
*/