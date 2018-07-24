public class Authenticator {
	
	public boolean AuthenticateUser(String userName, String password)
	{
		return (userName.equals("joe") && password.equals("joepass"));
	}

}
