package com.loginradius.sdk.authentication.api;


/* 
 * 
 * Created by LoginRadius Development Team on 02/06/2017
   Copyright � 2017 LoginRadius Inc. All rights reserved.  
   
 */

import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonObject;
import com.loginradius.sdk.resource.Endpoint;
import com.loginradius.sdk.resource.LoginRadiusException;
import com.loginradius.sdk.util.ArgumentValidator;

public class AuthenticationPostAPI extends LRAuthenticationAPI {

	private final String method;

	private String finalpath = "";

	private Map<String, String> map = new HashMap<String, String>();

	private JsonObject json;

	public AuthenticationPostAPI(String method, Map<String, String> map, JsonObject data) {

		this.method = method;

		this.map = map;
		if (data != null) {
			this.json = data;
		} else {
			JsonObject registerdata = new JsonObject();
			registerdata.addProperty("", "");
			this.json = registerdata;
		}

	}

	@Override
	public String getResponse(String token) {
		// TODO Auto-generated method stub

		// write the validator

		if (!ArgumentValidator.pathValidator(this.method)) {

			throw new LoginRadiusException(
					"Invalid Argument used. Please refer documentation and use the correct argument");

		}

		Map<String, String> params = new HashMap<String, String>();
		if (this.map != null && !this.map.isEmpty()) {
			params.putAll(map);

		}

		if ("status".equals(method)) {
			params.put("access_token", token);
			finalpath = Endpoint.getV2_STATUS();
		} else if ("message".equals(method)) {
			params.put("access_token", token);
			finalpath = Endpoint.getV2_MESSAGE();
		} else if ("register".equals(method)) {
			finalpath = Endpoint.getRegistrationUrl();
		} else if ("password".equals(method)) {
			finalpath = Endpoint.getForgotPasswordUrlEmail();
		} else if ("addemail".equals(method)) {
			params.put("access_token", token);
			finalpath = Endpoint.getAddEmailUrl();
		} else if ("createcustomobject".equals(method)) {
			params.put("access_token", token);
			finalpath = Endpoint.getCustomObject();
		} else if ("forgotpasswordbyotp".equals(method)) {
			finalpath = Endpoint.getForgotPasswordUrlMobile();
		} else if ("resendotp".equals(method)) {
			finalpath = Endpoint.getVerifyotpUrl();
		} else if ("resendotpbytoken".equals(method)) {
			params.put("access_token", token);
			finalpath = Endpoint.getVerifyotpUrl();
		} else if ("forgotpasswordbyemail".equals(method)) {
			finalpath = Endpoint.getForgotPasswordUrlEmail();
		}

		return executePost(finalpath, params, json);
	}

}
