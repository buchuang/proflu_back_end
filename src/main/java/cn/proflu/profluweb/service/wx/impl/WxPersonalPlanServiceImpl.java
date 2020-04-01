package cn.proflu.profluweb.service.wx.impl;

import cn.proflu.profluweb.dao.wx.WxCareerUserMapper;
import cn.proflu.profluweb.dao.wx.WxCompanyUserMapper;
import cn.proflu.profluweb.dao.wx.WxEntrepreneurUserMapper;
import cn.proflu.profluweb.dao.wx.WxIndustryUserMapper;
import cn.proflu.profluweb.pojo.wx.*;
import cn.proflu.profluweb.service.wx.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author buchuangchuang
 * @since 2018-11-12
 */
@Service
public class WxPersonalPlanServiceImpl implements WxPersonalPlanService {

    @Resource
    private WxCompanyUserMapper wxCompanyUserMapper;
    @Resource
    private WxIndustryUserMapper wxIndustryUserMapper;
    @Resource
    private WxEntrepreneurUserMapper wxEntrepreneurUserMapper;
    @Resource
    private WxCareerUserMapper wxCareerUserMapper;

    @Override
    public List<Object> findAll(String openid) throws Exception {
        List<WxCareerUser> list1 = wxCareerUserMapper.findCareerUsersByOpenid(openid);
        List<WxCompanyUser> list2 = wxCompanyUserMapper.findCompanyUsersByOpenid(openid);
        List<WxEntrepreneurUser> list3 = wxEntrepreneurUserMapper.findEntrepreneurUsersByOpenid(openid);
        List<WxIndustryUser> list4 = wxIndustryUserMapper.findIndustryUsersByOpenid(openid);
        List<Object> list5 = new ArrayList<Object>();
        list5.addAll(list1);
        list5.addAll(list2);
        list5.addAll(list3);
        list5.addAll(list4);
        return list5;
    }
}
