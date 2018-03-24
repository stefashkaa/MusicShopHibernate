package hibernate.entities;

import javax.persistence.*;

@Entity
@Table(name = "COMPOSITION")
public class Composition {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMP_SEQ")
    @SequenceGenerator(name = "COMP_SEQ", sequenceName = "COMP_SEQ")
    @Column(name = "ID")
    @Id
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "LENGTH")
    private int length;

    @ManyToOne(fetch = FetchType.LAZY)
    private Album album;

    public Composition() {
    }

    public Composition(String name, Integer length, Album album) {
        this.name = name;
        this.length = length;
        this.album = album;
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

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}