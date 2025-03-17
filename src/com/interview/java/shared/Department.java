package com.interview.java.shared;

public class Department{
	
	private String name;
	private int deptId;
	private int empId;
	
	public Department(String name, int deptId, int empId) {
		super();
		this.name = name;
		this.deptId = deptId;
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	@Override
	public String toString() {
		return "Department [name=" + name + ", deptId=" + deptId + ", empId=" + empId + "]";
	}
	
	
	
}