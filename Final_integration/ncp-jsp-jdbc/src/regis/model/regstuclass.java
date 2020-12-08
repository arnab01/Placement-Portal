package regis.model;

public class regstuclass {
	public regstuclass() {
		super();
		// TODO Auto-generated constructor stub
	}
	public regstuclass(String id, String company) {
		super();
		this.id = id;
		this.company = company;
	}
	protected String id;
	protected String company;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
}
