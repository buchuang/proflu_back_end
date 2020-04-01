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
 * IT
 * </p>
 *
 * @author buchuangchuang
 * @since 2018-11-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("wx_entrepreneur")
public class WxEntrepreneur extends Model<WxEntrepreneur> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "E_ID", type = IdType.AUTO)
    private Integer eId;

    @TableField("E_ENTREPRENEUR")
    private String eEntrepreneur;

    @TableField("E_POST")
    private String ePost;


    @Override
    protected Serializable pkVal() {
        return this.eId;
    }

}
