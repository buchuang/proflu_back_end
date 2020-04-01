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
@TableName("wx_user_examprocess")
public class WxUserExamprocess extends Model<WxUserExamprocess> {

    private static final long serialVersionUID = 1L;

    /**
     * 自增主键
     */
    @TableId(value = "UE_ID", type = IdType.AUTO)
    private Integer ueId;

    /**
     * 用户唯一标识(外键)
     */
    @TableField("UE_OPENID")
    private String ueOpenid;

    /**
     * 用户昵称
     */
    @TableField("UE_USERNAME")
    private String ueUsername;

    /**
     * 0:未观看 1:已观看
     */
    @TableField("UE_VIDEO_PERCENT")
    private Integer ueVideoPercent;

    /**
     * 1:普通用户 2:进入面试 3:实习期
     */
    @TableField("UE_EXAM_GRADE")
    private Integer ueExamGrade;

    /**
     * 1:预约考试 2:参加考试 3:申请补考
     */
    @TableField("UE_USER_STATUS")
    private Integer ueUserStatus;

    /**
     * 用户计划
     */
    @TableField("UE_USER_PLAN")
    private String ueUserPlan;

    /**
     * 用户创建考试时间
     */
    @TableField("UE_CREATETIME")
    private String ueCreatetime;

    /**
     * 用户流程实例
     */
    @TableField("UE_PIID")
    private String uePiid;

    /**
     * 0:考试流程未完结 1:考试流程完结
     */
    @TableField("UE_EXAM_FINISH")
    private Integer ueExamFinish;


    @Override
    protected Serializable pkVal() {
        return this.ueId;
    }

}
