package cn.proflu.profluweb.service.wx;

import cn.proflu.profluweb.pojo.wx.WxInterfaceInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 存放所有的第三方接口信息 服务类
 * </p>
 *
 * @author buchuangchuang
 * @since 2018-11-10
 */
public interface WxInterfaceInfoService extends IService<WxInterfaceInfo> {

    WxInterfaceInfo findInurlByInid(Integer code)throws Exception ;
}
