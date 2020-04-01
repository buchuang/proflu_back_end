package cn.proflu.profluweb.service.wx.impl;

import cn.proflu.profluweb.common.exception.ThisAssert;
import cn.proflu.profluweb.common.myEnum.ErrorCodeEnum;
import cn.proflu.profluweb.pojo.wx.WxCollection;
import cn.proflu.profluweb.dao.wx.WxCollectionMapper;
import cn.proflu.profluweb.service.wx.WxCollectionService;
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
public class WxCollectionServiceImpl extends ServiceImpl<WxCollectionMapper, WxCollection> implements WxCollectionService {

    @Transactional
    @Override
    public void insertUserColletion(WxCollection wxCollection) throws Exception {
        WxCollection wxCollection1 = getOne(new QueryWrapper<WxCollection>().eq("CO_OPENID", wxCollection.getCoOpenid()).eq("CO_IID", wxCollection.getCoIid()));
        if (wxCollection1 == null) {
            boolean b = save(wxCollection);
            if (!b) {
                ThisAssert.getThisExcepton(ErrorCodeEnum.INSERT_USERCOLLECTION_FAIL);
            }
        }
    }

    @Override
    public void deleteUserColletion(String openid, String iid) throws Exception {
        boolean b = remove(new QueryWrapper<WxCollection>().eq("CO_OPENID", openid).eq("CO_IID", iid));
            if (!b) {
                ThisAssert.getThisExcepton(ErrorCodeEnum.INSERT_USERCOLLECTION_FAIL);
            }
        }
}
