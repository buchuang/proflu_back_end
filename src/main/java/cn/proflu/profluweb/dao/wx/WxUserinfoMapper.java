package cn.proflu.profluweb.dao.wx;

import cn.proflu.profluweb.pojo.wx.WxUserinfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author buchuangchuang
 * @since 2018-11-09
 */

public interface WxUserinfoMapper extends BaseMapper<WxUserinfo> {

    @Update("update wx_userinfo set UI_UID=#{uiUid}, " +
            "UI_LAST_LOGINTIME=#{uiLastLogintime},UI_LOGIN_COUNT=#{uiLoginCount} " +
            "where UI_OPENID=#{uiOpenid}")
    int updateUidByOpenid(WxUserinfo wxUserinfo);

}
