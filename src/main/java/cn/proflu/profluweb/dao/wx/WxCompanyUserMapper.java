package cn.proflu.profluweb.dao.wx;

import cn.proflu.profluweb.pojo.wx.WxCompanyUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  用户添加关注公司Mapper 接口
 * </p>
 *
 * @author buchuangchuang
 * @since 2018-11-13
 */
public interface WxCompanyUserMapper extends BaseMapper<WxCompanyUser> {

    @Insert("insert into\n" +
            "\t\twx_company_user(COU_OPENID,COU_COMPANY_ID,COU_COMPANY_NAME)\n" +
            "\t\tselect\n" +
            "\t\t#{openid},COM_ID,COM_COMPANY from wx_company where COM_ID in (${id});")
    int insertUserCompany(Map map);

    @Select("select COU_COMPANY_ID,COU_COMPANY_NAME\n" +
            "\t\tfrom wx_company_user\n" +
            "\t\twhere COU_OPENID=#{openid};")
    List<WxCompanyUser> findCompanyUsersByOpenid(String openid);
}
