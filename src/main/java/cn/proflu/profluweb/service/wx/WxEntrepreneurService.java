package cn.proflu.profluweb.service.wx;

import cn.proflu.profluweb.pojo.wx.WxEntrepreneur;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * IT 服务类
 * </p>
 *
 * @author buchuangchuang
 * @since 2018-11-13
 */
public interface WxEntrepreneurService extends IService<WxEntrepreneur> {

    List<WxEntrepreneur> findEntrepreneur(String entrepreneur)throws Exception ;
}
