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
@TableName("wx_focus")
public class WxFocus extends Model<WxFocus> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "FO_ID", type = IdType.AUTO)
    private Integer foId;

    @TableField("FO_UID")
    private String foUid;

    @TableField("FO_TOPIC_ID")
    private String foTopicId;


    @Override
    protected Serializable pkVal() {
        return this.foId;
    }

}
