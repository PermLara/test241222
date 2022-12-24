package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "usertest")
public class UserTest {

    public static int count;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    public UserTest() {
        count++;
        System.out.println("из конструктора UserTest count= " + count);
    }

    public UserTest(String name) {
        this.name = name;
        count++;
        System.out.println("из конструктора UserTest count= " + count + "name=" + name);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserTest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
