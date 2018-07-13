package fr.epita.iamcorerefPraveen.services;
/**
 * 
 */
import java.util.List;

import fr.epita.iamcorerefPraveen.datamodel.Identity;
import fr.epita.iamcorerefPraveen.exceptions.DAOCreateException;
import fr.epita.iamcorerefPraveen.exceptions.DAODeleteException;
import fr.epita.iamcorerefPraveen.exceptions.DAOFindException;
import fr.epita.iamcorerefPraveen.exceptions.DAOUpdateException;

public interface IdentityDAO {
	 /**
     * Stores the Identity to Database.
     * @param insert identity.
     */
    void create(Identity identity) throws DAOCreateException;

    /**
     * Search or read Identity from Database with given criteria.
     * @param search for Identities.

     */
    List<Identity> find(Identity criteria) throws DAOFindException;

    /**
     * Update Identity in Database.
     */
    void update(Identity identity) throws DAOUpdateException;

    /**
     * Delete Identity from Database.
     */
    void delete(Identity identity) throws DAODeleteException;

    /**
     * Close the access to the Database.
     */
    void close();

}
