package cn.proflu.profluweb.service.wx.impl;

import cn.proflu.profluweb.common.exception.ThisAssert;
import cn.proflu.profluweb.common.myEnum.ErrorCodeEnum;
import cn.proflu.profluweb.pojo.wx.WxOrderExam;
import cn.proflu.profluweb.dao.wx.WxOrderExamMapper;
import cn.proflu.profluweb.service.wx.WxOrderExamService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
public class WxOrderExamServiceImpl extends ServiceImpl<WxOrderExamMapper, WxOrderExam> implements WxOrderExamService {

    @Override
    public void addOrderExam(WxOrderExam wxOrderExam) throws Exception {
        WxOrderExam wxOrderExam1=getOne(new QueryWrapper<WxOrderExam>().eq("OE_OPENID",wxOrderExam));
        if(wxOrderExam1!=null){
            boolean flag=removeById(wxOrderExam1.getOeId());
            if(!flag){
                ThisAssert.getThisExcepton(ErrorCodeEnum.REMOVE_ORDEREXAM_FAIL);
            }
        }
        boolean b=saveOrUpdate(wxOrderExam);
        if(!b){
            ThisAssert.getThisExcepton(ErrorCodeEnum.SAVE_ORDEREXAM_FAIL);
        }
    }

    @Override
    public WxOrderExam findByOpenid(String openid) throws Exception {
        return getOne(new QueryWrapper<WxOrderExam>().eq("OE_OPENID",openid));
    }

    @Override
    public List<WxOrderExam> findByOrderTime(String orderTime) throws Exception {
        List<WxOrderExam> orderExams=list(new QueryWrapper<WxOrderExam>().eq("OE_ORDERTIME",orderTime));
        if(orderExams==null){
            return new ArrayList<WxOrderExam>();
        }
        return orderExams;
    }
}
