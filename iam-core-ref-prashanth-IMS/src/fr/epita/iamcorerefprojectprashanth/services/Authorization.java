package fr.epita.iamcorerefprojectprashanth.services;
import fr.epita.iamcorerefprashanth.config.Config;

public class Authorization implements Authentication {
	 private String username;
	    private String password;

	    /**Get a default username and password.
	     */
	    public Authorization() {
	        this.username = Config.authenticateuname;
	        this.password = Config.authenticatepwd;
	    }

	    /**
	     * @param username 
	     * @param password 
	     */
	    public boolean authenticate(String username, String password) {
	        return username.equals(this.username) && password.equals(this.password);
	    }

}
