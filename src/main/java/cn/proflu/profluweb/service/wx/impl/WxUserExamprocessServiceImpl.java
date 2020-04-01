package cn.proflu.profluweb.service.wx.impl;

import cn.proflu.profluweb.common.exception.ThisAssert;
import cn.proflu.profluweb.common.myEnum.ErrorCodeEnum;
import cn.proflu.profluweb.pojo.wx.WxUserExamprocess;
import cn.proflu.profluweb.dao.wx.WxUserExamprocessMapper;
import cn.proflu.profluweb.service.wx.WxUserExamprocessService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 卜闯闯
 * @since 2018-11-17
 */
@Service
public class WxUserExamprocessServiceImpl extends ServiceImpl<WxUserExamprocessMapper, WxUserExamprocess> implements WxUserExamprocessService {

    @Override
    public WxUserExamprocess findByOpenid(String openid) throws  Exception{
        return getOne(new QueryWrapper<WxUserExamprocess>().eq("UE_OPENID",openid));
    }

    @Override
    public void editVideoStatus(String openid)throws Exception {
        WxUserExamprocess wxUserExamprocess=findByOpenid(openid);
        if(wxUserExamprocess==null){
            ThisAssert.getThisExcepton(ErrorCodeEnum.GET_EXAMUSER_FAIL);
        }
        wxUserExamprocess.setUeVideoPercent(1);
        boolean b=saveOrUpdate(wxUserExamprocess);
        if(!b){
            ThisAssert.getThisExcepton(ErrorCodeEnum.UPDATE_EXAMUSER_FAIL);
        }
    }

    @Override
    public void editButtonStatus(WxUserExamprocess wxUserExamprocess) throws Exception {
        boolean b=updateById(wxUserExamprocess);
        if(!b){
            ThisAssert.getThisExcepton(ErrorCodeEnum.UPDATE_EXAMUSERSTATUS_FAIL);
        }
    }

    @Override
    public void addUserExamprocess(WxUserExamprocess wxUserExamprocess) throws Exception {
        boolean b=save(wxUserExamprocess);
        if(!b){
            ThisAssert.getThisExcepton(ErrorCodeEnum.SAVE_USER_EXAMINFO);
        }
    }
}
