package fr.epita.iamcorerefprojectprashanth.services;
/**
 * 
 */
public interface Authentication {
	 /**
     * Authenticate with user name and password.
     */
    boolean authenticate(String username, String password);
}
