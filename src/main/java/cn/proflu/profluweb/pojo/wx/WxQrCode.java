package cn.proflu.profluweb.pojo.wx;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDate;
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
 * @since 2018-11-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("wx_qr_code")
public class WxQrCode extends Model<WxQrCode> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "QR_ID", type = IdType.AUTO)
    private Integer qrId;

    @TableField("QR_URL")
    private String qrUrl;

    @TableField("QR_TIME")
    private LocalDate qrTime;

    @TableField("QR_DESC")
    private String qrDesc;


    @Override
    protected Serializable pkVal() {
        return this.qrId;
    }

}
