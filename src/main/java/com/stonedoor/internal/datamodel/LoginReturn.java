package com.stonedoor.internal.datamodel;

import java.util.ArrayList;
import java.util.List;

public class LoginReturn {

	private String token;
	private List<String> enabled = new ArrayList<String>();
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public List<String> getEnabled() {
		return enabled;
	}
	public void setEnabled(List<String> enabled) {
		this.enabled = enabled;
	}
	
}
