package cn.proflu.profluweb.service.wx;

import cn.proflu.profluweb.pojo.wx.WxCompanyUser;
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
public interface WxCompanyUserService extends IService<WxCompanyUser> {

    void insertUserCompany(String openid, String id)throws Exception ;
}
