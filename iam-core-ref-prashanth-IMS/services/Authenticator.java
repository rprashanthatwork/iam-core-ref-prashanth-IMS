package fr.epita.iamcorerefPraveen.services;
/**
 * 
 */
public interface Authenticator {
	 /**
     * Authenticate with user name and password.
     */
    boolean authenticate(String username, String password);
}
