package com.neoteric.collections.collectionsnov.salarydetails;

import java.util.ArrayList;
import java.util.List;

public class NormalMethodTest {



        public static void main(String[] args) {
            Department testingDepartment = new Department();
            testingDepartment.setName("Testing Department");

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

            Department hrDepartment = new Department();
            hrDepartment.setName("HR Department");

            Employee siddu = new Employee();
            siddu.setEmployeeName("Siddu");
            siddu.setSalary(12000.0);
            siddu.setEmployeeId(3585);

            Employee vardhan = new Employee();
            vardhan.setEmployeeName("Vardhan");
            vardhan.setSalary(16000.0);
            vardhan.setEmployeeId(3088);

            Employee pranay = new Employee();
            pranay.setEmployeeName("Pranay");
            pranay.setSalary(30000.0);
            pranay.setEmployeeId(436868);

            hrDepartment.add(siddu);
            hrDepartment.add(vardhan);
            hrDepartment.add(pranay);

            Department financeDepartment = new Department();
            financeDepartment.setName("Finance Department");

            Employee sujit = new Employee();
            sujit.setEmployeeName("Sujit");
            sujit.setSalary(85000);
            sujit.setEmployeeId(508765);

            Employee suku = new Employee();
            suku.setEmployeeName("Suku");
            suku.setSalary(95000);
            suku.setEmployeeId(5087);

            Employee mahi = new Employee();
            mahi.setEmployeeName("Mahi");
            mahi.setSalary(90000);
            mahi.setEmployeeId(60986);

            financeDepartment.add(sujit);
            financeDepartment.add(suku);
            financeDepartment.add(mahi);

            List<Department> departments = new ArrayList<>();
            departments.add(testingDepartment);
            departments.add(hrDepartment);
            departments.add(financeDepartment);

            // Find the company-wide maximum salary employee
            Employee companyMaxSalaryEmployee = null;
            for (Department department : departments) {
                for (Employee employee : department.getEmployeeList()) {
                    if (companyMaxSalaryEmployee == null || employee.compareTo(companyMaxSalaryEmployee) > 0) {
                        companyMaxSalaryEmployee = employee;
                    }
                }
            }
            if (companyMaxSalaryEmployee != null) {
                System.out.println("Company-wide Max Salary: " + companyMaxSalaryEmployee);
            }

            // Find maximum salary employee in each department
            for (Department department : departments) {
                Employee maxSalaryEmployee = null;
                for (Employee employee : department.getEmployeeList()) {
                    if (maxSalaryEmployee == null || employee.compareTo(maxSalaryEmployee) > 0) {
                        maxSalaryEmployee = employee;
                    }
                }
                if (maxSalaryEmployee != null) {
                    System.out.println("Department: " + department.getName());
                    System.out.println("  Max Salary Employee: " + maxSalaryEmployee);
                }
            }

            // Find the company-wide minimum salary employee
            Employee companyMinSalaryEmployee = null;
            for (Department department : departments) {
                for (Employee employee : department.getEmployeeList()) {
                    if (companyMinSalaryEmployee == null || employee.compareTo(companyMinSalaryEmployee) < 0) {
                        companyMinSalaryEmployee = employee;
                    }
                }
            }
            if (companyMinSalaryEmployee != null) {
                System.out.println("Company-wide Minimum Salary: " + companyMinSalaryEmployee);
            }

            // Find minimum salary employee in each department
            for (Department department : departments) {
                Employee minSalaryEmployee = null;
                for (Employee employee : department.getEmployeeList()) {
                    if (minSalaryEmployee == null || employee.compareTo(minSalaryEmployee) < 0) {
                        minSalaryEmployee = employee;
                    }
                }
                if (minSalaryEmployee != null) {
                    System.out.println("Department: " + department.getName());
                    System.out.println("  Minimum Salary Employee: " + minSalaryEmployee);
                }
            }

            for (Department department : departments) {
                List<Employee> employeeList = department.getEmployeeList();
                double totalSalary = 0.0;
                for (Employee employee : employeeList) {
                    totalSalary += employee.getSalary();
                }
                double averageSalary = employeeList.size() > 0 ? totalSalary / employeeList.size() : 0.0;
                System.out.println("Department: " + department.getName());
                System.out.println("  Average Salary: " + averageSalary);
            }
        }
    }


