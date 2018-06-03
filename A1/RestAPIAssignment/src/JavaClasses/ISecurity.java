package JavaClasses;
public interface ISecurity{
	
	// Returns whether the dealer is authorized to order parts on behalf of their customers.
	
	public boolean isDealerAuthorized(String dealerid, String dealeraccesskey);
}