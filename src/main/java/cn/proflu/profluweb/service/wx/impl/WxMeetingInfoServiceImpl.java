package cn.proflu.profluweb.service.wx.impl;

import cn.proflu.profluweb.pojo.wx.WxMeetingInfo;
import cn.proflu.profluweb.dao.wx.WxMeetingInfoMapper;
import cn.proflu.profluweb.service.wx.WxMeetingInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 卜闯闯
 * @since 2018-11-18
 */
@Service
public class WxMeetingInfoServiceImpl extends ServiceImpl<WxMeetingInfoMapper, WxMeetingInfo> implements WxMeetingInfoService {

    @Override
    public List<WxMeetingInfo> findMeetingInfoList() throws Exception {
        return list(null);
    }
}
