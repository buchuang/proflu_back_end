package cn.proflu.profluweb.service.wx.impl;

import cn.proflu.profluweb.pojo.wx.WxInterfaceInfo;
import cn.proflu.profluweb.dao.wx.WxInterfaceInfoMapper;
import cn.proflu.profluweb.service.wx.WxInterfaceInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 存放所有的第三方接口信息 服务实现类
 * </p>
 *
 * @author buchuangchuang
 * @since 2018-11-10
 */
@Service
public class WxInterfaceInfoServiceImpl extends ServiceImpl<WxInterfaceInfoMapper, WxInterfaceInfo> implements WxInterfaceInfoService {

    @Override
    public WxInterfaceInfo findInurlByInid(Integer code) throws Exception {
        return getOne(new QueryWrapper<WxInterfaceInfo>().eq("IN_ID",code));
    }
}
