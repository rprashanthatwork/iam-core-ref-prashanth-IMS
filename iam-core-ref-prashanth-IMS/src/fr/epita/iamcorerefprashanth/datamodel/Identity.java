package fr.epita.iamcorerefprashanth.datamodel;
/** 
 */

/**
 * @author @Prashanth
 */
public class Identity {
	private Integer uid;
    private String identityname;
    private String email;

    /**
     * Describing identity
     * @param username 
     * @param email       
     * @param uid         
     */
    public Identity(String username, String email, Integer uid) {
        this.uid = uid;
        this.identityname = username;
        this.email = email;
    }
	
	/**
     * To set username
     */
    public void setidentityname(String username) {
        this.identityname = username;
    }

    /**
     * To get username
     */
    public String getusername() {
        return identityname;
    }
   

    /**
     * @return Unique ID
     */
    public Integer getUid() {
        return uid;
    }

    /**
     *
     * @param uid Unique ID
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }


    /**
     * @param email Email address
     */
    public void setEmail(String email) {
        this.email = email;
    }

	/**
     * @return Email address
     */
    public String getEmail() {
        return email;
    }
	
    @Override
    public String toString() {
        return String.format("[UID=%d] Identity [username=%s; email=%s]",
                this.uid, this.identityname, this.email);
    }

}
