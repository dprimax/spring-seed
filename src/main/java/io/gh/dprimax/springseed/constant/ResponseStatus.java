package io.gh.dprimax.springseed.constant;

public enum ResponseStatus {

	// SUCCESS
	GENERAL_SUCCESS(1000, "General Success"),

	// FAIL
	GENERAL_FAIL(2000, "General Failure"), 
	
	// INFO
	GENERAL_INFO(3000, "General Information"),
	
	// WARN
	GENERAL_WARN(4000, "General Warning"),

	// ERROR
	GENERAL_ERROR(5000, "General Error")
	;
	

	ResponseStatus(int code, String message) {
		this.code = code;
		this.message = message;
	}

	private final int code;
	private final String message;

	public int getCode() {
		return code;
	}

	public String getCodeString() {
		return String.valueOf(this.code);
	}

	public String getMessage() {
		return message;
	}

	public Type type() {
		return Type.valueOf(this);
	}

	public enum Type {

		SUCCESS(1), FAIL(2), INFO(3), WARN(4), ERROR(5);

		Type(int code) {
			this.code = code;
		}

		private final int code;

		public int getCode() {
			return code;
		}

		public static Type valueOf(int code) {
			int typeCode = code / 1000;
			for (Type type : values()) {
				if (type.code == typeCode) {
					return type;
				}
			}
			throw new IllegalArgumentException("No matching ResponseStatus.Type for [" + code + "]");
		}

		public static Type valueOf(ResponseStatus status) {
			return valueOf(status.code);
		}

	}

}
