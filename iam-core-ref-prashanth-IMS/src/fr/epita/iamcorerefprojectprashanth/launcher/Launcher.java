package fr.epita.iamcorerefprojectprashanth.launcher;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;
import fr.epita.iamcorerefprashanth.datamodel.Identity;
import fr.epita.iamcorerefprojectprashanth.exceptions.DAOCreateException;
import fr.epita.iamcorerefprojectprashanth.exceptions.DAODeleteException;
import fr.epita.iamcorerefprojectprashanth.exceptions.DAOFindException;
import fr.epita.iamcorerefprojectprashanth.exceptions.DAOUpdateException;
import fr.epita.iamcorerefprojectprashanth.services.Authentication;
import fr.epita.iamcorerefprojectprashanth.services.Authorization;
import fr.epita.iamcorerefprojectprashanth.services.IdentityDAO;
import fr.epita.iamcorerefprojectprashanth.services.JDBCIdentityDAO;

public class Launcher {
	private static Scanner scan;
	static Logger logger = Logger.getLogger(Launcher.class.getName());
	public static void main(String[] args) throws Exception {
		 scan = new Scanner(System.in);


System.out.println("Welcome to the IMS Console");
       if (!authenticate()) {
	        	System.out.println("Either the username or password is incorrect.");
	            System.exit(0);
	        }

	        System.out.println("You have successfully logged in.");

	        mainProgram();
	    }

	    private static boolean authenticate() {
	        Authentication authenticator = new Authorization();

	        System.out.println("Please enter your username and password to Login to IMS");
	        System.out.println("Your user Name: ");
	        String identityname = scan.nextLine();
	        System.out.println("Your Password: ");
	        String password = scan.nextLine();

	        return authenticator.authenticate(identityname, password);
	    }

	    /**
	     * @throws Exception
	     */
	    private static void mainProgram() throws Exception {
	        System.out.println("");
	        System.out.println("Choose 1. To Create a new Identity");
	        System.out.println("Choose 2. To Search Identities");
	        System.out.println("Choose 3. To Update Identity");
	        System.out.println("Choose 4. To Delete Identity");
	        System.out.println("Choose 5. To Quit");

	       System.out.println("Make a choice to select the task to be performed: ");

	        String task = scan.nextLine().trim();

	        switch (task) {
	            case "1":
	                createnewIdentity();
	                break;
	            case "2":
	                searchIdentity();
	                break;
	            case "3":
	                updateIdentity();
	                break;
	            case "4":
	                deleteIdentityMenu();
	                break;
	            case "5":
	             
	                System.out.println("Thanks for Using our application, you are the best ;)");
	                System.exit(0);
	                break;
	            default:
	                System.out.println("We understand your high expectation, But we didn't foresee this. Sincere Apologies for the disappointment.");
	                mainProgram();
	        }
	    }

	    /**
	     * @throws Exception
	     */
	    private static void createnewIdentity() throws Exception {
	        System.out.println("Please help us add your identity");
	        System.out.println("Enter Identity Name: ");
	        String identityname = scan.nextLine();
	        System.out.println("Enter your Email: ");
	        String email = scan.nextLine();
	        Identity identity = new Identity(identityname, email, null);

	        createnewIdentity(identity);
	        mainProgram();
	    }

	    private static void searchIdentity() throws Exception {
	        System.out.println("Please help us in Searching identity: ");
	        System.out.println("Enter the UID: ");
	        String uid = scan.nextLine();
	        System.out.println("Enter the Display Name: ");
	        String identityname = scan.nextLine();
	        System.out.println("Enter the Email: ");
	        String email = scan.nextLine();
	        Identity identity = new Identity(null, null, null);

	        if (uid.length() != 0) {
	            identity.setUid(Integer.parseInt(uid));
	        }

	        if (identityname.length() != 0) {
	            identity.setidentityname(identityname);
	        }

	        if (email.length() != 0) {
	            identity.setEmail(email);
	        }

	        searchIdentity(identity);
	        mainProgram();
	    }

	    /**
	     * @throws Exception
	     */
	    private static void updateIdentity() throws Exception {
	        System.out.println("Please help us to Update Identity:");
	        Identity identity = new Identity(null, null, null);

	        searchIdentity(identity);
	        System.out.println("Choose Identity by UID:");
	        int uid = Integer.parseInt(scan.nextLine());
	        identity.setUid(uid);
	        System.out.println("New Identity Name:");
	        identity.setidentityname(scan.nextLine());
	        System.out.println("New Email:");
	        identity.setEmail(scan.nextLine());

	        updateIdentity(identity);

	        mainProgram();
	    }

	    private static void deleteIdentityMenu() throws Exception {
	        System.out.println("Please help us to Delete Identity:");
	        Identity identity = new Identity(null, null, null);

	        searchIdentity(identity);
	        System.out.println("Choose Identity by UID:");
	        int uid = Integer.parseInt(scan.nextLine());
	        identity.setUid(uid);

	        deleteIdentity(identity);

	        mainProgram();
	    }

	    /**
	     * @param identity
	     * @throws SQLException 
	     * @throws DAOCreateException 
	     */
	    private static void createnewIdentity(Identity identity) throws SQLException, DAOCreateException {
	       
	            IdentityDAO dao = new JDBCIdentityDAO();
	           
	                dao.create(identity);
	                System.out.println(" Wow! We have Successfully created the new identity!");
	            
	                dao.close();
	          
	    }

	    /**
	     * @param criteria
	     * @throws SQLException 
	     * @throws DAOFindException 
	     * @throws Exception
	     */
	    private static void searchIdentity(Identity criteria) throws SQLException, DAOFindException {
	       
	            IdentityDAO dao = new JDBCIdentityDAO();
	            
	                List<Identity> results = dao.find(criteria);
	                for (Identity result: results) {
	                    System.out.println(result);
	                }
	             
	        
	                    dao.close();
	           
	        }
	    

	    private static void updateIdentity(Identity identity) throws SQLException, DAOUpdateException {
	     
	            IdentityDAO dao = new JDBCIdentityDAO();
	           
	                dao.update(identity);
	                System.out.println("Wow! We have Successfully updated the identity!");
	          
	                dao.close();
	            
	      	    }

	    private static void deleteIdentity(Identity identity) throws DAODeleteException, SQLException {
	    
	            IdentityDAO dao = new JDBCIdentityDAO();
	         
	                dao.delete(identity);
	                System.out.println("Wow! We have Successfully deleted the identity!");
	            
	
	                dao.close();
	            
	        }
	    }