package cn.proflu.profluweb.controller.wx;

import cn.proflu.profluweb.common.exception.ThisAssert;
import cn.proflu.profluweb.common.myEnum.ErrorCodeEnum;
import cn.proflu.profluweb.common.myEnum.InfoCodeEnum;
import cn.proflu.profluweb.common.utils.Const;
import cn.proflu.profluweb.common.utils.HttpUtil;
import cn.proflu.profluweb.common.utils.Json4Map;
import cn.proflu.profluweb.pojo.wx.WxCollection;
import cn.proflu.profluweb.service.wx.WxCollectionService;
import cn.proflu.profluweb.service.wx.WxInterfaceInfoService;
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
 * 用户收藏新闻接口
 * </p>
 *
 * @author 卜闯闯
 * @since 2018-11-11
 */
@RestController
@RequestMapping("/vipSystem/wxapp/collection")
@Api(value = "收藏", tags = "收藏的接口")
public class WxCollectionController {
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
     * 收藏service
     */
    @Autowired
    private WxCollectionService wxCollectionService;

    /**
     * 保存用户收藏
     * @param uid 用户登录session
     * @param iid 新闻的标识
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "保存用户收藏")
    @GetMapping("/updateCollection")
    public Map updateCollection(String uid, String iid) throws Exception {
        String openid = wxUserinfoService.findOpenidByUid(uid);

        String result = HttpUtil.sendGet1(wxInterfaceInfoService.findInurlByInid(InfoCodeEnum.GET_NEWS_DETAIL.getCode()).getInUrl() + iid + ".json");
        ThisAssert.getIsNotNull(result, ErrorCodeEnum.GET_RESULT_FAIL);

        String title = Json4Map.getNewsInfo(result);
        WxCollection wxCollection = new WxCollection();
        wxCollection.setCoOpenid(openid);
        wxCollection.setCoIid(iid);
        wxCollection.setCoTitle(title);
        wxCollectionService.insertUserColletion(wxCollection);
        Map map = Const.getResultMap();
        map.putAll(Const.SUCCESS_RESPONSE);
        return map;
    }

    /**
     * 取消用户收藏
     * @param uid 用户登录session
     * @param iid 新闻的标识
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "取消用户收藏")
    @GetMapping("/cancelCollect")
    public Map cancelCollect(String uid, String iid) throws Exception {

        String openid = wxUserinfoService.findOpenidByUid(uid);

        wxCollectionService.deleteUserColletion(openid, iid);
        Map map = Const.getResultMap();
        map.putAll(Const.SUCCESS_RESPONSE);
        return map;
    }
}
