package cn.proflu.profluweb.service.wx.impl;

import cn.proflu.profluweb.common.exception.ThisAssert;
import cn.proflu.profluweb.common.myEnum.ErrorCodeEnum;
import cn.proflu.profluweb.common.utils.Const;
import cn.proflu.profluweb.dao.wx.WxEntrepreneurUserMapper;
import cn.proflu.profluweb.pojo.wx.WxEntrepreneurUser;
import cn.proflu.profluweb.service.wx.WxEntrepreneurUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author buchuangchuang
 * @since 2018-11-13
 */
@Service
public class WxEntrepreneurUserServiceImpl extends ServiceImpl<WxEntrepreneurUserMapper, WxEntrepreneurUser> implements WxEntrepreneurUserService {
    @Resource
    private WxEntrepreneurUserMapper wxEntrepreneurUserMapper;
    @Override
    public void insertUserEntrepreneur(String openid, String id) throws Exception {
        boolean b  = remove(new QueryWrapper<WxEntrepreneurUser>().eq("EU_OPENID", openid));
        if (!b) {
            ThisAssert.getThisExcepton(ErrorCodeEnum.DELETE_USERENTREPRENEUR_FAIL);
        }
        Map map = Const.getResultMap();
        map.put("id", id);
        map.put("openid", openid);
        int w = wxEntrepreneurUserMapper.insertUserEntrepreneur(map);
        if (w <= 0) {
            ThisAssert.getThisExcepton(ErrorCodeEnum.SAVE_USERENTREPRENEUR_FAIL);
        }
    }
}
