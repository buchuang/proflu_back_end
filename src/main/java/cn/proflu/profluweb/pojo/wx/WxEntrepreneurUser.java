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
@TableName("wx_entrepreneur_user")
public class WxEntrepreneurUser extends Model<WxEntrepreneurUser> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "EU_ID", type = IdType.AUTO)
    private Integer euId;

    @TableField("EU_OPENID")
    private String euOpenid;

    @TableField("EU_ENTREPRENEUR_ID")
    private Integer euEntrepreneurId;

    @TableField("EU_ENTREPRENEUR_NAME")
    private String euEntrepreneurName;


    @Override
    protected Serializable pkVal() {
        return this.euId;
    }

}
