package cn.proflu.profluweb.service.wx.impl;

import cn.proflu.profluweb.common.exception.ThisAssert;
import cn.proflu.profluweb.common.myEnum.ErrorCodeEnum;
import cn.proflu.profluweb.pojo.wx.WxEntranceExam;
import cn.proflu.profluweb.dao.wx.WxEntranceExamMapper;
import cn.proflu.profluweb.service.wx.WxEntranceExamService;
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
public class WxEntranceExamServiceImpl extends ServiceImpl<WxEntranceExamMapper, WxEntranceExam> implements WxEntranceExamService {

    @Override
    public WxEntranceExam findByOpenid(String openid) throws Exception{
        return getOne(new QueryWrapper<WxEntranceExam>().eq("EE_OPENID",openid));
    }

    @Override
    public void addExamOneAnswer(WxEntranceExam wxEntranceExam) throws Exception {
        boolean b=save(wxEntranceExam);
        if(!b){
            ThisAssert.getThisExcepton(ErrorCodeEnum.SAVE_USER_EXAMINFO);
        }
    }
}
