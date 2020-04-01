package cn.proflu.profluweb.controller.wx;


import cn.proflu.profluweb.common.utils.Const;
import cn.proflu.profluweb.service.wx.WxFocusService;
import cn.proflu.profluweb.service.wx.WxUserinfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 * 用户关注和取消关注接口
 * </p>
 *
 * @author 卜闯闯
 * @since 2018-11-13
 */
@RestController
@RequestMapping("/vipSystem/wxapp/focus")
@Api(value = "关注", tags = "关注的接口")
public class WxFocusController {

    /**
     * 用户信息service
     */
    @Autowired
    private WxUserinfoService wxUserinfoService;
    /**
     * 关注service
     */
    @Autowired
    private WxFocusService wxFocusService;

    /**
     * 保存用户关注
     * @param uid 用户登录session
     * @param topic_id 关注话题id
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "保存用户关注")
    @GetMapping("/updateFocus")
    public Map updateFocus(String uid, String topic_id) throws Exception {

        String openid = wxUserinfoService.findOpenidByUid(uid);

        wxFocusService.insertFocus(openid, topic_id);

        return Const.SUCCESS_RESPONSE;
    }

    /**
     * 取消用户关注
     * @param uid 用户登录session
     * @param topic_id 取消关注话题id
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "取消用户关注")
    @GetMapping("/cancelFocus")
    public Map cancelFocus(String uid, String topic_id) throws Exception {

        String openid = wxUserinfoService.findOpenidByUid(uid);

        wxFocusService.deleteFocus(openid,topic_id);
        return Const.SUCCESS_RESPONSE;
    }
}
