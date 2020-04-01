package cn.proflu.profluweb.service.wx.impl;

import cn.proflu.profluweb.common.exception.ThisAssert;
import cn.proflu.profluweb.common.myEnum.ErrorCodeEnum;
import cn.proflu.profluweb.pojo.wx.WxFocus;
import cn.proflu.profluweb.dao.wx.WxFocusMapper;
import cn.proflu.profluweb.service.wx.WxFocusService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author buchuangchuang
 * @since 2018-11-13
 */
@Service
public class WxFocusServiceImpl extends ServiceImpl<WxFocusMapper, WxFocus> implements WxFocusService {

    @Transactional
    @Override
    public void insertFocus(String openid, String topic_id) throws Exception {
        WxFocus wxFocus=getOne(new QueryWrapper<WxFocus>().eq("FO_UID",openid).eq("FO_TOPIC_ID",topic_id));
        if(wxFocus==null){
            WxFocus wxFocus1=new WxFocus();
            wxFocus1.setFoUid(openid);
            wxFocus1.setFoTopicId(topic_id);
            boolean b=save(wxFocus1);
            if(!b){
                ThisAssert.getThisExcepton(ErrorCodeEnum.SAVE_FOCUS_FAIL);
            }
        }
    }
    @Transactional
    @Override
    public void deleteFocus(String topic_id, String openid) throws Exception {
        boolean b=remove(new QueryWrapper<WxFocus>().eq("FO_UID",openid).eq("FO_TOPIC_ID",topic_id));
            if(!b){
                ThisAssert.getThisExcepton(ErrorCodeEnum.SAVE_FOCUS_FAIL);
            }
        }
}
