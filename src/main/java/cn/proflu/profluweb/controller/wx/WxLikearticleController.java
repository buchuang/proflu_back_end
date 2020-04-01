package cn.proflu.profluweb.controller.wx;

import cn.proflu.profluweb.common.exception.ThisAssert;
import cn.proflu.profluweb.common.myEnum.ErrorCodeEnum;
import cn.proflu.profluweb.common.myEnum.InfoCodeEnum;
import cn.proflu.profluweb.common.utils.Const;
import cn.proflu.profluweb.common.utils.HttpUtil;
import cn.proflu.profluweb.common.utils.Json4Map;
import cn.proflu.profluweb.pojo.wx.WxLikearticle;
import cn.proflu.profluweb.service.wx.WxInterfaceInfoService;
import cn.proflu.profluweb.service.wx.WxLikearticleService;
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
 * 用户点赞和取消点赞接口
 * </p>
 *
 * @author 卜闯闯
 * @since 2018-11-11
 */
@RestController
@RequestMapping("/vipSystem/wxapp/likearticle")
@Api(value = "点赞", tags = "点赞的接口")
public class WxLikearticleController {

    /**
     * 用户信息service
     */
    @Autowired
    private WxUserinfoService wxUserinfoService;
    /**
     * 布本接口service
     */
    @Autowired
    private WxInterfaceInfoService wxInterfaceInfoService;
    /**
     * 点赞service
     */
    @Autowired
    private WxLikearticleService wxLikearticleService;

    /**
     * 保存点赞信息
     * @param uid 用户登录session
     * @param iid 新闻标识
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "保存点赞信息")
    @GetMapping("/updateLikeArt")
    public Map updateLikeArticle(String uid, String iid) throws Exception {

        String openid = wxUserinfoService.findOpenidByUid(uid);

        String result = HttpUtil.sendGet1(wxInterfaceInfoService.findInurlByInid(InfoCodeEnum.GET_NEWS_DETAIL.getCode()).getInUrl() + iid + ".json");
        ThisAssert.getIsNotNull(result, ErrorCodeEnum.GET_RESULT_FAIL);

        WxLikearticle wxLikearticle = new WxLikearticle();
        wxLikearticle.setLOpenid(openid);
        wxLikearticle.setLIid(iid);

        wxLikearticleService.insertUserUp(wxLikearticle);

        Map map = Const.getResultMap();
        map.putAll(Const.SUCCESS_RESPONSE);
        return map;
    }

    /**
     * 取消点赞信息
     * @param uid 用户登录session
     * @param iid 新闻标识
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "取消点赞信息")
    @GetMapping("/cancelLike")
    public Map cancelLike(String uid, String iid) throws Exception {

        String openid = wxUserinfoService.findOpenidByUid(uid);

        String result = HttpUtil.sendGet1(wxInterfaceInfoService.findInurlByInid(InfoCodeEnum.GET_NEWS_DETAIL.getCode()).getInUrl() + iid + ".json");
        ThisAssert.getIsNotNull(result, ErrorCodeEnum.GET_RESULT_FAIL);

        String title = Json4Map.getNewsInfo(result);

        WxLikearticle wxLikearticle = new WxLikearticle();
        wxLikearticle.setLOpenid(openid);
        wxLikearticle.setLIid(iid);

        wxLikearticleService.deleteUserUp(wxLikearticle);

        Map map = Const.getResultMap();
        map.putAll(Const.SUCCESS_RESPONSE);
        return map;
    }
}
