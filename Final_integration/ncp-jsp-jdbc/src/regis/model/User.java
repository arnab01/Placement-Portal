package regis.model;

public class User {
	protected String id;
	protected String name;
	protected String email;
	protected String company;
	protected String role;
	protected String offer;
	
	public User() {
	}
	
	
	public User(String id, String name, String email, String company, String role, String offer) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.company = company;
		this.role = role;
		this.offer = offer;
	}
	
	


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getOffer() {
		return offer;
	}

	public void setOffer(String offer) {
		this.offer = offer;
	}

	
}