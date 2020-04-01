package cn.proflu.profluweb.service.wx;

import cn.proflu.profluweb.pojo.wx.WxLikearticle;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author buchuangchuang
 * @since 2018-11-11
 */
public interface WxLikearticleService extends IService<WxLikearticle> {

    void insertUserUp(WxLikearticle wxLikearticle)throws Exception ;

    void deleteUserUp(WxLikearticle wxLikearticle)throws Exception ;
}
