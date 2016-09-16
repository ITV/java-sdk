package User;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.loginradius.sdk.raas.api.*;
import com.loginradius.sdk.raas.models.*;
import com.loginradius.sdk.social.api.LoginRadiusAPI;
import com.loginradius.sdk.social.api.LoginRadiusGetAPI;
import com.loginradius.sdk.social.core.LoginRadiusCallbackHelper;
import com.loginradius.sdk.social.core.LoginRadiusClient;
import com.loginradius.sdk.social.core.LoginRadiusException;
import com.loginradius.sdk.social.models.AccessToken;
import com.loginradius.sdk.social.models.LoginRadiusContactCursorResponse;
import com.loginradius.sdk.social.models.company.LoginRadiusCompany;
import com.loginradius.sdk.social.models.event.LoginRadiusEvent;
import com.loginradius.sdk.social.models.group.LoginRadiusGroup;
import com.loginradius.sdk.social.models.like.LoginRadiusLike;
import com.loginradius.sdk.social.models.userprofile.LoginRadiusUltimateUserProfile;

/**
 * Servlet implementation class UserDataServlet
 */
@WebServlet("/UserDataServlet")
public class UserDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDataServlet() {
        super();        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sc = getServletContext();
		if(request.getParameter("userid")!=null){
			String url = "/profile.jsp";
			
			RaaSConfiguration configuration = new RaaSConfiguration(LoginRadiusCredentials.apiKey.toString(),
					LoginRadiusCredentials.apiSecret.toString());
			
			new RaaSClientConfig(configuration);
			UserProfileAPI userProfile = new UserProfileAPI();
			String userID = request.getParameter("userid"); 
			
		
			
			//System.out.println("UserDataServlet.doGet() userID  " + userID);
			RaaSUserDetails userDetails = userProfile.getUserByUserId(userID);

			
			RequestDispatcher rd = sc.getRequestDispatcher(url);
			request.setAttribute("firstName", userDetails.getFirstName());
			request.setAttribute("provider", userDetails.getProvider());

			request.setAttribute("lastName", userDetails.getLastName());
			request.setAttribute("gender", userDetails.getGender());
			request.setAttribute("dateofbirth", userDetails.getBirthDate());
			request.setAttribute("emailID", userDetails.getEmail().get(0).Value);	
			request.setAttribute("userId", userID);
			request.setAttribute("RaasID", userDetails.getUid());
			request.setAttribute("imageurl", userDetails.ImageUrl);
			rd.forward(request, response);
		} else if(request.getParameter("raasId")!=null) {
			String url = "/accountproviders.jsp";
			RaaSConfiguration configuration = new RaaSConfiguration(LoginRadiusCredentials.apiKey.toString(),LoginRadiusCredentials.apiSecret.toString());
					
			new RaaSClientConfig(configuration);
			UserProfileAPI userProfile = new UserProfileAPI();
			AccountAPI accountApi = new AccountAPI();
			String userID = request.getParameter("raasId");
			RequestDispatcher rd = sc.getRequestDispatcher(url);			
			rd.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		if(request.getParameter("userid")!=null){
			
	
		RaaSConfiguration configuration = new RaaSConfiguration(LoginRadiusCredentials.apiKey.toString(),LoginRadiusCredentials.apiSecret.toString());
		
		UserProfileAPI userProfile = new UserProfileAPI();
		new RaaSClientConfig(configuration);
		
		
		
        if(request.getParameter("password")!=null){
        	if(request.getParameter("oldpassword")!=null && request.getParameter("password")!=null && request.getParameter("confirmpassword")!=null)
        	{	if(request.getParameter("password").toString().equals(request.getParameter("confirmpassword").toString()))
        		{
        			RaaSResponse resp = userProfile.changePassword(
        					request.getParameter("userid").toString(), request.getParameter("oldpassword").toString(), 
        					request.getParameter("password").toString());      
        			response.sendRedirect("getProfile?userid"+request.getParameter("userid").toString());
        		}
        	else 
    			
    			response.sendRedirect(request.getRequestURL()+"?userId="+request.getParameter("userid").toString()+"&error="+"passwords dont match");
    		 
        	}/*else if(request.getParameter("password")!=null && request.getParameter("confirmpassword")!=null){
        			if(request.getParameter("password").toString().equals(request.getParameter("confirmpassword").toString()))
        			{        		
        				AccountAPI accountApi = new AccountAPI();.
        				RaaSUserDetails userdetails = userProfile.getUserByUserId(request.getParameter("userid"));
        				if(userdetails!=null) {accountApi.
        					RaaSResponse resp = accountApi.createRaaSProfile(
        					userdetails.getUid(),userdetails.getEmail().get(0).Value,
        					request.getParameter("password").toString());      
        			response.sendRedirect("getProfile?userid"+request.getParameter("userid").toString());
        				}
        			}
        			else 
            			response.sendRedirect(request.getRequestURL()+"?userId="+request.getParameter("userid").toString()+"&error="+"passwords dont match");
            		} */
        		
        		
		} else{
		
		RaaSUserDetails userDetails = new RaaSUserDetails();
		Map<String, String[]> data = request.getParameterMap();
		userDetails.setFirstName(request.getParameter("firstname").toString());
		userDetails.setLastName(request.getParameter("lastname").toString());
		userDetails.setBirthDate(request.getParameter("birthdate").toString());	
		userDetails.setGender(request.getParameter("gender").toString());
		//RaaSResponse resp = userProfile.editUser(request.getParameter("userid").toString(), userDetails);		
		}       
        response.sendRedirect("getProfile?userid="+request.getParameter("userid"));  
        
		}else if(request.getParameter("token")!=null){
			String accessToken = request.getParameter("token");
			ServletContext sc = getServletContext();
			String url = "/profile.jsp";
			  RequestDispatcher rd = sc.getRequestDispatcher(url);
			  
		
			  if(accessToken!=null){
			 // UserProfileAPI socialuserProfile= new UserProfileAPI();
			  LoginRadiusAPI profile= new LoginRadiusGetAPI("userprofile");
			  
			  LoginRadiusClient client= new LoginRadiusClient(accessToken);
			  
			  
			  try{
			  
			  LoginRadiusUltimateUserProfile userProfileData = client.getResponse(profile,LoginRadiusUltimateUserProfile.class);
			  request.setAttribute("userProfile",userProfileData);
			  }catch(LoginRadiusException exp){
				  
				  System.out.println("Cannot access userProfileData -- " + exp.getErrorResponse().getDescription());

				  System.out.println("Cannot access userProfileData -- " + exp.getErrorResponse().getProviderErrorResponse());

				 
			  }
			  
			  try{
              LoginRadiusAPI contacts=new LoginRadiusGetAPI("contact");
              LoginRadiusContactCursorResponse res=client.getResponse(contacts,LoginRadiusContactCursorResponse.class);
			  request.setAttribute("contactCursor",res);

			  }catch(LoginRadiusException exp){
				  
				  System.out.println("Cannot access contact API -- " + exp.getErrorResponse().getDescription());

				  System.out.println("Cannot access contact API -- " + exp.getErrorResponse().getProviderErrorResponse());

				 
			  }
			       
			  try{
			  
              LoginRadiusAPI company=new LoginRadiusGetAPI("company");
              LoginRadiusCompany[] companies=client.getResponse(company,LoginRadiusCompany[].class);
              System.out.println("userProfileData.company -- " + companies.length);
			 request.setAttribute("companies",companies);

			  }catch(LoginRadiusException exp){
				  
				  System.out.println("Cannot access company API -- " + exp.getErrorResponse().getDescription());

				  System.out.println("Cannot access company API -- " + exp.getErrorResponse().getProviderErrorResponse());

				 
			  }
			  
			  try{
              
              LoginRadiusAPI event =new LoginRadiusGetAPI("event");
              LoginRadiusEvent[] events=client.getResponse(event,LoginRadiusEvent[].class);
              System.out.println("events.length -- " + events.length);
			 request.setAttribute("events",events);

			  }catch(LoginRadiusException exp){
				  
				  System.out.println("Cannot access event API-- " + exp.getErrorResponse().getDescription());

				  System.out.println("Cannot access event API-- " + exp.getErrorResponse().getProviderErrorResponse());

				 
			  }
              
			  try{
              LoginRadiusAPI group=new LoginRadiusGetAPI("group");
              LoginRadiusGroup[] groups=client.getResponse(group,LoginRadiusGroup[].class);
              
              System.out.println("userProfileData.groups -- " + groups.length);
			  request.setAttribute("groups",groups);


			  }catch(LoginRadiusException exp){
				  
				  System.out.println("Cannot access group API -- " + exp.getErrorResponse().getDescription());

				  System.out.println("Cannot access group API -- " + exp.getErrorResponse().getProviderErrorResponse());

				 
			  }
			  
			  try{
              LoginRadiusAPI like=new LoginRadiusGetAPI("like");
              LoginRadiusLike[] likes=client.getResponse(like,LoginRadiusLike[].class);
              System.out.println("userProfileData.likes -- " + likes.length);
			 request.setAttribute("likes",likes);

              
			  }catch(LoginRadiusException exp){
				  
				  System.out.println("Cannot access likes API -- " + exp.getErrorResponse().getDescription());

				  System.out.println("Cannot access likes API -- " + exp.getErrorResponse().getProviderErrorResponse());

				 
			  }
			
              

			  	//request.setAttribute("mentions",userMentions);
			
                
			  	/*request.setAttribute("about", userProfileData.About);
				request.setAttribute("address", userProfileData.Addresses);

				request.setAttribute("birthdate", userProfileData.BirthDate);
				request.setAttribute("gender", userProfileData.Gender);
				request.setAttribute("state", userProfileData.State);
				request.setAttribute("email", userProfileData.Email.iterator().next());	
				request.setAttribute("city", userProfileData.City);
				//request.setAttribute("Educations", userProfileData.Educations);
				request.setAttribute("imageurl", userProfileData.ImageUrl);
				request.setAttribute("id", userProfileData.ID);
				request.setAttribute("fullname", userProfileData.FullName);
				request.setAttribute("firstname", userProfileData.FirstName);
				request.setAttribute("lastname", userProfileData.LastName);*/
				 /* System.out.println("userProfileData.About -- " + userProfileData.ImageUrl);
				  System.out.println("userProfileData.About -- " + userProfileData.ID);
				  System.out.println("userProfileData.About -- " + userProfileData.FullName);
				  System.out.println("userProfileData.About -- " + userProfileData.LastName);*/


				rd.forward(request, response);
				//response.sendRedirect(request.getRequestURL().toString());
				
				
				
			//userProfileData.Id
			//userProfileData.Provider
			//userProfileData.FirstName
			//userProfileData.LastName
			  
			  }
			
	
		}
		
	}
	
}
