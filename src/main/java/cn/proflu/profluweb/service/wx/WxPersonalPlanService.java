package cn.proflu.profluweb.service.wx;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author buchuangchuang
 * @since 2018-11-12
 */
public interface WxPersonalPlanService {

    List<Object> findAll(String openid)throws Exception ;
}
