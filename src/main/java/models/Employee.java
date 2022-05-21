package models;

import lombok.*;
import java.util.Objects;

@Builder
@Setter
@Getter
public class Employee {
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String middleName;
    @NonNull
    private String department;
    @NonNull
    private int salary;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(middleName, employee.middleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, middleName);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }

    public String toStringLastFirstMiddleNames() {
        return firstName + ' ' + lastName + ' ' + middleName;
    }
}
