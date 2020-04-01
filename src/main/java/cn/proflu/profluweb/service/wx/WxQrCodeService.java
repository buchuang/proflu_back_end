package cn.proflu.profluweb.service.wx;

import cn.proflu.profluweb.pojo.wx.WxQrCode;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author buchuangchuang
 * @since 2018-11-12
 */
public interface WxQrCodeService extends IService<WxQrCode> {

    WxQrCode findErWeiMa(String id)throws Exception ;
}
