package cn.lonedy.ssm.exception;
/**
 * <p>Title: BusinessException</p>
 * <p>Description: TODO(这里用一句话描述这个类的作用) <p>
 * <p>Company: www.itcast.com</p>
 * @author 传智.关云长 
 * @date 2015-10-13 下午2:51:08  
 * @version 1.0
 */
public class BusinessException extends Exception {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public BusinessException(String message) {
		super();
		this.message = message;
	}
	
	
}
