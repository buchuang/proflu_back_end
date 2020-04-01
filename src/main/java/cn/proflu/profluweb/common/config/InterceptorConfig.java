package cn.proflu.profluweb.common.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.proflu.profluweb.common.exception.ThisAssert;
import cn.proflu.profluweb.common.myEnum.ErrorCodeEnum;
import cn.proflu.profluweb.common.utils.Const;
import cn.proflu.profluweb.common.utils.SessionUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


@Component
public class InterceptorConfig implements HandlerInterceptor {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        StringBuffer url = request.getRequestURL();
        if (url.indexOf("/wxlogin") > 0) {
            return true;
        }
        if (url.indexOf("/vipSystem/wxapp/") > 0) {
            String uid = request.getParameter("uid");
            uid = uid == null ? request.getHeader("uid") : uid;
            if (StringUtils.isBlank(uid)) {
                ThisAssert.getThisExcepton(ErrorCodeEnum.USER_UID_NULL);
                return false;
            }
            boolean sessionInvalid = SessionUtil.isSessionInvalid(stringRedisTemplate, uid);
            if (!sessionInvalid) {
                ThisAssert.getThisExcepton(ErrorCodeEnum.NOT_RIGHT_SESSION);
                return false;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // TODO Auto-generated method stub

    }

}
