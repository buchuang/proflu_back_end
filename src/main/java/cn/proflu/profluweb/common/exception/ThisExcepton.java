package cn.proflu.profluweb.common.exception;

import cn.proflu.profluweb.common.myEnum.ErrorCodeEnum;
import lombok.Data;
import lombok.Setter;

/**
 * 
 *<p>Title: ThisExcepton.java<／p> 
 *<p>Description:  自定义异常 <／p> 
 * @ClassName:  ThisExcepton   
 * @author Dylan_攻城狮
 * @date 2018年11月3日
 * @version 1.0
 */
@Data
public class ThisExcepton extends RuntimeException {

	private Integer code;

	public ThisExcepton() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ThisExcepton(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	public ThisExcepton(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ThisExcepton(ErrorCodeEnum errorCode) {
		super(errorCode.getMessage());
		this.code=errorCode.getCode();
		// TODO Auto-generated constructor stub
	}

}
