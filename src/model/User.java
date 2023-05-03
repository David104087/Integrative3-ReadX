package model;
import java.util.Calendar;

public abstract class User {

	private String name;
	private String id;
	private Calendar linkingDate;

	/**
	 * 
	 * @param name
	 * @param id
	 * @param linkingDate
	 */
	public User(String name, String id, Calendar linkingDate) {
		this.name = name;
		this.id = id;
		this.linkingDate = linkingDate;
	}

	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return this.id;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	public Calendar getLinkingDate() {
		return this.linkingDate;
	}

	/**
	 * 
	 * @param linkingDate
	 */
	public void setLinkingDate(Calendar linkingDate) {
		this.linkingDate = linkingDate;
	}

	/**
	 * 
	 * @param name
	 */
	public Magazine findMagazineByName(String name) {
		// TODO - implement User.findMagazineByName
		throw new UnsupportedOperationException();
	}

}