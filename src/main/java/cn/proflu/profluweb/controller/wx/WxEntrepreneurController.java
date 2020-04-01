package cn.proflu.profluweb.controller.wx;


import cn.proflu.profluweb.pojo.wx.WxEntrepreneur;
import cn.proflu.profluweb.service.wx.WxEntrepreneurService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 查询企业家接口
 * </p>
 *
 * @author 卜闯闯
 * @since 2018-11-13
 */
@RestController
@RequestMapping("/wxapp/entrepreneur")
@Api(value = "企业家", tags = "企业家的接口")
public class WxEntrepreneurController {
    /**
     * 企业家service
     */
    @Autowired
    private WxEntrepreneurService wxEntrepreneurService;

    /**
     * 模糊查询企业家
     * @param entrepreneur 用户输入的企业家名称
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "模糊查询企业家")
    @GetMapping("/queryEntrepreneur")
    public List<WxEntrepreneur> queryEntrepreneur(String entrepreneur) throws Exception {
        if (entrepreneur == null) {
            entrepreneur = "";
        }
        List<WxEntrepreneur> list = wxEntrepreneurService.findEntrepreneur(entrepreneur);

        return list;
    }
}
