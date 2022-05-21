import models.Employee;
import services.EmployeeBook;

import java.util.ArrayList;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        // тут есть и + и - использования билдера. Плюс в том, что всё красиво, минус в том, что я не знаю, как
        // передать свой экспешн, в анноташку nonNull, если вдруу поле пустое. На проде, я бы делал try catch при создании
        // employee и там ловил exception, но не хочется тут много писать.
        Employee employee1 = Employee.builder()
                .firstName("Андрей")
                .lastName("Буланов")
                .middleName("Викторович")
                .department("DEV")
                .salary(29988).build();
        Employee employee2 = Employee.builder()
                .firstName("Олег")
                .lastName("Иванов")
                .middleName("Котикович")
                .department("DEV")
                .salary(10000).build();
        Employee employee3 = Employee.builder()
                .firstName("Илман")
                .lastName("Асламбек")
                .middleName("Катарович")
                .department("DBA")
                .salary(100000).build();

        Employee employee4 = Employee.builder()
                .firstName("Иван")
                .lastName("Каликов")
                .middleName("Бестабакович")
                .department("QA")
                .salary(199).build();

        Employee employee5 = Employee.builder()
                .firstName("Катя")
                .lastName("Котикова")
                .middleName("Псиновичивна")
                .department("DBA")
                .salary(199).build();


        EmployeeBook employeeBook = new EmployeeBook();
        employeeBook.addEmployee(employee1);
        employeeBook.addEmployee(employee2);
        employeeBook.addEmployee(employee3);
        employeeBook.addEmployee(employee4);
        employeeBook.addEmployee(employee5);

        employeeBook.deleteEmployeeByName("Иван","Каликов", "Бестабакович");
        employeeBook.changeDepartment("Илман","Асламбек", "Катарович","NOSQLDB");
        employeeBook.changeSalary("Илман","Асламбек", "Катарович",1000000);

        employeeBook.getListByDepartment();

    }
}
