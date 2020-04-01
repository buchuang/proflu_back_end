package cn.proflu.profluweb.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ErrorInfo<T> {

	private Integer code;
	private String message;
	private String url;
	private T data;

}
