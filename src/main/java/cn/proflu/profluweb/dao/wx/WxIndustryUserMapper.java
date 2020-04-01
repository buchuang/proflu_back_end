package cn.proflu.profluweb.dao.wx;

import cn.proflu.profluweb.pojo.wx.WxIndustryUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author buchuangchuang
 * @since 2018-11-13
 */
public interface WxIndustryUserMapper extends BaseMapper<WxIndustryUser> {

    @Insert("insert into\n" +
            "\t\twx_industry_user(IU_OPENID,IU_INDUSTRY_ID,IU_INDUSTRY_NAME)\n" +
            "\t\tselect\n" +
            "\t\t#{openid},II_ID,II_INDUSTRY_NAME from wx_ideaindustry where II_ID in (${id});")
    int insertUserIndustry(Map map);

    @Select("select IU_INDUSTRY_ID,IU_INDUSTRY_NAME\n" +
            "\t\tfrom wx_industry_user\n" +
            "\t\twhere IU_OPENID=#{openid};")
    List<WxIndustryUser> findIndustryUsersByOpenid(String openid);
}
