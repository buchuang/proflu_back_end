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
@TableName("wx_collection")
public class WxCollection extends Model<WxCollection> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "CO_ID", type = IdType.AUTO)
    private Integer coId;

    @TableField("CO_OPENID")
    private String coOpenid;

    @TableField("CO_IID")
    private String coIid;

    @TableField("CO_TITLE")
    private String coTitle;


    @Override
    protected Serializable pkVal() {
        return this.coId;
    }

}
