package cn.proflu.profluweb.service.wx;

import cn.proflu.profluweb.pojo.wx.WxFocus;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author buchuangchuang
 * @since 2018-11-13
 */
public interface WxFocusService extends IService<WxFocus> {

    void insertFocus(String openid, String topic_id)throws Exception ;

    void deleteFocus(String s, String openid)throws Exception ;
}
