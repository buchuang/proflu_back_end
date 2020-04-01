package cn.proflu.profluweb.service.wx;

import cn.proflu.profluweb.pojo.wx.WxCompany;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * IT 服务类
 * </p>
 *
 * @author buchuangchuang
 * @since 2018-11-12
 */
public interface WxCompanyService extends IService<WxCompany> {

    List<WxCompany> findAllCompany(String company)throws Exception ;
}
