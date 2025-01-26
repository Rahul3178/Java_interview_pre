package com.interview.java.streamapi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class InterviewQuestions3 {

	public static void main(String[] args) {

		List<Employee> employeeList = new ArrayList<Employee>();

		employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

		new InterviewQuestions3();
		/*
		 * 1. Find out the count of male and female employees present in the
		 * organization?
		 */
		InterviewQuestions3.getCountMaleAndFemale(employeeList);

		/*
		 * 2. Write a program to print the names of all departments in the organization.
		 */
		InterviewQuestions3.getNoOfDepartinCompany(employeeList);

		/*
		 * 3. Find the average age of Male and Female Employees.
		 */

		InterviewQuestions3.getAvergeAgeOfMaleAndFemale(employeeList);

		/*
		 * 4. Get the Names of employees who joined after 2015.
		 * 
		 */
		InterviewQuestions3.getAgeOfEmployee(employeeList);
		
		
		/*
		 * 5. Count the number of employees in each department.
		 */
		
		
		InterviewQuestions3.countByDept(employeeList);
		
		
		/*
		 * 6. Find out the average salary of each department.
		 */
		InterviewQuestions3.avgSalary(employeeList);
		
		
		/*
		 * 7. Find out the oldest employee, his/her age and department?
		 */
		
		InterviewQuestions3.oldestEmp(employeeList);
		
		
		/*
		 * 8. Find out the average and total salary of the organization.
		 */
			InterviewQuestions3.getEmpSalaryByAverage(employeeList);
			
		/*
		 * 9. List down the employees of each department.	
		 */
			InterviewQuestions3.listDownDept(employeeList);
			
		/*
		 * 10. Find out the highest experienced employees in the organization	
		 */
			InterviewQuestions3.seniorEmp(employeeList);
	}

	public static void getCountMaleAndFemale(List<Employee> employee) {
		Map<String, Long> result = employee.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		result.forEach((gender, counting) -> System.out.printf("Gender : %s  and number : %s \n", gender, counting));
	}

	public static void getNoOfDepartinCompany(List<Employee> employee) {
		employee.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);
	}

	public static void getAvergeAgeOfMaleAndFemale(List<Employee> employee) {
		Map<String, Double> result = employee.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
		result.forEach((gender, age) -> System.out.printf("Gender : %s  and average of age : %s \n", gender, age));
	}

	public static void getAgeOfEmployee(List<Employee> employee) {
		employee.stream().filter(e -> e.getYearOfJoining() > 2015).map(Employee::getName).forEach(System.out::println);
		// get the name of employee who joined on same date

		Map<Integer, Long> result = employee.stream()
				.collect(Collectors.groupingBy(Employee::getYearOfJoining, Collectors.counting()));
		result.forEach((doj, no) -> System.out.printf("Date of Joining : %s  and No of people : %s \n", doj, no));

		Map<Integer, List<String>> peoples = employee.stream().collect(Collectors.groupingBy(Employee::getYearOfJoining,
				Collectors.mapping(Employee::getName, Collectors.toList())));
		peoples.forEach((doj, no) -> System.out.printf("Date of Joining : %s  and Name : %s \n", doj, no));

	}
	
	
	public static void countByDept(List<Employee> employee) {
		Map<String, Long> result= employee.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
	
		result.forEach((department, no) -> System.out.printf("Department : %s  people : %d \n", department, no));
	}
	
	
	 public static void avgSalary(List<Employee> employeeList) {
		 Map<String,Double> result= employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));
//		 result.forEach((department, avgSalary) -> System.out.printf("Department : %s  Average Salary : %f \n", department,avgSalary));
		 
		 
		 
		 System.out.println("\n");
		 
		Set<Entry<String,Double>> entryset=result.entrySet();
		System.out.println("Unique department");
		entryset.stream().distinct().forEach(System.out::println);
		
		System.out.println("\n");
		/*
		 * for(Entry<String,Double> entry:entryset) {
		 * System.out.printf("Department : %s  Average Salary : %f \n",
		 * entry.getKey(),entry.getValue()); }
		 */
	 }
	 
	 
	 public static void oldestEmp(List<Employee> employeeList) {
		 
		Employee old= employeeList.stream().max(Comparator.comparingInt(Employee::getAge)).get();
		
		System.out.println("Oldest Employee of the organisation : "+old);
	 
	 }
	
	 public static void getEmpSalaryByAverage(List<Employee> employeeList) {
		 
	 DoubleSummaryStatistics result	 = employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
	 System.out.println(result);
	 System.out.println(result.getAverage());
	 System.out.println(result.getMin());
	 System.out.println(result.getMax());
	 	
	 }
	
	
	 public static void listDownDept(List<Employee> employeeList) {
		 Map<String,List<String>> result=employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.mapping(Employee::getName, Collectors.toList())));
		 result.forEach((department,names)->System.out.printf("Department : %s  Name: %s \n", department,names));
	 
	 }
	
	
	 public static void seniorEmp(List<Employee> employeeList) {
		Employee e= employeeList.stream().sorted(Comparator.comparingInt(Employee::getYearOfJoining)).findFirst().get();
		System.out.println("Highest Experience person in the the Organisation : "+e);
	 }
	
	
	
	
	
	
}

class Employee {

	int id;
	String name;
	int age;
	String gender;
	String department;
	int yearOfJoining;
	double salary;

	public Employee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.department = department;
		this.yearOfJoining = yearOfJoining;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}

	public String getDepartment() {
		return department;
	}

	public int getYearOfJoining() {
		return yearOfJoining;
	}

	public double getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		return "Id : " + id + ", Name : " + name + ", age : " + age + ", Gender : " + gender + ", Department : "
				+ department + ", Year Of Joining : " + yearOfJoining + ", Salary : " + salary;
	}

}