package cn.proflu.profluweb.service.wx.impl;

import cn.proflu.profluweb.common.exception.ThisAssert;
import cn.proflu.profluweb.common.myEnum.ErrorCodeEnum;
import cn.proflu.profluweb.pojo.wx.WxCompany;
import cn.proflu.profluweb.dao.wx.WxCompanyMapper;
import cn.proflu.profluweb.service.wx.WxCompanyService;
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
 * @since 2018-11-12
 */
@Service
public class WxCompanyServiceImpl extends ServiceImpl<WxCompanyMapper, WxCompany> implements WxCompanyService {

    @Override
    public List<WxCompany> findAllCompany(String company) throws Exception {
        List<WxCompany> list=list(new QueryWrapper<WxCompany>().like("COM_COMPANY",company));
        return list;
    }
}
