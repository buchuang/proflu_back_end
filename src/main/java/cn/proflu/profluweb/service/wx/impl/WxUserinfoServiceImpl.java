package cn.proflu.profluweb.service.wx.impl;

import cn.proflu.profluweb.common.exception.ThisAssert;
import cn.proflu.profluweb.common.myEnum.ErrorCodeEnum;
import cn.proflu.profluweb.pojo.wx.WxUserinfo;
import cn.proflu.profluweb.dao.wx.WxUserinfoMapper;
import cn.proflu.profluweb.service.wx.WxUserinfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author buchuangchuang
 * @since 2018-11-09
 */
@Service
public class WxUserinfoServiceImpl extends ServiceImpl<WxUserinfoMapper, WxUserinfo> implements WxUserinfoService {

    @Resource
    private WxUserinfoMapper wxUserinfoMapper;

    /**
     * 这是通过openid查询用户实体
     *
     * @param openid
     * @return
     * @throws Exception
     */
    @Override
    public WxUserinfo findByOpenid(String openid) throws Exception {
        return getOne(new QueryWrapper<WxUserinfo>().eq("UI_OPENID", openid));
    }

    /**
     * 插入一条用户信息
     *
     * @param wxUserinfo
     * @throws Exception
     */
    @Transactional
    @Override
    public void insertWxUserinfo(WxUserinfo wxUserinfo) throws Exception {
        boolean b = save(wxUserinfo);
        if (!b) {
            ThisAssert.getThisExcepton(ErrorCodeEnum.SAVE_USER_FAIL);
        }
    }

    /**
     * 通过openid更新用户uid
     *
     * @param wxUserinfo
     */
    @Transactional
    @Override
    public void updateUidByOpenid(WxUserinfo wxUserinfo) throws Exception {
        int b = wxUserinfoMapper.updateUidByOpenid(wxUserinfo);
        if (b <= 0) {
            ThisAssert.getThisExcepton(ErrorCodeEnum.UPDATE_USER_STATUS);
        }
    }

    /**
     * 通过uid 查询openid
     *
     * @param uiUid
     * @return
     */
    @Override
    public String findOpenidByUid(String uiUid) throws Exception {
        WxUserinfo wxUserinfo = getOne(new QueryWrapper<WxUserinfo>().eq("UI_UID", uiUid));
        if (wxUserinfo == null) {
            ThisAssert.getThisExcepton(ErrorCodeEnum.GET_USER_FAIL);
        }
        return wxUserinfo.getUiOpenid();
    }

    /**
     * 通过openid更新用户信息
     *
     * @param wxUserinfo
     * @return
     */
    @Transactional
    @Override
    public void updateUserInfoByUid(WxUserinfo wxUserinfo) throws Exception {
        boolean b = updateById(wxUserinfo);
        if (!b) {
            ThisAssert.getThisExcepton(ErrorCodeEnum.UPDATE_USER_FAIL);
        }
    }

}
