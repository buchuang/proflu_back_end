package cn.proflu.profluweb.pojo.wx;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
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
 * 微信_预约考试
 * </p>
 *
 * @author 卜闯闯
 * @since 2019-03-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("wx_order_exam")
public class WxOrderExam extends Model<WxOrderExam> {

    private static final long serialVersionUID = 1L;

    /**
     * 递增主键
     */
    @TableId(value = "OE_ID", type = IdType.AUTO)
    private Integer oeId;

    /**
     * 用户唯一标识
     */
    @TableField("OE_OPENID")
    private String oeOpenid;

    /**
     * 用户预约时间
     */
    @TableField("OE_ORDERTIME")
    private LocalDateTime oeOrdertime;

    /**
     * 用户选择的考场
     */
    @TableField("OE_WEBEX_NUM")
    private String oeWebexNum;

    /**
     * 用户选择的考试时间
     */
    @TableField("OE_EXAMTIME")
    private LocalDateTime oeExamtime;


    @Override
    protected Serializable pkVal() {
        return this.oeId;
    }

}
