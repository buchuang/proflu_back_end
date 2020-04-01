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
@TableName("wx_industry_user")
public class WxIndustryUser extends Model<WxIndustryUser> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "IU_ID", type = IdType.AUTO)
    private Integer iuId;

    @TableField("IU_OPENID")
    private String iuOpenid;

    @TableField("IU_INDUSTRY_ID")
    private Integer iuIndustryId;

    @TableField("IU_INDUSTRY_NAME")
    private String iuIndustryName;


    @Override
    protected Serializable pkVal() {
        return this.iuId;
    }

}
