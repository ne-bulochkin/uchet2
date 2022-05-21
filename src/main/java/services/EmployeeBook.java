package services;

import lombok.Getter;
import models.Employee;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Getter
public class EmployeeBook {
    private static final int DEFAULT_ENTITIES = 3;

    private Employee[] employees = new Employee[DEFAULT_ENTITIES];

    public void addEmployee(Employee employee){
        for(int i = 0; i < employees.length; i++){
            // проверяем не был ли ранее такой сотрудник добавлен
            for(Employee new_employee : employees){
                if(employee.equals(new_employee)){
                    throw new IllegalArgumentException("Такой сотрудник уже зарегестрирован в системе!");
                }
            }

            //теперь ищем пусток
            if(employees[i] == null){
                employees[i] = employee;
                break;
            } else if (i==employees.length-1){
                // если добавляем сотрудника, но в массиве нема места, то создаем новый с увеличенным размером на +5
                Employee[] new_employees = new Employee[employees.length+5];
                for(int j = 0; j < employees.length; j++){
                    new_employees[j]=employees[j];
                }
                employees = new_employees;
                employees[i+1]=employee;
                break;
            }
        }
    }

    public void deleteEmployeeById(int id){
        if(id < 0 || id > employees.length-1){
            throw new IllegalArgumentException("Не найден сотрудник с указанным id");
        } else {
            employees[id] = null;
        }
    }

    public void deleteEmployeeByName(String firstName, String lastName, String middleName){
        Employee employee = Employee.builder()
                .firstName(firstName)
                .lastName(lastName)
                .middleName(middleName)
                .department("skip")
                .salary(0).build();
        for(int i = 0; i< employees.length; i++){
            if(employees[i]!=null && employees[i].equals(employee)){
                employees[i]=null;
                break;
            } else if(i == employees.length-1){
                throw new IllegalArgumentException("Сотрудник по ФИО = " + employee.toString() + "не найден!");
            }
        }
    }

    public void changeDepartment(String firstName, String lastName, String middleName, String newDepartment){
        Employee employee = Employee.builder()
                .firstName(firstName)
                .lastName(lastName)
                .middleName(middleName)
                .department("skip")
                .salary(0).build();
        for(int i = 0; i< employees.length; i++){
            if(employees[i]!=null && employees[i].equals(employee)){
                employees[i].setDepartment(newDepartment);
                break;
            } else if(i == employees.length-1){
                throw new IllegalArgumentException("Сотрудник по ФИО = " + employee.toString() + "не найден!");
            }
        }
    }

    public void changeSalary(String firstName, String lastName, String middleName, int newSalary){

        if(newSalary<0){
            throw new IllegalArgumentException("Зарплата не может быть меньше 0");
        }
        Employee employee = Employee.builder()
                .firstName(firstName)
                .lastName(lastName)
                .middleName(middleName)
                .department("skip")
                .salary(0).build();

        for(int i = 0; i< employees.length; i++){
            if(employees[i]!=null && employees[i].equals(employee)){
                employees[i].setSalary(newSalary);
                break;
            } else if(i == employees.length-1){
                throw new IllegalArgumentException("Сотрудник по ФИО = " + employee.toString() + "не найден!");
            }
        }
    }

    public void getListByDepartment(){
        //ищем департаменты которые вообще возможны
        Set<String> departments = new HashSet<>();
        for(Employee employee : employees){
            if(employee!=null){
                departments.add(employee.getDepartment());
            }
        }

        for(String department: departments){
            System.out.println(department+":");

            for(Employee employee : employees){
                if(employee!=null){
                    if (employee.getDepartment().equals(department)){
                        System.out.println(employee.toStringLastFirstMiddleNames());
                    }
                }
            }
        }



    }

}
