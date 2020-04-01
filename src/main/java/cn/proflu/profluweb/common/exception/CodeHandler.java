package cn.proflu.profluweb.common.exception;

import javax.servlet.http.HttpServletRequest;

import cn.proflu.profluweb.common.utils.R;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class CodeHandler {

	
	@ExceptionHandler(value=ThisExcepton.class)
	@ResponseBody
	public  ErrorInfo<String> jsonErrorHandler(HttpServletRequest req,ThisExcepton ex)throws Exception{
		  ErrorInfo<String> errorInfo = new ErrorInfo<>();
		  errorInfo.setMessage(ex.getMessage());
		  errorInfo.setCode(ex.getCode());
		  errorInfo.setData("Data");
		  errorInfo.setUrl(req.getRequestURL().toString());
		  return errorInfo;
	}
	@ExceptionHandler(value=Exception.class)
	@ResponseBody
	public R jsonErrorHandler(HttpServletRequest req, Exception ex)throws Exception{
		return R.error();
	}
	
	
	
}
