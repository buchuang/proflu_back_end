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
 * IT
 * </p>
 *
 * @author buchuangchuang
 * @since 2018-11-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("wx_company")
public class WxCompany extends Model<WxCompany> {

    private static final long serialVersionUID = 1L;

    @TableId("COM_ID")
    private Integer comId;

    @TableField("COM_COMPANY")
    private String comCompany;


    @Override
    protected Serializable pkVal() {
        return this.comId;
    }

}
