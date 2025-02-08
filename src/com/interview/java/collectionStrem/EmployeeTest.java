package com.interview.java.collectionStrem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeTest{
	public static void main(String[] args) {
		
		List<Employee> employee = new ArrayList<>();
		employee.add(new Employee("Amit", 101, 23, 100000, new Department("AMD", 1, 101)));
		employee.add(new Employee("Rahul", 102, 33, 88000, new Department("CMD", 2, 102)));
		employee.add(new Employee("Btech", 103, 27, 93000, new Department("IVS", 3, 103)));
		employee.add(new Employee("Parth", 104, 38, 957000, new Department("CIS", 4, 104)));
		employee.add(new Employee("Rudra", 105, 40, 70000, new Department("IT", 5, 105)));
		employee.add(new Employee("Yuvi", 105, 44, 89000, new Department("CCD", 6, 106)));
		employee.add(new Employee("Nano", 107, 55, 55500, new Department("FEDEX", 7, 107)));
		employee.add(new Employee("Fano", 108, 22, 40440, new Department("HTAMD", 8, 108)));
		
		
//		employee.stream().forEach(System.out::println);
		
		
		// find the employee by name
		
		employee.stream().filter(emp->emp.getName().equals("Rahul")).forEach(System.out::println);
		Optional<Employee> em=employee.stream().filter(emp->emp.getName().equals("Rahul")).findAny(); // it will find any emp
		
		if(em.isPresent())
		{
			System.out.println("Employee Found :"+em.get());
		}
		
		// Support ion java 9
		em.ifPresentOrElse(e->System.out.println(e.getAge()), ()->System.out.println("Employee not found"));
		
		
		// Sort the employee by name
		
		List<Employee> naturalSortedEmp=employee.stream().sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
		List<Employee> naturalSortedEmpID=employee.stream().sorted(Comparator.comparing(Employee::getEmpId)).collect(Collectors.toList());
		
		System.out.println("------------------------------------------------------------------------------------------");
		naturalSortedEmp.forEach(System.out::println);
		System.out.println("------------------------------------------------------------------------------------------");
		naturalSortedEmpID.forEach(System.out::println);
		System.out.println("------------------------------------------------------------------------------------------");
		
		// Sorted by Employee name and empID
		
		List<Employee> sortedEmployeeByNameAndId= employee.stream().sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getEmpId)).collect(Collectors.toList());
		sortedEmployeeByNameAndId.forEach(System.out::println);
		System.out.println("------------------------------------------------------------------------------------------");
		
		// find the 3rd highest salary from the list
		
		Optional<Employee> emp=employee.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(2).findFirst();
	
		if(emp.isPresent()){
			System.out.println(emp.get());
		}else {
			System.out.println("No emp found");
		}
	}
}



class Employee {

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



class Department{
	
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


