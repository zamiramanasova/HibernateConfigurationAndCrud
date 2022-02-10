package peaksoft.entity;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String name;
    private String lastName;
    private String profession;
    private int age;

    public Employee() {
    }

    public Employee(String name, String lastName, String profession, int age) {
        this.name = name;
        this.lastName = lastName;
        this.profession = profession;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Работник : " +
                "id=" + id +
                ", имя ='" + name + '\'' +
                ", фамилия ='" + lastName + '\'' +
                ", профессия = " + profession + '\'' +
                ", возраст =" + age +
                '}';
    }
}
