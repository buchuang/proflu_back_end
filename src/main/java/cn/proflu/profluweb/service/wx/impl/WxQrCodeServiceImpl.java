package cn.proflu.profluweb.service.wx.impl;

import cn.proflu.profluweb.common.exception.ThisAssert;
import cn.proflu.profluweb.common.myEnum.ErrorCodeEnum;
import cn.proflu.profluweb.pojo.wx.WxQrCode;
import cn.proflu.profluweb.dao.wx.WxQrCodeMapper;
import cn.proflu.profluweb.service.wx.WxQrCodeService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author buchuangchuang
 * @since 2018-11-12
 */
@Service
public class WxQrCodeServiceImpl extends ServiceImpl<WxQrCodeMapper, WxQrCode> implements WxQrCodeService {

    @Override
    public WxQrCode findErWeiMa(String id) throws Exception {
        WxQrCode wxQrCode=getOne(new QueryWrapper<WxQrCode>().eq("QR_ID",id));
        if(wxQrCode==null){
            ThisAssert.getThisExcepton(ErrorCodeEnum.GET_ERWEIMA_FAIL);
        }
        return wxQrCode;
    }
}
