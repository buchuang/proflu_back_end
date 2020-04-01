package cn.proflu.profluweb.service.wx;

import cn.proflu.profluweb.pojo.wx.WxCollection;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author buchuangchuang
 * @since 2018-11-11
 */
public interface WxCollectionService extends IService<WxCollection> {

    void insertUserColletion(WxCollection wxCollection)throws Exception ;

    void deleteUserColletion(String openid, String iid)throws Exception ;
}
