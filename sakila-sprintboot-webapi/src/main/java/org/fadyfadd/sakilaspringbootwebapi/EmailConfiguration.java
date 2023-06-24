package org.fadyfadd.sakilaspringbootwebapi;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Component
@ConfigurationProperties(prefix="configuration")
public class EmailConfiguration {

	
	public String getEmailHostName() {
		return emailHostName;
	}
	public void setEmailHostName(String emailHostName) {
		this.emailHostName = emailHostName;
	}
	public String getEmailPort() {
		return emailPort;
	}
	public void setEmailPort(String emailPort) {
		this.emailPort = emailPort;
	}
	public String getEmailFrom() {
		return emailFrom;
	}
	public void setEmailFrom(String emailFrom) {
		this.emailFrom = emailFrom;
	}
	private String emailHostName;
	private String emailPort;
	private String emailFrom;
	
}
