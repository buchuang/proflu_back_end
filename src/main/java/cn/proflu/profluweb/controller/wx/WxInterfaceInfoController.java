package cn.proflu.profluweb.controller.wx;


import cn.proflu.profluweb.VO.wx.NewsParamInfo;
import cn.proflu.profluweb.common.exception.ThisAssert;
import cn.proflu.profluweb.common.myEnum.ErrorCodeEnum;
import cn.proflu.profluweb.common.myEnum.InfoCodeEnum;
import cn.proflu.profluweb.common.utils.Const;
import cn.proflu.profluweb.common.utils.HttpUtil;
import cn.proflu.profluweb.service.wx.WxCollectionService;
import cn.proflu.profluweb.service.wx.WxInterfaceInfoService;
import cn.proflu.profluweb.service.wx.WxUserinfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLEncoder;
import java.util.Map;

/**
 * <p>
 * 存放所有的第三方接口信息 前端控制器
 * </p>
 *
 * @author 卜闯闯
 * @since 2018-11-10
 */
@RestController
@RequestMapping("/vipSystem/wxapp/getnews")
@Api(value = "新闻", tags = "新闻的接口")
public class WxInterfaceInfoController {
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
     * 获取收藏内容列表接口
     *
     * @param uid 用户session
     * @return
     */
    @ApiOperation(value = "获取用户收藏列表")
    @GetMapping("/user_collect")
    public Map GetUserCollect(String uid) throws Exception {


        String openid = wxUserinfoService.findOpenidByUid(uid);

        String requestParam = "uid=" + openid;

        String result = HttpUtil.sendGet(wxInterfaceInfoService.findInurlByInid(InfoCodeEnum.USER_CLOOECT_INFO.getCode()).getInUrl(), requestParam);
        ThisAssert.getIsNotNull(result, ErrorCodeEnum.GET_RESULT_FAIL);
        Map map = Const.getResultMap();
        map.put("result", result);
        return map;
    }

    /**
     * 获取关注话题列表接口
     *
     * @param uid 用户session
     * @return
     */
    @ApiOperation(value = "获取用户关注话题列表")
    @GetMapping("/user_topic")
    public Map GetUserTopic(String uid) throws Exception {


        String openid = wxUserinfoService.findOpenidByUid(uid);

        String requestParam = "uid=" + openid;

        String result = HttpUtil.sendGet(wxInterfaceInfoService.findInurlByInid(InfoCodeEnum.USER_FOCUS_TOPIC.getCode()).getInUrl(), requestParam);
        ThisAssert.getIsNotNull(result, ErrorCodeEnum.GET_RESULT_FAIL);

        Map map = Const.getResultMap();
        map.put("result", result);
        return map;
    }

    /**
     * 获取话题内容列表接口
     *
     * @param uid 用户session
     * @param guid
     * @param topic_id
     * @return
     */
    @ApiOperation(value = "获取话题内容列表")
    @GetMapping("/topic")
    public Map GetTopicList(String uid, String guid, String topic_id) throws Exception {

        String openid = wxUserinfoService.findOpenidByUid(uid);

        String requestParam = "uid=" + openid + "&guid=" + guid + "&topic_id=" + topic_id;

        String result = HttpUtil.sendGet(wxInterfaceInfoService.findInurlByInid(InfoCodeEnum.GET_TOPIC_LIST.getCode()).getInUrl(), requestParam);
        ThisAssert.getIsNotNull(result, ErrorCodeEnum.GET_RESULT_FAIL);

        Map map = Const.getResultMap();
        map.put("result", result);
        return map;
    }

    /**
     * 获取热门话题内容列表接口
     *
     * @param uid
     * @param page_size
     * @return
     */
    @ApiOperation(value = "获取热门话题列表")
    @GetMapping("/hotTopic")
    public Map GetHotTopic(String uid, String page_size) throws Exception {

        String openid = wxUserinfoService.findOpenidByUid(uid);

        String requestParam = "uid=" + openid + "&page_size=" + page_size;

        String result = HttpUtil.sendGet(wxInterfaceInfoService.findInurlByInid(InfoCodeEnum.GET_HOT_TOPIC.getCode()).getInUrl(), requestParam);
        ThisAssert.getIsNotNull(result, ErrorCodeEnum.GET_RESULT_FAIL);

        Map map = Const.getResultMap();
        map.put("result", result);
        return map;
    }

    /**
     * 订阅/取消订阅话题接口
     *
     * @param newsParamInfo
     * @return
     */
    @ApiOperation(value = "订阅/取消订阅")
    @GetMapping("/subtopic")
    public Map UserSubTopic(NewsParamInfo newsParamInfo) throws Exception {
        String uid = newsParamInfo.getUid();
        String guid = newsParamInfo.getGuid();
        String dt = newsParamInfo.getDt();
        String plt = newsParamInfo.getPlt();
        String topic_id = newsParamInfo.getTopic_id();
        String type = newsParamInfo.getType();

        String openid = wxUserinfoService.findOpenidByUid(uid);

        String requestParam = "uid=" + openid + "&guid=" + guid + "&dt=" + dt + "&plt=" + plt + "&topic_id=" + topic_id + "&type=" + type;

        String result = HttpUtil.sendGet(wxInterfaceInfoService.findInurlByInid(InfoCodeEnum.USER_SUB_TOPIC.getCode()).getInUrl(), requestParam);
        ThisAssert.getIsNotNull(result, ErrorCodeEnum.GET_RESULT_FAIL);

        Map map = Const.getResultMap();
        map.put("result", result);
        return map;
    }

    /**
     * 话题详情接口
     *
     * @param uid
     * @param id
     * @return
     */
    @ApiOperation(value = "获取话题详情")
    @GetMapping("/tpc_detail")
    public Map GetTopicDetail(String uid, String id) throws Exception {

        String openid = wxUserinfoService.findOpenidByUid(uid);

        String requestParam = "uid=" + openid + "&guid=" + openid + "&id=" + id;
        String result = HttpUtil.sendGet(wxInterfaceInfoService.findInurlByInid(InfoCodeEnum.GET_TOPIC_DETAIL.getCode()).getInUrl(), requestParam);
        ThisAssert.getIsNotNull(result, ErrorCodeEnum.GET_RESULT_FAIL);

        Map map = Const.getResultMap();
        map.put("result", result);
        return map;
    }

    /**
     * 个性化推荐接口
     *
     * @param uid
     * @param column_id
     * @return
     */
    @ApiOperation(value = "获取个性化推荐列表")
    @GetMapping("/feed")
    public Map GetCommend(String uid, String column_id) throws Exception {

        String openid = wxUserinfoService.findOpenidByUid(uid);

        String requestParam = "uid=" + openid + "&column_id=" + column_id;
        String result = HttpUtil.sendGet(wxInterfaceInfoService.findInurlByInid(InfoCodeEnum.GET_INDIVIDUATION_COMMEND.getCode()).getInUrl(), requestParam);
        ThisAssert.getIsNotNull(result, ErrorCodeEnum.GET_RESULT_FAIL);

        Map map = Const.getResultMap();
        map.put("result", result);
        return map;
    }

    /**
     * 内容详情查询接口
     *
     * @param iid
     * @return
     */
    @ApiOperation(value = "获取新闻详情")
    @GetMapping("/new_detail")
    public Map GetNewDetail(String iid) throws Exception {
        ThisAssert.getIsNotNull(iid, ErrorCodeEnum.NEWSID_NOT_NULL);

        String result = HttpUtil.sendGet1(wxInterfaceInfoService.findInurlByInid(InfoCodeEnum.GET_NEWS_DETAIL.getCode()).getInUrl() + iid + ".json");
        ThisAssert.getIsNotNull(result, ErrorCodeEnum.GET_RESULT_FAIL);

        Map map = Const.getResultMap();
        map.put("result", result);
        return map;
    }

    /**
     * 相关推荐接口
     *
     * @param uid
     * @param ct
     * @param iid
     * @return
     */
    @ApiOperation(value = "获取相关推荐")
    @GetMapping("/related")
    public Map GetRelated(String uid, String ct, String iid) throws Exception {

        String openid = wxUserinfoService.findOpenidByUid(uid);

        String requestParam = "uid=" + openid + "&iid=" + iid + "&ct" + ct;
        String result = HttpUtil.sendGet(wxInterfaceInfoService.findInurlByInid(InfoCodeEnum.GET_RELATED_COMMEND.getCode()).getInUrl(), requestParam);
        ThisAssert.getIsNotNull(result, ErrorCodeEnum.GET_RESULT_FAIL);

        Map map = Const.getResultMap();
        map.put("result", result);
        return map;
    }

    /**
     * 收藏接口
     *
     * @param uid
     * @return
     */

    /*@GetMapping("/collect")
    public Map UserCollectNew(String uid) throws Exception {

        String openid = wxUserinfoService.findOpenidByUid(uid);

        String requestParam = "uid=" + openid;

        String result = HttpUtil.sendGet(wxInterfaceInfoService.findInurlByInid(InfoCodeEnum.USER_CLOOECT_INFO.getCode()).getInUrl(), requestParam);
        ThisAssert.getIsNotNull(result, ErrorCodeEnum.GET_RESULT_FAIL);
        //保存用户收藏新闻信息
      *//*  List list = Json4Map.getMainInfo(result);
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                Map map = (Map) list.get(i);
                String iid = (String) map.get("iid");
                String title = (String) map.get("title");

                WxCollection wxCollection = new WxCollection();
                wxCollection.setCoOpenid(openid);
                wxCollection.setCoIid(iid);
                wxCollection.setCoTitle(title);
                wxCollectionService.insertUserColletion(wxCollection);
            }
        }*//*

        Map map = Const.getResultMap();
        map.put("result", result);
        return map;
    }*/

    /**
     * 点赞接口
     *
     * @param newsParamInfo 封装参数实体
     * @return
     */
    @ApiOperation(value = "用户点赞")
    @GetMapping("/up")
    public Map UserUP(NewsParamInfo newsParamInfo) throws Exception {
        String uid = newsParamInfo.getUid();
        String dt = newsParamInfo.getDt();
        String plt = newsParamInfo.getPlt();
        String iid = newsParamInfo.getIid();
        String type = newsParamInfo.getType();


        String openid = wxUserinfoService.findOpenidByUid(uid);

        String requestParam = "uid=" + openid + "&guid=" + openid + "dt=" + dt + "&plt=" + plt + "&iid=" + iid + "&type=" + type;

        String result = HttpUtil.sendGet(wxInterfaceInfoService.findInurlByInid(InfoCodeEnum.USER_CLICK_UP.getCode()).getInUrl(), requestParam);
        ThisAssert.getIsNotNull(result, ErrorCodeEnum.GET_RESULT_FAIL);

        Map map = Const.getResultMap();
        map.put("result", result);
        return map;
    }

    /**
     * 踩接口
     *
     * @param newsParamInfo 封装参数实体
     * @return
     */
    @ApiOperation(value = "用户踩")
    @GetMapping("/down")
    public Map UserDown(NewsParamInfo newsParamInfo) throws Exception {
        String uid = newsParamInfo.getUid();
        String dt = newsParamInfo.getDt();
        String plt = newsParamInfo.getPlt();
        String iid = newsParamInfo.getIid();
        String type = newsParamInfo.getType();


        String openid = wxUserinfoService.findOpenidByUid(uid);

        String requestParam = "uid=" + openid + "&guid=" + openid + "dt=" + dt + "&plt=" + plt + "&iid=" + iid + "&type=" + type;

        String result = HttpUtil.sendGet(wxInterfaceInfoService.findInurlByInid(InfoCodeEnum.USER_CLICK_DOWN.getCode()).getInUrl(), requestParam);
        ThisAssert.getIsNotNull(result, ErrorCodeEnum.GET_RESULT_FAIL);

        Map map = Const.getResultMap();
        map.put("result", result);
        return map;
    }

    /**
     * 用户不喜欢  接口
     *
     * @param newsParamInfo 封装参数的实体
     * @return
     */
    @ApiOperation(value = "用户不喜欢")
    @GetMapping("/dislike")
    public Map UserDislike(NewsParamInfo newsParamInfo) throws Exception {
        String uid = newsParamInfo.getUid();
        String dt = newsParamInfo.getDt();
        String plt = newsParamInfo.getPlt();
        String iid = newsParamInfo.getIid();

        String openid = wxUserinfoService.findOpenidByUid(uid);

        String requestParam = "uid=" + openid + "&guid=" + openid + "dt=" + dt + "&plt=" + plt + "&iid=" + iid;

        String result = HttpUtil.sendGet(wxInterfaceInfoService.findInurlByInid(InfoCodeEnum.USER_DISLIKE.getCode()).getInUrl(), requestParam);
        ThisAssert.getIsNotNull(result, ErrorCodeEnum.GET_RESULT_FAIL);

        Map map = Const.getResultMap();
        map.put("result", result);
        return map;
    }

    /**
     * 关键词搜索接口
     *
     * @param uid
     * @param key
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "关键词搜索")
    @GetMapping("/search")
    public Map Search(String uid, String key) throws Exception {
        String openid = wxUserinfoService.findOpenidByUid(uid);
        String keyword = URLEncoder.encode(key, "UTF-8");
        String requestParam = "uid=" + openid + "&keyword=" + keyword;

        String result = HttpUtil.sendGet(wxInterfaceInfoService.findInurlByInid(InfoCodeEnum.KEYWORD_SEARCH.getCode()).getInUrl(), requestParam);
        ThisAssert.getIsNotNull(result, ErrorCodeEnum.GET_RESULT_FAIL);

        Map map = Const.getResultMap();
        map.put("result", result);
        return map;
    }

    /**
     * 获取栏目列表接口
     *
     * @return
     */
    @ApiOperation(value = "获取栏目列表")
    @GetMapping("/getnav")
    public Map GetNav() throws Exception {
        String result = HttpUtil.sendGet(wxInterfaceInfoService.findInurlByInid(InfoCodeEnum.GET_TITLE_LIST.getCode()).getInUrl(), "");
        ThisAssert.getIsNotNull(result, ErrorCodeEnum.GET_RESULT_FAIL);

        Map map = Const.getResultMap();
        map.put("result", result);
        return map;
    }
}
