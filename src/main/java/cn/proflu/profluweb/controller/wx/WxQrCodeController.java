package cn.proflu.profluweb.controller.wx;


import cn.proflu.profluweb.common.utils.Const;
import cn.proflu.profluweb.pojo.wx.WxQrCode;
import cn.proflu.profluweb.service.wx.WxQrCodeService;
import cn.proflu.profluweb.service.wx.WxUserinfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 * 二维码接口
 * </p>
 *
 * @author 卜闯闯
 * @since 2018-11-12
 */
@RestController
@RequestMapping("/vipSystem/wxapp/QR_code")
@Api(value = "二维码", tags = "二维码的接口")
public class WxQrCodeController {
    /**
     * 用户信息service
     */
    @Autowired
    private WxUserinfoService wxUserinfoService;
    /**
     * 二维码service
     */
    @Autowired
    private WxQrCodeService wxQrCodeService;

    /**
     * 获取二维码
     *
     * @param id 二维码标识
     * @param uid 用户session
     * @return
     */
    @ApiOperation(value = "获取二维码")
    @GetMapping("/queryQR_code")
    public Map queryErweima(String id, String uid) throws Exception {

        String openid = wxUserinfoService.findOpenidByUid(uid);

        WxQrCode wxQrCode = wxQrCodeService.findErWeiMa(id);

        Map map = Const.getResultMap();
        map.put("Qr_id", wxQrCode.getQrId());
        map.put("URL", wxQrCode.getQrUrl());

        return map;
    }
}
