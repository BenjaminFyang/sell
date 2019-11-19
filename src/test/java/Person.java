import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Fy
 * Date: 2018-02-24
 * Time: 16:44
 */
@Data
public class Person {
    private String firstName, lastName, job, gender;
    private int salary, age;

    public Person(String firstName, String lastName, String job, String gender, int salary, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.job = job;
        this.gender = gender;
        this.salary = salary;
        this.age = age;
    }
}
