package cn.proflu.profluweb.pojo.wx;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @author buchuangchuang
 * @since 2018-11-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("wx_company_user")
public class WxCompanyUser extends Model<WxCompanyUser> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "COU_ID", type = IdType.AUTO)
    private Integer couId;

    @TableField("COU_OPENID")
    private String couOpenid;

    @TableField("COU_COMPANY_ID")
    private Integer couCompanyId;

    @TableField("COU_COMPANY_NAME")
    private String couCompanyName;


    @Override
    protected Serializable pkVal() {
        return this.couId;
    }

}
