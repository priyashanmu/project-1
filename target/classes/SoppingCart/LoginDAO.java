                                                                                                  package SoppingCart;

public class LoginDAO {
public boolean isValidUser(String name,String pass)
{
	if(name.equals("priya")&& pass.equals("priya"))
	{
		return true;
		
	}
	else
	{
		return false;
	}
}
}
