package cn.proflu.profluweb.controller.wx;


import cn.proflu.profluweb.VO.wx.CheckedIndustry;
import cn.proflu.profluweb.VO.wx.NewsParamInfo;
import cn.proflu.profluweb.common.exception.ThisAssert;
import cn.proflu.profluweb.common.myEnum.ErrorCodeEnum;
import cn.proflu.profluweb.common.utils.Const;
import cn.proflu.profluweb.service.wx.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 卜闯闯
 * @since 2018-11-12
 */
@RestController
@RequestMapping("/vipSystem/wxapp/personal")
@Api(value = "个人培养", tags = "个人培养的接口")
public class WxPersonalPlanController {
    /**
     * 用户信息service
     */
    @Autowired
    private WxUserinfoService wxUserinfoService;
    /**
     * 用户个人培养计划service
     */
    @Autowired
    private WxPersonalPlanService wxPersonalPlanService;
    /**
     * 用户公司service
     */
    @Autowired
    private WxCompanyUserService wxCompanyUserService;
    /**
     * 用户行业service
     */
    @Autowired
    private WxIndustryUserService wxIndustryUserService;
    /**
     * 用户职业service
     */
    @Autowired
    private WxCareerUserService wxCareerUserService;

    /**
     * 保存用户选择公司
     * @param uid 用户登录session
     * @param id 公司id (格式1,2,3,4) 用户可以一次选多个公司
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "保存用户选择公司")
    @GetMapping("/updateCompany")
    public Map updateCompany(String uid, String id) throws Exception {
        ThisAssert.getIsNotNull(id, ErrorCodeEnum.USER_NOT_SELECT);
        String openid = wxUserinfoService.findOpenidByUid(uid);

        wxCompanyUserService.insertUserCompany(openid, id);

        return Const.SUCCESS_RESPONSE;
    }
    /**
     * 保存用户选择职业
     * @param uid 用户登录session
     * @param id 职业id (格式1,2,3,4) 用户可以一次选多个职业
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "保存用户选择职业")
    @GetMapping("/updateIndustry")
    public Map updateIndustry(String uid, String id) throws Exception {
        ThisAssert.getIsNotNull(id, ErrorCodeEnum.USER_NOT_SELECT);
        String openid = wxUserinfoService.findOpenidByUid(uid);
        System.out.println(id);
        wxIndustryUserService.insertUserIndustry(openid, id);

        return Const.SUCCESS_RESPONSE;
    }
    /**
     * 保存用户选择企业人
     * @param uid 用户登录session
     * @param id 企业人id (格式1,2,3,4) 用户可以一次选多个企业人
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "保存用户选择企业人")
    @GetMapping("/updateEntrepreneur")
    public Map updateEntrepreneur(String uid, String id) throws Exception {
        ThisAssert.getIsNotNull(id, ErrorCodeEnum.USER_NOT_SELECT);
        String openid = wxUserinfoService.findOpenidByUid(uid);
        wxIndustryUserService.insertUserIndustry(openid, id);

        return Const.SUCCESS_RESPONSE;
    }
    /**
     * 保存用户选择事业
     * @param uid 用户登录session
     * @param id 事业id (格式1,2,3,4) 用户可以一次选多个事业
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "保存用户选择事业")
    @GetMapping("/updateCareer")
    public Map updateCareer(String uid, String id) throws Exception {
        ThisAssert.getIsNotNull(id, ErrorCodeEnum.USER_NOT_SELECT);
        String openid = wxUserinfoService.findOpenidByUid(uid);

        wxCareerUserService.insertUserCareer(openid, id);

        return Const.SUCCESS_RESPONSE;
    }

    /**
     * 查询用户个人所有信息
     * @param uid 用户登录session
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "查询用户个人所有信息")
    @GetMapping("/queryPlanInfo")
    public List<Object> queryPlanInfo(String uid) throws Exception {
        String openid = wxUserinfoService.findOpenidByUid(uid);
        List<Object> maps=wxPersonalPlanService.findAll(openid);
        return maps;
    }
}
