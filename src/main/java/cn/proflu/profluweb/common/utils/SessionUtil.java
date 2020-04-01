package cn.proflu.profluweb.common.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;


public class SessionUtil {

    public static boolean isSessionInvalid(StringRedisTemplate stringRedisTemplate, String uid) {
        boolean flag = true;
        boolean b = stringRedisTemplate.hasKey(uid);
        if (b) {
            Long expire = stringRedisTemplate.boundSetOps(uid).getExpire();
            if (expire < 0) {
                flag = false;
                stringRedisTemplate.delete(uid);
            }
        } else {
            flag = false;
        }
        return flag;
    }
}
