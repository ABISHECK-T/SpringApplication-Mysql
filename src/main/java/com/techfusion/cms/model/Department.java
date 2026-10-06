package com.techfusion.cms.model;

public class Department {
	private Integer departmentId;
	private String  departnemtCode;
	private String departmentName;
	public Department() {
		
	}
	public Department(Integer departmentId, String departnemtCode, String departmentName) {
		super();
		this.departmentId = departmentId;
		this.departnemtCode = departnemtCode;
		this.departmentName = departmentName;
	}
	public Integer getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartnemtCode() {
		return departnemtCode;
	}
	public void setDepartnemtCode(String departnemtCode) {
		this.departnemtCode = departnemtCode;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	@Override
	public String toString() {
		return "department [departmentId=" + departmentId + ", departnemtCode=" + departnemtCode + ", departmentName="
				+ departmentName + "]";
	}
}
