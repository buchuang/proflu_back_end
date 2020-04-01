package cn.proflu.profluweb.service.wx;

import cn.proflu.profluweb.pojo.wx.WxUserExamprocess;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 卜闯闯
 * @since 2018-11-18
 */
public interface WxUserExamprocessService extends IService<WxUserExamprocess> {

    void addUserExamprocess(WxUserExamprocess wxUserExamprocess)throws  Exception;

    WxUserExamprocess findByOpenid(String openid)throws  Exception;

    void editVideoStatus(String openid)throws  Exception;

    void editButtonStatus(WxUserExamprocess wxUserExamprocess) throws Exception;
}
