package cn.proflu.profluweb.service.wx;

import cn.proflu.profluweb.pojo.wx.WxCareerUser;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author buchuangchuang
 * @since 2018-11-13
 */
public interface WxCareerUserService extends IService<WxCareerUser> {

    void insertUserCareer(String openid, String id)throws Exception ;

}
