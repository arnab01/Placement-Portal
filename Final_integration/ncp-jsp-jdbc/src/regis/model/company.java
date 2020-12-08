package regis.model;
import java.sql.*;
import java.time.LocalTime;

public class company {
  public company() {
		super();
		// TODO Auto-generated constructor stub
	}
public company(String companyname, String testname, String testdate, Integer roundno, String start, String end) {
		super();
		this.companyname = companyname;
		this.testname = testname;
		this.testdate = testdate;
		this.roundno = roundno;
		this.start = start;
		this.end = end;
		
	}
private String companyname;
  private String testname;
  private String testdate;
  private Integer roundno;
  private String start;
  private String end;
  private Integer scip;
public String getCompanyname() {
	return companyname;
}
public Integer getScip() {
	return scip;
}
public void setScip(Integer scip) {
	this.scip = scip;
}

public void setCompanyname(String companyname) {
	this.companyname = companyname;
}
public String getTestname() {
	return testname;
}
public void setTestname(String testname) {
	this.testname = testname;
}
public String getTestdate() {
	return testdate;
}
public void setTestdate(String testdate) {
	this.testdate = testdate;
}
public Integer getRoundno() {
	return roundno;
}
public void setRoundno(Integer roundno) {
	this.roundno = roundno;
}
public String getStart() {
	return start;
}
public void setStart(String start) {
	this.start = start;
}
public String getEnd() {
	return end;
}
public void setEnd(String end) {
	this.end = end;
}
  
  
  
  
  
  
}
