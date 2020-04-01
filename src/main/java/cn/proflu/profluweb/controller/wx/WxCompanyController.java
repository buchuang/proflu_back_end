package cn.proflu.profluweb.controller.wx;

import cn.proflu.profluweb.pojo.wx.WxCompany;
import cn.proflu.profluweb.service.wx.WxCompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * IT 服务实现类
 * </p>
 *
 * @author 卜闯闯
 * @since 2018-11-12
 */
@RestController
@RequestMapping("/wxapp/company")
@Api(value = "公司", tags = "公司的接口")
public class  WxCompanyController {

    /**
     * 公司service
     */
    @Autowired
    private WxCompanyService wxCompanyService;

    /**
     * 模糊查询公司
     * @param company 用户输入的公司名称
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "模糊查询公司")
    @GetMapping("/queryCompany")
    public List<WxCompany> queryCompany(String company) throws Exception {
        if (company == null) {
            company = "";
        }
        List<WxCompany> list = wxCompanyService.findAllCompany(company);

        return list;
    }

}
