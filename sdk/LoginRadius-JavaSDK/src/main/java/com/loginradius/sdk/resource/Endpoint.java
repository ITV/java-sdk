package com.loginradius.sdk.resource;

import java.util.Map;

/**
 * Object for setting LoginRadius end point into requesting urls
 * 
 *
 */
public class Endpoint {
	private static final String LOGINRADIUS_API_ROOT = "https://api.loginradius.com";
	private static final String LOGINRADIUS_SOCIALINTERFACE_URL = "http://cdn.loginradius.com/interface/json/";
	private static final String LOGINRADIUS_RAASINTERFACE_URL = "http://cdn.loginradius.com/raas/regSchema/";
	private static final String API_V2_LOGIN = "/identity/v2/auth/login";
	private static final String API_REGISTER = "/identity/v2/auth/register";
	private static final String API_FORGOTPASSWORDEamil = "/identity/v2/auth/password";
	private static final String API_FORGOTPASSWORDMobile = "/identity/v2/auth/password/otp";
	private static final String LOGINRADIUS_verifyotp = "/identity/v2/auth/phone/otp";
	private static final String LOGINRADIUS_updatephone = "/identity/v2/auth/phone";
	private static final String LOGINRADIUS_updateprofile = "/identity/v2/auth/account";
	private static final String LOGINRADIUS_AddEmail = "/identity/v2/auth/email";
	private static final String LOGINRADIUS_SocialIdentities = "/identity/v2/auth/socialIdentity";
	private static final String LOGINRADIUS_CheckUserNameAvailability = "/identity/v2/auth/username";
	private static final String API_V2_ALBUM = "/api/v2/album";
	private static final String API_V2_AUDIO = "/api/v2/audio";
	private static final String API_V2_CHECKIN = "/api/v2/checkin";
	private static final String API_V2_COMPANY = "/api/v2/company";
	private static final String API_V2_CONTACT = "/api/v2/contact";
	private static final String API_V2_EVENT = "/api/v2/event";
	private static final String API_V2_FOLLOWING = "/api/v2/following";
	private static final String API_V2_GROUP = "/api/v2/group";
	private static final String API_V2_LIKE = "/api/v2/like";
	private static final String API_V2_MENTION = "/api/v2/mention";
	private static final String API_V2_MESSAGE = "/api/v2/message";
	private static final String API_V2_PAGE = "/api/v2/page";
	private static final String API_V2_PHOTO = "/api/v2/photo";
	private static final String API_V2_POST = "/api/v2/post";
	private static final String API_V2_STATUS = "/api/v2/status";
	private static final String API_V2_USERPROFILE = "/identity/v2/auth/account";

	private static final String API_V2_VIDEO = "/api/v2/video";
	
	
	
	public static final String TOKEN_EXACHANGE = "/api/v2/access_token";
	public static final String API_V2_CustomObjects = "/identity/v2/auth/customobject";

	/**
	 * 
	 * Management API EndPoint
	 **/

	public static final String API_V2_Management_CreateAccount = "/identity/v2/manage/account";
	public static final String API_V2_Management_Role = "/identity/v2/manage/role";

	/**
	 * 
	 * Advianced API EndPoint
	 **/

	public static final String API_V2_Advanced_Identity = "/api/v2/identity";
	public static final String API_V2_Advanced_Aggregation_QueryData = "/api/v2/insights";
	public static final String API_V2_Advanced_Subscribe_RestHooks = "/api/v2/resthook/subscribe";
	public static final String API_V2_Advanced_Unsubscribe_RestHooks = "/api/v2/resthook/unsubscribe";
	public static final String API_V2_Advanced_Test_RestHooks_Settings = "/api/v2/resthook/test";
	public static final String API_V2_Advanced_list_of_RestHooks = "/api/v2/resthook/fields";
	public static final String API_V2_Advanced_Get_Subscribed_URL = "/api/v2/resthook/subscription";
	public static final String API_V2_Advanced_AccessToken_via_SocialToken = "/api/v2/access_token/";
	public static final String API_V2_Advanced_Refresh_UserProfile = "/api/v2/userprofile/refresh";
	public static final String API_V2_Advanced_RefreshToken = "/api/v2/access_token/refresh";
	public static final String API_V2_Advanced_ShortenURL = "/sharing/v1/shorturl";

	/**
	 * Creates Management API url after appending LoginRadius api root url
	 * 
	 * @return complete url for fetching data
	 */

	public static String getV2_ManagementCreateAccount() {
		return LOGINRADIUS_API_ROOT + API_V2_Management_CreateAccount;
	}

	public static String getV2_ManagementCreateCustomObject() {
		return LOGINRADIUS_API_ROOT + API_V2_Management_CreateAccount;
	}

	public static String getV2_ManagementCreateRole() {
		return LOGINRADIUS_API_ROOT + API_V2_Management_Role;
	}

	public static String getV2_AdvancedIdentity() {
		return LOGINRADIUS_API_ROOT + API_V2_Advanced_Identity;
	}

	public static String getV2_AdvancedQueryData() {
		return LOGINRADIUS_API_ROOT + API_V2_Advanced_Aggregation_QueryData;
	}

	public static String getV2_AdvancedSubscribeRestHooks() {
		return LOGINRADIUS_API_ROOT + API_V2_Advanced_Subscribe_RestHooks;
	}

	public static String getV2_AdvancedUnsubscribeRestHooks() {
		return LOGINRADIUS_API_ROOT + API_V2_Advanced_Unsubscribe_RestHooks;
	}

	public static String getV2_AdvancedRestHooksSettings() {
		return LOGINRADIUS_API_ROOT + API_V2_Advanced_Test_RestHooks_Settings;
	}

	public static String getV2_AdvancedListofRestHooks() {
		return LOGINRADIUS_API_ROOT + API_V2_Advanced_list_of_RestHooks;
	}

	public static String getV2_AdvancedGetSubscribedurl() {
		return LOGINRADIUS_API_ROOT + API_V2_Advanced_Get_Subscribed_URL;
	}

	public static String getV2_AdvancedAccessTokenViaSocialToken() {
		return LOGINRADIUS_API_ROOT + API_V2_Advanced_AccessToken_via_SocialToken;
	}

	public static String getV2_AdvancedRefreshUserProfile() {
		return LOGINRADIUS_API_ROOT + API_V2_Advanced_Refresh_UserProfile;
	}

	public static String getV2_AdvancedRefreshToken() {
		return LOGINRADIUS_API_ROOT + API_V2_Advanced_RefreshToken;
	}

	public static String getV2_AdvancedShortenURL() {
		return LOGINRADIUS_API_ROOT + API_V2_Advanced_ShortenURL;
	}

	/**
	 * Creates Auth url after appending LoginRadius api root url
	 * 
	 * @return complete url for fetching data
	 */

	public static String getV2_VIDEO() {
		return LOGINRADIUS_API_ROOT + API_V2_VIDEO;
	}

	public static String getV2_USERPROFILE() {
		return LOGINRADIUS_API_ROOT + API_V2_USERPROFILE;
	}

	public static String getV2_STATUS() {
		return LOGINRADIUS_API_ROOT + API_V2_STATUS;
	}

	public static String getV2_POST() {
		return LOGINRADIUS_API_ROOT + API_V2_POST;
	}

	public static String getV2_PHOTO() {
		return LOGINRADIUS_API_ROOT + API_V2_PHOTO;
	}

	public static String getV2_PAGE() {
		return LOGINRADIUS_API_ROOT + API_V2_PAGE;
	}

	public static String getV2_MESSAGE() {
		return LOGINRADIUS_API_ROOT + API_V2_MESSAGE;
	}

	public static String getV2_MENTION() {
		return LOGINRADIUS_API_ROOT + API_V2_MENTION;
	}

	public static String getV2_LIKE() {
		return LOGINRADIUS_API_ROOT + API_V2_LIKE;
	}

	public static String getV2_GROUP() {
		return LOGINRADIUS_API_ROOT + API_V2_GROUP;
	}

	public static String getV2_FOLLOWING() {
		return LOGINRADIUS_API_ROOT + API_V2_FOLLOWING;
	}

	public static String getV2_EVENT() {
		return LOGINRADIUS_API_ROOT + API_V2_EVENT;
	}

	public static String getV2_CONTACT() {
		return LOGINRADIUS_API_ROOT + API_V2_CONTACT;
	}

	public static String getV2_COMPANY() {
		return LOGINRADIUS_API_ROOT + API_V2_COMPANY;
	}

	public static String getV2_ALBUM() {
		return LOGINRADIUS_API_ROOT + API_V2_ALBUM;
	}

	public static String getV2_CHECKIN() {
		return LOGINRADIUS_API_ROOT + API_V2_CHECKIN;
	}

	public static String getV2_AUDIO() {
		return LOGINRADIUS_API_ROOT + API_V2_AUDIO;
	}

	public static String getLoginUrl() {
		return LOGINRADIUS_API_ROOT + API_V2_LOGIN;
	}

	public static String getUpdateProfileUrl() {
		return LOGINRADIUS_API_ROOT + LOGINRADIUS_updateprofile;
	}

	public static String getRegistrationUrl() {
		return LOGINRADIUS_API_ROOT + API_REGISTER;
	}

	public static String getVerifyotpUrl() {
		return LOGINRADIUS_API_ROOT + LOGINRADIUS_verifyotp;
	}

	public static String getUpdatephoneUrl() {
		return LOGINRADIUS_API_ROOT + LOGINRADIUS_updatephone;
	}

	public static String getAddEmailUrl() {
		return LOGINRADIUS_API_ROOT + LOGINRADIUS_AddEmail;
	}

	public static String getForgotPasswordUrlEmail() {
		return LOGINRADIUS_API_ROOT + API_FORGOTPASSWORDEamil;
	}

	public static String getForgotPasswordUrlMobile() {
		return LOGINRADIUS_API_ROOT + API_FORGOTPASSWORDMobile;
	}

	public static String getSocialInterfaceUrl(String apiKey) {
		return LOGINRADIUS_SOCIALINTERFACE_URL + apiKey + ".json";
	}

	public static String getRegisterInterfaceUrl(String apiKey) {
		return LOGINRADIUS_RAASINTERFACE_URL + apiKey + ".json";
	}

	public static String getSocialIdentities() {
		return LOGINRADIUS_API_ROOT + LOGINRADIUS_SocialIdentities;
	}

	

	public static String getExchangetoken() {
		return LOGINRADIUS_API_ROOT + TOKEN_EXACHANGE;
	}

	public static String getUserNameAvailability() {
		return LOGINRADIUS_API_ROOT + LOGINRADIUS_CheckUserNameAvailability;
	}

	public static String getCustomObject() {
		return LOGINRADIUS_API_ROOT + API_V2_CustomObjects;
	}

	/**
	 * Creates url after appending loginradius api root url and query parameters
	 * 
	 * @param url
	 *            url for appending to the api url
	 * @param queryArgs
	 *            extra parameters for sending with url
	 * @return complete url for fetching data
	 */
	public static String GetRequestUrl(String url, Map<String, String> queryArgs) {
		String keyvalueString = createKeyValueString(queryArgs);
		if (url.contains("?"))
			return url + "&" + keyvalueString;

		return url + "?" + keyvalueString;
	}

	/**
	 * Creates key-value string
	 * 
	 * @param queryArgs
	 *            parameters that will attach to the url
	 * @return query string with the given parameters
	 */
	public static String createKeyValueString(Map<String, String> queryArgs) {
		if (queryArgs != null) {
			String[] sb = new String[queryArgs.size()];
			int i = 0;
			for (Map.Entry<String, String> entry : queryArgs.entrySet()) {
				sb[i] = entry.getKey() + "=" + entry.getValue();
				i++;
			}
			return combine(sb, "&");
		} else
			return null;
	}

	/**
	 * Combine to create key-value string
	 * 
	 * @param s
	 *            Array String where the glue will be appended
	 * @param glue
	 *            String to be appended with Array String
	 * @return appended String
	 */
	public static String combine(String[] s, String glue) {
		int k = s.length;
		if (k == 0)
			return null;
		StringBuilder out = new StringBuilder();
		out.append(s[0]);
		for (int x = 1; x < k; ++x)
			out.append(glue).append(s[x]);
		return out.toString();
	}
}
