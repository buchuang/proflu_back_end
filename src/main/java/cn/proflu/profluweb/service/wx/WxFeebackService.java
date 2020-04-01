package cn.proflu.profluweb.service.wx;

import cn.proflu.profluweb.pojo.wx.WxFeeback;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author buchuangchuang
 * @since 2018-11-13
 */
public interface WxFeebackService extends IService<WxFeeback> {

    void insertFeedback(String openid, String feedback)throws Exception ;
}
