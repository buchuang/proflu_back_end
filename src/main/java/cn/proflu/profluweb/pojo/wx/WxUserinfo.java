package cn.proflu.profluweb.pojo.wx;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 卜闯闯
 * @since 2019-03-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("wx_userinfo")
public class WxUserinfo extends Model<WxUserinfo> {

    private static final long serialVersionUID = 1L;

    @TableId("UI_UID")
    private String uiUid;

    @TableField("UI_SESSION_KEY")
    private String uiSessionKey;

    @TableField("UI_OPENID")
    private String uiOpenid;

    @TableField("UI_TYPE")
    private String uiType;

    @TableField("UI_MOBILE")
    private String uiMobile;

    @TableField("UI_USER_NAME")
    private String uiUserName;

    @TableField("UI_REALL_NAME")
    private String uiReallName;

    @TableField("UI_ICON")
    private String uiIcon;

    @TableField("UI_GENDER")
    private String uiGender;

    @TableField("UI_BIRTH")
    private LocalDateTime uiBirth;

    @TableField("UI_CITY")
    private String uiCity;

    @TableField("UI_PROVINCE")
    private String uiProvince;

    @TableField("UI_POST_ID")
    private String uiPostId;

    @TableField("UI_LAST_LOGINTIME")
    private LocalDateTime uiLastLogintime;

    @TableField("UI_LOGIN_COUNT")
    private Integer uiLoginCount;


    @Override
    protected Serializable pkVal() {
        return this.uiUid;
    }

}
