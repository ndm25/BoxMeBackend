package hackathon.boxme.register;

import hackathon.boxme.utils.SimpleDBUtils;

public class RegisterAccount {
	
	public static boolean main(String user,Credentials credentials) throws AccountNotSupportedException{
		boolean result = false;
		if(credentials.getType().equalsIgnoreCase("dropbox")){
			DropBoxCredentials dbCredentials = (DropBoxCredentials) credentials;
			result = RegisterDropBoxAccount(user, dbCredentials);
		}
		if(credentials.getType().equalsIgnoreCase("google")){
			GoogleCredentials googleCredentials = (GoogleCredentials) credentials;
			result = RegisterGoogleAccount(user, googleCredentials);
		}
		else {
			throw new AccountNotSupportedException();
		}
		return result;
	}

	private static boolean RegisterDropBoxAccount(String user, DropBoxCredentials dbCredentials) {
		SimpleDBUtils.insert(dbCredentials.getFacebookId(), "dropbox "+user, dbCredentials.getAccessToken()+" "+dbCredentials.getSecretKey());
		return true;		
	}
	
	private static boolean RegisterGoogleAccount(String user, GoogleCredentials dbCredentials) {
		SimpleDBUtils.insert(dbCredentials.getFacebookId(), "google "+user, dbCredentials.getAccessToken()+" "+dbCredentials.getSecretKey());
		return true;		
	}

}