package cn.proflu.profluweb.dao.wx;

import cn.proflu.profluweb.pojo.wx.WxEntrepreneurUser;
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
public interface WxEntrepreneurUserMapper extends BaseMapper<WxEntrepreneurUser> {

    @Insert("insert into\n" +
            "\t\twx_entrepreneur_user(EU_OPENID,EU_ENTREPRENEUR_ID,EU_ENTREPRENEUR_NAME)\n" +
            "\t\tselect\n" +
            "\t\t#{openid},E_ID,E_ENTREPRENEUR from wx_entrepreneur where E_ID in (${id});")
    int insertUserEntrepreneur(Map map);

    @Select("select EU_ENTREPRENEUR_ID,EU_ENTREPRENEUR_NAME\n" +
            "\t\tfrom wx_entrepreneur_user\n" +
            "\t\twhere EU_OPENID=#{openid};")
    List<WxEntrepreneurUser> findEntrepreneurUsersByOpenid(String openid);
}
