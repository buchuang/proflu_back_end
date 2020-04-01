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
 * @since 2018-11-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("wx_entrance_exam")
public class WxEntranceExam extends Model<WxEntranceExam> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "EE_ID", type = IdType.AUTO)
    private Integer eeId;

    @TableField("EE_OPENID")
    private String eeOpenid;

    @TableField("EE_SUBMISSIONTIME")
    private String eeSubmissiontime;

    @TableField("EE_NAME")
    private String eeName;

    @TableField("EE_UNIVERSITY")
    private String eeUniversity;

    @TableField("EE_EMAIL")
    private String eeEmail;

    @TableField("EE_GRADE")
    private String eeGrade;

    @TableField("EE_IDEAL_INDEUSTRY")
    private String eeIdealIndeustry;

    @TableField("EE_IDEAL_POSITION")
    private String eeIdealPosition;

    @TableField("EE_THEORY")
    private String eeTheory;

    @TableField("EE_IDEAL_COMPANY_TYPE")
    private String eeIdealCompanyType;

    @TableField("EE_IDEAL_COMPANY")
    private String eeIdealCompany;

    @TableField("EE_REASON_OR_THOUGHT")
    private String eeReasonOrThought;

    @TableField("EE_PREPARATION")
    private String eePreparation;

    @TableField("EE_OPPORTUNITY")
    private String eeOpportunity;

    @TableField("EE_EXPERIENCE")
    private String eeExperience;

    @TableField("EE_LIFE_PLAN")
    private String eeLifePlan;


    @Override
    protected Serializable pkVal() {
        return this.eeId;
    }

}
