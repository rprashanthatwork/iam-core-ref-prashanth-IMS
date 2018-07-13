package fr.epita.iamcorerefprojectprashanth.services;

import java.util.List;

import fr.epita.iamcorerefprashanth.datamodel.Identity;
import fr.epita.iamcorerefprojectprashanth.exceptions.DAOCreateException;
import fr.epita.iamcorerefprojectprashanth.exceptions.DAODeleteException;
import fr.epita.iamcorerefprojectprashanth.exceptions.DAOFindException;
import fr.epita.iamcorerefprojectprashanth.exceptions.DAOUpdateException;

public interface IdentityDAO {
	 /**
     * Stores the Identity to Database using abstract interface.
     * @param insert identity.
     */
    void create(Identity identity) throws DAOCreateException;

    /**
     * Search or read Identity from Database with given criteria using abstract interface.
     * @param search for Identities.

     */
    List<Identity> find(Identity criteria) throws DAOFindException;

    /**
     * Update Identity in Database using abstract interface.
     */
    void update(Identity identity) throws DAOUpdateException;

    
    /**
     * Delete identity from database using abstract interface
     * 
     * @param identity
     * @throws DAODeleteException
     */
    void delete(Identity identity) throws DAODeleteException;

    /**
     * This Closes the access to the Database.
     */
    void close();

}
