package com.loginradius.sdk.management.api;

import java.util.HashMap;
import java.util.Map;

import com.loginradius.sdk.resource.Endpoint;
import com.loginradius.sdk.resource.LoginRadiusException;
import com.loginradius.sdk.util.ArgumentValidator;

public class ManagementGetAPI extends LRManagementAPI {

	private String method = "";
	private String finalpath = "";
	private String objectRecordId = "";
	private String uid = "";

	private Map<String, String> map = new HashMap<String, String>();

	public ManagementGetAPI(String method, Map<String, String> map) {

		this.method = method;
		this.map = map;

	}

	public String getResponse(String token) {

		// ARgument validator should go here.

		if (!ArgumentValidator.pathValidator(this.method)) {

			throw new LoginRadiusException(
					"Invalid Argument used. Please refer documentation and use the correct argument");

		}

		Map<String, String> params = new HashMap<String, String>();
		if (this.map != null && !this.map.isEmpty()) {
			params.putAll(map);
			if (map.containsKey("objectRecordId")) {
				objectRecordId = map.get("objectRecordId");
			}
			if (map.containsKey("uid")) {
				uid = map.get("uid");
			}
		}
		
		
		
		if ("emaillogin".equals(method)) {
			finalpath = Endpoint.getV2_ManagementCreateAccount();
		}else if ("usernamelogin".equals(method )) {
			finalpath = Endpoint.getV2_ManagementCreateAccount();
		}else if ("loginbyphone".equals(method )) {
			finalpath = Endpoint.getV2_ManagementCreateAccount();
		}else if ("loginbyuid".equals(method )) {
			params.remove("uid");
			finalpath = Endpoint.getV2_ManagementCreateAccount() + "/" + uid;
		}else if ("getpassword".equals(method )) {
			params.remove("uid");
			finalpath = Endpoint.getV2_ManagementCreateAccount() + "/" + uid + "/password";
		}else if ("customobjectbyuid".equals(method )) {
			params.remove("objectRecordId");
			params.remove("uid");
			finalpath = Endpoint.getV2_ManagementCreateAccount() + "/" + uid + "/customobject/" + objectRecordId;
		}else if ("getrole".equals(method )) {
			finalpath = Endpoint.getV2_ManagementCreateRole();
		}else if ("getrolesbyuid".equals(method )) {
			finalpath = Endpoint.getV2_ManagementCreateAccount() + "/" + uid + "/role";
		}else if ("getrolecontext".equals(method )) {
			params.remove("uid");
			finalpath = Endpoint.getV2_ManagementGetRoleContext() + "/" + uid + "/rolecontext";
		}
		
		return executeGet(finalpath, params);

	}
}
