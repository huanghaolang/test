package com.ac.jwtToken;

import com.ac.entity.TUser;
import com.ac.entity.Token;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

@Component
public class TokenUtil {

    @Resource
    private Token token;

    public static final int calendarField = Calendar.MINUTE;
    public static String getToken(TUser user) {
        String token="";
        token= JWT.create().withAudience(user.getUserId())
                .withClaim("roleId",user.getRoleId())
                .sign(Algorithm.HMAC256(user.getUserPwd()));

        return token;
    }

    public  String getFinalToken(TUser user) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.add(calendarField,token.getInterval());
        Date startDate=calendar.getTime();
        String tokenStr="";
        tokenStr= JWT.create()
                .withHeader(token.getHeaderClaims())
                .withIssuer(token.getIss())
                .withExpiresAt(startDate)
                .withClaim("userId",user.getUserId())
                .withClaim("userPwd",user.getUserPwd())
                .withClaim("roleId",user.getRoleId())
                .withSubject(token.getSub())
                .sign(Algorithm.HMAC256(token.getPassword()));
        return tokenStr;
    }
    public  Map<String, Claim> verifyToken(String tokenStr) {
        DecodedJWT jwt = null;
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(token.getPassword())).build();
            jwt = verifier.verify(tokenStr);
        } catch (Exception e) {
             e.printStackTrace();
            // token 校验失败, 抛出Token验证非法异常
            throw new RuntimeException("token不存在或已过期");
        }
        return jwt.getClaims();
    }

}
