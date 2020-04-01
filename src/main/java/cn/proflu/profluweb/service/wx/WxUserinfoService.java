package cn.proflu.profluweb.service.wx;

import cn.proflu.profluweb.pojo.wx.WxUserinfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author buchuangchuang
 * @since 2018-11-09
 */
public interface WxUserinfoService extends IService<WxUserinfo> {

    WxUserinfo findByOpenid(String openid) throws Exception;

    void insertWxUserinfo(WxUserinfo wxUserinfo)throws Exception;

    void updateUidByOpenid(WxUserinfo wxUserinfo)throws Exception ;

    String findOpenidByUid(String uiUid)throws Exception ;

    void updateUserInfoByUid(WxUserinfo wxUserinfo)throws Exception ;

}
