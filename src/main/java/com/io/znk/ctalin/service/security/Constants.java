package com.io.znk.ctalin.service.security;

public class Constants {
	
	public static final String DATE_FORMAT = "dd-MM-yyyy";
	
	public static enum Roles {
		CLIENT("timesheet_client"), DEVELOPER("timesheet_developer"), MANAGER("timesheet_manager");
		private String value;
		
		private Roles(String value) {
			this.value = value;	
		}

		public String getValue() {
			return value;
		}
		
	}
	
	public static enum Status {
		APPROVED('a'), REJECTED('r'), PENDING('p');
		private Character value;
		
		private Status(Character value) {
			this.value = value;	
		}

		public Character getValue() {
			return value;
		}
		
	}

}
