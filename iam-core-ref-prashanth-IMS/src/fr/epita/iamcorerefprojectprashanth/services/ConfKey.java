package fr.epita.iamcorerefprojectprashanth.services;

public enum ConfKey {
	/**
	 * this is the public enumeration key to choose the backend mode
	 */
	BACKEND_MODE("backend.mode"),
	/**
	 * this is the key to choose the fall back backend mode
	 */

	FALLBACK_BACKEND_MODE("backend.mode"),

	/**
	 * this fetches the db url
	 */
	DB_URL("db.url"),

	/**
	 * this is db user
	 */
	DB_USER("db.user"),

	/**
	 *this is db password
	 */
	DB_PASSWORD("db.pwd"),

	/**
	 *
	 */
	DB_BACKEND("db"),

	/**
	 *
	 */
	IDENTITY_SEARCH_QUERY(
			"identity.search"),
	/**
	 *
	 */
	IDENTITY_INSERT_QUERY("identity.insert"),
	IDENTITY_DELETE_QUERY("identity.DELETE"),
	IDENTITY_UPDATE_QUERY("identity.UPDATE");

	private String key;

	/**
	 *
	 */
	private ConfKey(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}

}
