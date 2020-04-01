package cn.proflu.profluweb.service.wx.impl;

import cn.proflu.profluweb.pojo.wx.WxCompany;
import cn.proflu.profluweb.pojo.wx.WxEntrepreneur;
import cn.proflu.profluweb.dao.wx.WxEntrepreneurMapper;
import cn.proflu.profluweb.service.wx.WxEntrepreneurService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * IT 服务实现类
 * </p>
 *
 * @author buchuangchuang
 * @since 2018-11-13
 */
@Service
public class WxEntrepreneurServiceImpl extends ServiceImpl<WxEntrepreneurMapper, WxEntrepreneur> implements WxEntrepreneurService {

    @Override
    public List<WxEntrepreneur> findEntrepreneur(String entrepreneur) throws Exception {
        List<WxEntrepreneur> list=list(new QueryWrapper<WxEntrepreneur>().like("E_ENTREPRENEUR",entrepreneur));
        return list;
    }
}
