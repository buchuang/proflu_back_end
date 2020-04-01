package cn.proflu.profluweb.controller.wx;


import cn.proflu.profluweb.VO.wx.UserInfo;
import cn.proflu.profluweb.common.exception.ThisAssert;
import cn.proflu.profluweb.common.myEnum.ErrorCodeEnum;
import cn.proflu.profluweb.common.myEnum.InfoCodeEnum;
import cn.proflu.profluweb.common.utils.Const;
import cn.proflu.profluweb.common.utils.HttpUtil;
import cn.proflu.profluweb.common.utils.JsonUtil;
import cn.proflu.profluweb.pojo.wx.WxUserinfo;
import cn.proflu.profluweb.service.wx.WxUserinfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 登录控制器
 * </p>
 *
 * @author buchuangchuang
 * @since 2018-11-09
 */
@RestController
@RequestMapping("/vipSystem/wxapp/wxuser")
@Api(value = "登录", tags = "用户登录的接口")
public class WxUserinfoController {
    /**
     * 用户信息service
     */
    @Autowired
    private WxUserinfoService wxUserinfoService;
    /**
     * redis模板类
     */
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * @param jsCode 用户临时凭证
     * @return 正常返回自定义的uid
     * @throws Exception
     * @desc 这是小程序的登陆入口
     */
    @ApiOperation(value = "登录")
    @GetMapping("/wxlogin")
    public Map<String, Object> WxUserLogin(String jsCode) throws Exception {
        //拼接参数
        ThisAssert.getIsNotNull(jsCode, ErrorCodeEnum.JSCODE_NOT_NULL);
        Map<String, Object> map = null;

        String loginParam = "appid=" + Const.APP_ID + "&" + "secret=" + Const.APP_SECRET + "&" + "js_code=" + jsCode + "&"
                + "grant_type=authorization_code";
        //访问微信服务器

        String result = HttpUtil.sendGet("https://api.weixin.qq.com/sns/jscode2session", loginParam);

        if (result.contains("err")) {
            ThisAssert.getThisExcepton(ErrorCodeEnum.GET_USERINFO_FAIL);
        } else {
            UserInfo userInfo = (UserInfo) JsonUtil.fromJson(result, UserInfo.class);
            String openid = userInfo.getOpenid();
            String session_key = userInfo.getSession_key();
            WxUserinfo wxUserinfo = wxUserinfoService.findByOpenid(openid);

            String uid = UUID.randomUUID().toString();
            WxUserinfo wxUserinfo1 = new WxUserinfo();
            //判断用户是否存在
            if (wxUserinfo == null) {
                wxUserinfo1.setUiUid(uid);
                wxUserinfo1.setUiOpenid(openid);
                wxUserinfo1.setUiSessionKey(session_key);
                wxUserinfo1.setUiType(InfoCodeEnum.USER_LOGIN_TYPE.getCode().toString());
                wxUserinfo1.setUiLastLogintime(LocalDateTime.now());
                wxUserinfo1.setUiLoginCount(1);
                wxUserinfoService.insertWxUserinfo(wxUserinfo1);
            }
            //使用redis来保存用户登陆状态
            String sessionKey_openid = session_key + openid;
            stringRedisTemplate.opsForValue().set(uid, sessionKey_openid, InfoCodeEnum.SESSION_OUTTIME.getCode(), TimeUnit.SECONDS);
            //更新用户状态
            if (wxUserinfo != null) {
                wxUserinfo.setUiUid(uid);
                wxUserinfo.setUiLoginCount(wxUserinfo.getUiLoginCount()+1);
                wxUserinfo.setUiLastLogintime(LocalDateTime.now());
                wxUserinfoService.updateUidByOpenid(wxUserinfo);
            }
            map = Const.getResultMap();
            map.put("uid", uid);
            map.putAll(Const.SUCCESS_RESPONSE);
            return map;
        }
        return Const.FAIL_RESPONSE;
    }

    /**
     * 更新用户信息
     *
     * @param wxUserinfo 用户信息实体类
     * @return
     */
    @ApiOperation(value = "保存用户信息")
    @GetMapping(value = "/updateWxUserInfo")
    public Map updateWxUserInfo(String uid,WxUserinfo wxUserinfo) throws Exception {
        wxUserinfo.setUiUid(uid);
        wxUserinfoService.updateUserInfoByUid(wxUserinfo);
        return Const.SUCCESS_RESPONSE;
    }

}
