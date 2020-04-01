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
 * @since 2018-11-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("wx_likearticle")
public class WxLikearticle extends Model<WxLikearticle> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "L_ID", type = IdType.AUTO)
    private Integer lId;

    @TableField("L_OPENID")
    private String lOpenid;

    @TableField("L_IID")
    private String lIid;


    @Override
    protected Serializable pkVal() {
        return this.lId;
    }

}
