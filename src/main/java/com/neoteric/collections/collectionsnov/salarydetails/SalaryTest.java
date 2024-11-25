package com.neoteric.collections.collectionsnov.salarydetails;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class SalaryTest {


        public static void main(String[] args) {

            Department testingDepartment = new Department();
            testingDepartment.setName(" testingDepartment ");

            Employee kk = new Employee();
            kk.setEmployeeName("KK");
            kk.setSalary(10000.0);
            kk.setEmployeeId(1455);
            Employee kk1 = new Employee();
            kk1.setEmployeeName("KK");
            kk1.setSalary(5000.0);
            kk1.setEmployeeId(45632);

            Employee kumar = new Employee();
            kumar.setEmployeeName("Kumar");
            kumar.setSalary(40000.0);
            kumar.setEmployeeId(26788);

            testingDepartment.add(kk);
            testingDepartment.add(kk1);
            testingDepartment.add(kumar);

            Department hrDeaprtment = new Department();
            hrDeaprtment.setName(" HR Deaprtment ");

            Employee siddu = new Employee();
            siddu.setEmployeeName("siddu");
            siddu.setSalary(12000.0);
            siddu.setEmployeeId(3585);

            Employee vardhan = new Employee();
            vardhan.setEmployeeName("vardhan");
            vardhan.setSalary(16000.0);
            vardhan.setEmployeeId(3088);


            Employee pranay = new Employee();
            pranay.setEmployeeName("pranay");
            pranay.setSalary(30000.0);
            pranay.setEmployeeId(436868);

            hrDeaprtment.add(siddu);
            hrDeaprtment.add(vardhan);
            hrDeaprtment.add(pranay);


            Department financeDeaprtment = new Department();
            financeDeaprtment.setName("Finance Department");

            Employee sujit = new Employee();
            sujit.setEmployeeName("sujit");
            sujit.setSalary(85000);
            sujit.setEmployeeId(508765);

            Employee suku = new Employee();
            suku.setEmployeeName("suku");
            suku.setSalary(95000);
            suku.setEmployeeId(5087);

            Employee mahi = new Employee();
            mahi.setEmployeeName("mahi");
            mahi.setSalary(90000);
            mahi.setEmployeeId(60986);

            financeDeaprtment.add(sujit);
            financeDeaprtment.add(suku);
            financeDeaprtment.add(mahi);

            List<Department> departments = new ArrayList<>();
            departments.add(testingDepartment);
            departments.add(hrDeaprtment);
            departments.add(financeDeaprtment);


          //  List<String> empidlist=departments.stream().map(Department::getEmployeeList).collect(Collectors.toList());

           // Map<String,List<Employee>> departmentmap=departments.stream().collect(groupingby(Department::))
            Optional<Employee> companyMaxSalaryEmployee = departments.stream()
                    .flatMap(department -> department.getEmployeeList().stream())
                    .max((o1, o2) -> o1.compareTo(o2));

            companyMaxSalaryEmployee.ifPresent(employee ->
                    System.out.println("Company-wide Max Salary: " + employee));


            departments.forEach(department -> {
                Optional<Employee> maxSalaryEmployee = department.getEmployeeList().stream()
                        .max((o1, o2) -> o1.compareTo(o2));

                maxSalaryEmployee.ifPresent(employee -> {
                    System.out.println("Department: " + department.getName());
                    System.out.println("  Max Salary Employee: " + employee);
                });
            });



            Optional<Employee> companyMaxSalaryEmployee1 = departments.stream()
                    .flatMap(department -> department.getEmployeeList().stream())
                    .min((o1, o2) -> o1.compareTo(o2));

            companyMaxSalaryEmployee1.ifPresent(employee ->
                    System.out.println("Company minimum  Salary: " + employee));

            departments.forEach(department -> {
                Optional<Employee> maxSalaryEmployee = department.getEmployeeList().stream()
                        .min((o1, o2) -> o1.compareTo(o2));

                maxSalaryEmployee.ifPresent(employee -> {
                    System.out.println("Department: " + department.getName());
                    System.out.println("  minimum Salary Employee: " + employee);
                });
            });

            Map<String, Double> averageSalaries = departments.stream()
                    .collect(Collectors.toMap(
                            Department::getName, // Department name as the key
                            department -> department.getEmployeeList().stream()
                                    .collect(Collectors.averagingDouble(Employee::getSalary)) // Average salary calculation
                    ));

            // Print the results
            averageSalaries.forEach((departmentName, avgSalary) -> {
                System.out.println("Department: " + departmentName);
                System.out.println("  Average Salary: " + avgSalary);
            });
        }
    }

