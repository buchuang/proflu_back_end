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
 * @author 卜闯闯
 * @since 2018-11-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("wx_meeting_info")
public class WxMeetingInfo extends Model<WxMeetingInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 递增主键
     */
    @TableId(value = "MI_ID", type = IdType.AUTO)
    private Integer miId;

    /**
     * 预约时间
     */
    @TableField("MI_ORDERTIME")
    private String miOrdertime;

    /**
     * 会议号
     */
    @TableField("MI_WEBEX_NUMBER")
    private String miWebexNumber;

    /**
     * 会议链接
     */
    @TableField("MI_WEBEX_URL")
    private String miWebexUrl;


    @Override
    protected Serializable pkVal() {
        return this.miId;
    }

}
