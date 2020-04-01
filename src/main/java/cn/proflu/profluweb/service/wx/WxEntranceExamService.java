package cn.proflu.profluweb.service.wx;

import cn.proflu.profluweb.pojo.wx.WxEntranceExam;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 卜闯闯
 * @since 2018-11-17
 */
public interface WxEntranceExamService extends IService<WxEntranceExam> {

    WxEntranceExam findByOpenid(String openid) throws Exception;

    void addExamOneAnswer(WxEntranceExam wxEntranceExam) throws Exception;
}
