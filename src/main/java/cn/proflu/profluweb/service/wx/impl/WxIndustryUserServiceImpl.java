package cn.proflu.profluweb.service.wx.impl;

import cn.proflu.profluweb.common.exception.ThisAssert;
import cn.proflu.profluweb.common.myEnum.ErrorCodeEnum;
import cn.proflu.profluweb.common.utils.Const;
import cn.proflu.profluweb.dao.wx.WxIndustryUserMapper;
import cn.proflu.profluweb.pojo.wx.WxIndustryUser;
import cn.proflu.profluweb.service.wx.WxIndustryUserService;
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
public class WxIndustryUserServiceImpl extends ServiceImpl<WxIndustryUserMapper, WxIndustryUser> implements WxIndustryUserService {
    @Resource
    private WxIndustryUserMapper wxIndustryUserMapper;
    @Override
    public void insertUserIndustry(String openid, String id) throws Exception {
        boolean b =remove(new QueryWrapper<WxIndustryUser>().eq("IU_OPENID",openid));
        if (!b) {
            ThisAssert.getThisExcepton(ErrorCodeEnum.DELETE_USERINDUSTRY_FAIL);
        }
        Map map = Const.getResultMap();
        map.put("id", id);
        map.put("openid", openid);
        int w = wxIndustryUserMapper.insertUserIndustry(map);
        if (w <= 0) {
            ThisAssert.getThisExcepton(ErrorCodeEnum.SAVE_USERINDUSTRY_FAIL);
        }
    }
}
