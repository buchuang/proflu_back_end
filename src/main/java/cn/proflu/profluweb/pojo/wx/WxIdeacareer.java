package cn.proflu.profluweb.pojo.wx;

import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("wx_ideacareer")
public class WxIdeacareer extends Model<WxIdeacareer> {

    private static final long serialVersionUID = 1L;

    @TableId("IC_ID")
    private Integer icId;

    @TableField("IC_CAREER_NAME")
    private String icCareerName;


    @Override
    protected Serializable pkVal() {
        return this.icId;
    }

}
