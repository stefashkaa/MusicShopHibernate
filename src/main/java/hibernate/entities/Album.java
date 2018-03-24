package hibernate.entities;

import javax.persistence.*;

@Entity
@Table(name = "album")
public class Album {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ALBUM_SEQ")
    @SequenceGenerator(name = "ALBUM_SEQ", sequenceName = "ALBUM_SEQ")
    @Column(name = "ID")
    @Id
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "GENRE")
    private String genre;

    @ManyToOne(fetch = FetchType.LAZY)
    private Executor executor;

    public Album() {
    }

    public Album(String name, String genre, Executor executor) {
        this.name = name;
        this.genre = genre;
        this.executor = executor;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Executor getExecutor() {
        return executor;
    }

    public void setPerformer(Executor executor) {
        this.executor = executor;
    }
}