package com.company._6_transform;

public class EmployeeVO {
	private Long eid;
	private String ename;
	private Long did;
	private String dname;

	public EmployeeVO(Long eid, String ename, Long did, String dname) {
		this.eid = eid;
		this.ename = ename;
		this.did = did;
		this.dname = dname;
		
	}

	public Long getEid() {
		return eid;
	}

	public void setEid(Long eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Long getDid() {
		return did;
	}

	public void setDid(Long did) {
		this.did = did;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	@Override
	public String toString() {
		return "EmployeeVO [eid=" + eid + ", ename=" + ename + ", did=" + did + ", dname=" + dname + "]";
	}

}
