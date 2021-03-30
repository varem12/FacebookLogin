package mx.daro.facebooklogin;

import java.util.Arrays;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.json.JsonObject;

import mx.daro.facebooklogin.entity.UserProfile;

public class GetUserDetails {
	
	public UserProfile Get_Profile_info (String accesstoken) {

		UserProfile objUserProfile = new UserProfile();
		FacebookClient facebookClient = new DefaultFacebookClient(accesstoken, Version.VERSION_8_0);
		JsonObject fetchObjectsResults = facebookClient.fetchObjects(Arrays.asList("me", "010101"), JsonObject.class, Parameter.with("fields","name,id,email"));
		
		objUserProfile.setUser_name(fetchObjectsResults.get("me").asObject().getString("name" , ""));
		objUserProfile.setEmail(fetchObjectsResults.get("me").asObject().getString("email", ""));
		objUserProfile.setId(fetchObjectsResults.get("me").asObject().getString("id"   , ""));
		
		System.out.println();System.out.println();
		System.out.println(objUserProfile.getId());
		System.out.println(objUserProfile.getUser_name());
		System.out.println(objUserProfile.getEmail());
		
		return objUserProfile;
		
	}
}