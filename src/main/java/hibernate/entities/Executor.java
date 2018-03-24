package hibernate.entities;

import javax.persistence.*;

@Entity
@Table(name = "EXECUTOR")
public class Executor {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EXEC_SEQ")
    @SequenceGenerator(name = "EXEC_SEQ", sequenceName = "EXEC_SEQ")
    @Column(name = "ID")
    @Id
    private int id;

    @Column(name = "NAME")
    private String name;

    public Executor() {
    }

    public Executor(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}