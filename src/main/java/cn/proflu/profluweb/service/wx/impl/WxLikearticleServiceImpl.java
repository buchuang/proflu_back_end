package cn.proflu.profluweb.service.wx.impl;

import cn.proflu.profluweb.common.exception.ThisAssert;
import cn.proflu.profluweb.common.myEnum.ErrorCodeEnum;
import cn.proflu.profluweb.pojo.wx.WxLikearticle;
import cn.proflu.profluweb.dao.wx.WxLikearticleMapper;
import cn.proflu.profluweb.service.wx.WxLikearticleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author buchuangchuang
 * @since 2018-11-11
 */
@Service
public class WxLikearticleServiceImpl extends ServiceImpl<WxLikearticleMapper, WxLikearticle> implements WxLikearticleService {

    @Transactional
    @Override
    public void insertUserUp(WxLikearticle wxLikearticle) throws Exception {
        WxLikearticle wxLikearticle1 = getOne(new QueryWrapper<WxLikearticle>().eq("L_OPENID", wxLikearticle.getLOpenid()).eq("L_IID", wxLikearticle.getLIid()));
        if (wxLikearticle1 == null) {
            boolean b = save(wxLikearticle);
            if (!b) {
                ThisAssert.getThisExcepton(ErrorCodeEnum.INSERT_USERUP_FAIL);
            }
        }
    }
    @Transactional
    @Override
    public void deleteUserUp(WxLikearticle wxLikearticle) throws Exception {
        boolean b = remove(new QueryWrapper<WxLikearticle>().eq("L_OPENID", wxLikearticle.getLOpenid()).eq("L_IID", wxLikearticle.getLIid()));

        if (!b) {
            ThisAssert.getThisExcepton(ErrorCodeEnum.DELETE_USERUP_FAIL);
        }
    }
}
