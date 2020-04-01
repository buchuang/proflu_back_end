package cn.proflu.profluweb.dao.wx;

import cn.proflu.profluweb.pojo.wx.WxCareerUser;
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
public interface WxCareerUserMapper extends BaseMapper<WxCareerUser> {
    @Insert("insert into\n" +
            "\t\twx_career_user(COU_OPENID,CU_CAREER_ID,CU_CAREER_NAME)\n" +
            "\t\tselect\n" +
            "\t\t#{openid},IC_ID,IC_CAREER_NAME from wx_ideacareer where IC_ID in (${id});")
    int insertUserCareer(Map map);

    @Select("select CU_CAREER_ID,CU_CAREER_NAME\n" +
            "\t\tfrom wx_career_user\n" +
            "\t\twhere COU_OPENID=#{openid};")
    List<WxCareerUser> findCareerUsersByOpenid(String openid);
}
