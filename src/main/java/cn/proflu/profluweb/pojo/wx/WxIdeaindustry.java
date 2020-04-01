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
@TableName("wx_ideaindustry")
public class WxIdeaindustry extends Model<WxIdeaindustry> {

    private static final long serialVersionUID = 1L;

    @TableId("II_ID")
    private Integer iiId;

    @TableField("II_INDUSTRY_NAME")
    private String iiIndustryName;


    @Override
    protected Serializable pkVal() {
        return this.iiId;
    }

}
