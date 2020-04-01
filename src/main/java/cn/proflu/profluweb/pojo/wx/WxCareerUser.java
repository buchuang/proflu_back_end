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
@TableName("wx_career_user")
public class WxCareerUser extends Model<WxCareerUser> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "CU_ID", type = IdType.AUTO)
    private Integer cuId;

    @TableField("COU_OPENID")
    private String couOpenid;

    @TableField("CU_CAREER_ID")
    private Integer cuCareerId;

    @TableField("CU_CAREER_NAME")
    private String cuCareerName;


    @Override
    protected Serializable pkVal() {
        return this.cuId;
    }

}
