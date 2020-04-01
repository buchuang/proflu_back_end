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
 * 存放所有的第三方接口信息
 * </p>
 *
 * @author buchuangchuang
 * @since 2018-11-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("wx_interface_info")
public class WxInterfaceInfo extends Model<WxInterfaceInfo> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "IN_ID", type = IdType.AUTO)
    private Integer inId;

    @TableField("IN_CODE")
    private String inCode;

    @TableField("IN_URL")
    private String inUrl;

    @TableField("IN_ROLE")
    private String inRole;

    @TableField("IN_PARMS")
    private String inParms;

    @TableField("IN_ISUSE")
    private Integer inIsuse;

    @TableField("IN_DESC")
    private String inDesc;


    @Override
    protected Serializable pkVal() {
        return this.inId;
    }

}
