package fr.epita.iamcorerefprashanth.config;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.logging.Logger;

import fr.epita.iamcorerefprojectprashanth.launcher.Launcher;
import fr.epita.iamcorerefprojectprashanth.services.ConfKey;

/**
 * This class is for storing configuration info of the Project
 * 
 * @author Prashanth
 *
 */
public class Config {
	
	private Config()
	{
		
	}
	/**
     * This is JDBC Connection string.
     */
    public static final String javadbcurl = "jdbc:derby://localhost:1527/sample";

    /**
     * This is JDBC User name to get connection.
     */
    public static final String javadbcuname = "prash";

    /**
     * This is JDBC Password to get connection
     */
    public static final String javadbcpwd = "anth";

    /**
     * This is the User name for authentication.
     */
    public static final String authenticateuname = "imsadmin";

    /**
     * This is the password for authentication.
     */
    public static final String authenticatepwd = "imspass";
    
    public static final String BACKEND_MODE = "backend.mode";
	public static final String FALLBACK_BACKEND_MODE = "fallback.backend.mode";
	public static final String DB_BACKEND = "db";
	public static final String FILE_BACKEND = "file";
	static Logger logger = Logger.getLogger(Launcher.class.getName());
	
    private static Properties properties;

	static {
		init();
	}
    private static void init() {
		try {
			properties = new Properties();
			properties.load(new FileInputStream(new File(System.getProperty("conf.file.path"))));
		} catch (final Exception e) {
			logger.info(e.getMessage());
		
		}


	}
    
    public static String getProperty(ConfKey key) {
		return properties.getProperty(key.getKey());
	}
    
    
    public static Integer getIntProperty(ConfKey key) {
		final String valueAsString = getProperty(key);
		return Integer.valueOf(valueAsString);
	}

	

}
