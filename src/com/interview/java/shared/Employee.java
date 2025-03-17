package com.interview.java.shared;


public class Employee {

	private  String name;
	private int empId;
	private int age;
	private int salary;
	private Department department;
	
	
	
	public Employee(String name, int empId, int age, int salary, Department department) {
		super();
		this.name = name;
		this.empId = empId;
		this.age = age;
		this.salary = salary;
		this.department = department;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", empId=" + empId + ", age=" + age + ", salary=" + salary + ", department="
				+ department + "]";
	}
	
	
	
}




