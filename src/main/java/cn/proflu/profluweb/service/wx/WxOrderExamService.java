package cn.proflu.profluweb.service.wx;

import cn.proflu.profluweb.pojo.wx.WxOrderExam;
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
public interface WxOrderExamService extends IService<WxOrderExam> {

    void addOrderExam(WxOrderExam wxOrderExam) throws Exception;

    WxOrderExam findByOpenid(String openid) throws Exception;

    List<WxOrderExam> findByOrderTime(String orderTime) throws Exception;
}
