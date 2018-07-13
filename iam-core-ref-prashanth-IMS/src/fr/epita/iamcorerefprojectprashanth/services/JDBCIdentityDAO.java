package fr.epita.iamcorerefprojectprashanth.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import fr.epita.iamcorerefprashanth.config.Config;
import fr.epita.iamcorerefprashanth.datamodel.Identity;
import fr.epita.iamcorerefprojectprashanth.exceptions.DAOCreateException;
import fr.epita.iamcorerefprojectprashanth.exceptions.DAODeleteException;
import fr.epita.iamcorerefprojectprashanth.exceptions.DAOFindException;
import fr.epita.iamcorerefprojectprashanth.exceptions.DAOUpdateException;
import fr.epita.iamcorerefprojectprashanth.launcher.Launcher;

/**
 * @author @Prashanth
 */
public class JDBCIdentityDAO implements IdentityDAO {
	private Connection conn;
	static Logger logger = Logger.getLogger(Launcher.class.getName());
    public JDBCIdentityDAO() throws SQLException {
        this.conn = DriverManager.getConnection(
                Config.javadbcurl,
                Config.javadbcuname,
                Config.javadbcpwd
        );
    }

    /**
     * Stores the Identity to the Identity table.
     */
    public void create(Identity identity) throws DAOCreateException {
        try {
            PreparedStatement statement = conn.prepareStatement(
                    Config.getProperty(ConfKey.IDENTITY_INSERT_QUERY));
            statement.setString(1, identity.getusername());
            statement.setString(2, identity.getEmail());
           
            statement.execute();
            
        } catch (SQLException sqle) {
            DAOCreateException e = new DAOCreateException();
            e.initCause(sqle);
            e.setFaultObject(identity);
            throw e;
        }
       
    }

    /**
     * Search the Identity from the Identity table.
     */
    public List<Identity> find(Identity criteria) throws DAOFindException {
        List<Identity> results = new ArrayList<>();
        String sql = "SELECT * FROM ADMIN.IDENTITIES";
        boolean view = false;

        if (criteria.getUid() != null) {
            sql += " WHERE IDENTITY_UID=" + criteria.getUid();
            view = true;
        }

        if (criteria.getusername() != null) {
            if (view) {
                sql += " AND IDENTITY_DISPLAYNAME='" + criteria.getusername() + "'";
            } else {
                sql += " WHERE IDENTITY_DISPLAYNAME='" + criteria.getusername() + "'";
            }
            view = true;
        }

        if (criteria.getEmail() != null) {
            if (view) {
                sql += " AND IDENTITY_EMAIL='" + criteria.getEmail() + "'";
            } else {
                sql += " WHERE IDENTITY_EMAIL='" + criteria.getEmail() + "'";
            }
        }

        try {
            PreparedStatement statement = this.conn.prepareStatement(sql);
            ResultSet statementResult = statement.executeQuery();
            while (statementResult.next()) {
                String displayname = statementResult.getString("IDENTITY_DISPLAYNAME");
                String email = statementResult.getString("IDENTITY_EMAIL");
                int uid = statementResult.getInt("IDENTITY_UID");
                results.add(new Identity(displayname, email, uid));
            }
        } catch (SQLException sqle) {
            DAOFindException e = new DAOFindException();
            e.initCause(sqle);
            e.setFaultObject(criteria);
            throw e;
        }
        return results;
    }

    /**
     * Update Identity to the Identity table.
     */
    public void update(Identity identity) throws DAOUpdateException {
        try {
        	  PreparedStatement statement = conn.prepareStatement(
                      Config.getProperty(ConfKey.IDENTITY_UPDATE_QUERY));
            
            statement.setString(1, identity.getusername());
            statement.setString(2, identity.getEmail());
            statement.setInt(3, identity.getUid());
            statement.execute();
        } catch (SQLException sqle) {
            DAOUpdateException e = new DAOUpdateException();
            e.initCause(sqle);
            e.setFaultObject(identity);
            throw e;
        }
        
     
         }

    /**
     * Delete Identity from the Identity table.
     */
    public void delete(Identity identity) throws DAODeleteException {
        try {
        	
            PreparedStatement statement = this.conn.prepareStatement(Config.getProperty(ConfKey.IDENTITY_DELETE_QUERY));           
            statement.setInt(1, identity.getUid());
            statement.execute();
        } catch (SQLException sqle) {
            DAODeleteException e = new DAODeleteException();
            e.initCause(sqle);
            e.setFaultObject(identity);
            throw e;
        }
      
    }

    /**
     * Close the JDBC connection.
     */
    public void close() {
        try {
            this.conn.close();
        } catch (SQLException e) {
        	logger.info(e.getMessage());
        }
    }
}

