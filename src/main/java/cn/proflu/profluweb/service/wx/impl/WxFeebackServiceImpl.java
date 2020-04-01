package cn.proflu.profluweb.service.wx.impl;

import cn.proflu.profluweb.common.exception.ThisAssert;
import cn.proflu.profluweb.common.myEnum.ErrorCodeEnum;
import cn.proflu.profluweb.pojo.wx.WxFeeback;
import cn.proflu.profluweb.dao.wx.WxFeebackMapper;
import cn.proflu.profluweb.service.wx.WxFeebackService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author buchuangchuang
 * @since 2018-11-13
 */
@Service
public class WxFeebackServiceImpl extends ServiceImpl<WxFeebackMapper, WxFeeback> implements WxFeebackService {

    @Override
    public void insertFeedback(String openid, String feedback) throws Exception {
        WxFeeback wxFeeback=new WxFeeback();
        wxFeeback.setFOpenid(openid);
        wxFeeback.setFFeedback(feedback);
        boolean b=save(wxFeeback);
        if(!b){
            ThisAssert.getThisExcepton(ErrorCodeEnum.SAVE_FEEDBACK_FAIL);
        }
    }
}
