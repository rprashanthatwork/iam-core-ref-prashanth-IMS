package fr.epita.iamcorerefprojectprashanth.exceptions;
/**
 * 
 */
public class DAOFindException extends Exception {
	 private Object faultObject;

	    /**
	     *
	     * @param Object
	     */
	    public void setFaultObject(Object obj){
	        this.faultObject = obj;
	    }

	    
	    /* (non-Javadoc)
	     * @see java.lang.Throwable#getMessage()
	     */
	    @Override
	    public String getMessage() {
	        return super.getMessage() + String.valueOf(this.faultObject);
	    }

}
