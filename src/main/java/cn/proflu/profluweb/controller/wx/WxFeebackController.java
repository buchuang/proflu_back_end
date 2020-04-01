package cn.proflu.profluweb.controller.wx;


import cn.proflu.profluweb.common.utils.Const;
import cn.proflu.profluweb.service.wx.WxFeebackService;
import cn.proflu.profluweb.service.wx.WxUserinfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 * 意见反馈接口
 * </p>
 *
 * @author 卜闯闯
 * @since 2018-11-13
 */
@RestController
@RequestMapping("/vipSystem/wxapp/personal")
@Api(value = "意见反馈", tags = "意见反馈的接口")
public class WxFeebackController {

    /**
     * 用户信息service
     */
    @Autowired
    private WxUserinfoService wxUserinfoService;
    /**
     * 反馈信息service
     */
    @Autowired
    private WxFeebackService wxFeebackService;

    /**
     * 保存用户反馈信息
     * @param uid 用户登录session
     * @param feedback 反馈信息
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "保存用户反馈信息")
    @GetMapping("/updateFeedback")
    public Map updateFeedback(String uid, String feedback) throws Exception {
        String openid = wxUserinfoService.findOpenidByUid(uid);
        wxFeebackService.insertFeedback(openid, feedback);

        return Const.SUCCESS_RESPONSE;
    }
}
