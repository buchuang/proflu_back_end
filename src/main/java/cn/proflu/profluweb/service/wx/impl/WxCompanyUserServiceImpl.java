package cn.proflu.profluweb.service.wx.impl;

import cn.proflu.profluweb.common.exception.ThisAssert;
import cn.proflu.profluweb.common.myEnum.ErrorCodeEnum;
import cn.proflu.profluweb.common.utils.Const;
import cn.proflu.profluweb.dao.wx.WxCompanyUserMapper;
import cn.proflu.profluweb.pojo.wx.WxCompanyUser;
import cn.proflu.profluweb.service.wx.WxCompanyUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author buchuangchuang
 * @since 2018-11-13
 */
@Service
public class WxCompanyUserServiceImpl extends ServiceImpl<WxCompanyUserMapper, WxCompanyUser> implements WxCompanyUserService {

    @Resource
    private WxCompanyUserMapper wxCompanyUserMapper;

    @Transactional
    @Override
    public void insertUserCompany(String openid, String id) throws Exception {
        boolean b = remove(new QueryWrapper<WxCompanyUser>().eq("COU_OPENID", openid));
        if (!b) {
            ThisAssert.getThisExcepton(ErrorCodeEnum.DELETE_USERCOMPANY_FAIL);
        }
        Map map = Const.getResultMap();
        map.put("id", id);
        map.put("openid", openid);
        int w = wxCompanyUserMapper.insertUserCompany(map);
        if (w <= 0) {
            ThisAssert.getThisExcepton(ErrorCodeEnum.SAVE_USERCOMPANY_FAIL);
        }
    }
}
