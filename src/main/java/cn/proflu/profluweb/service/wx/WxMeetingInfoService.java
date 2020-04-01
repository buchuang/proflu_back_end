package cn.proflu.profluweb.service.wx;

import cn.proflu.profluweb.pojo.wx.WxMeetingInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 卜闯闯
 * @since 2018-11-18
 */
public interface WxMeetingInfoService extends IService<WxMeetingInfo> {

    List<WxMeetingInfo> findMeetingInfoList() throws Exception;
}
