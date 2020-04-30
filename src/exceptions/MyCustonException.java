package exceptions;

public class MyCustonException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String msg;
	
	public MyCustonException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
	
	@Override
	public String getMessage() {
		return this.msg;
	}
	
}

