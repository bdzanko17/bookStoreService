package com.example.book;
import javax.persistence.*;
import java.io.Serializable;

@Entity
public class AAAA implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String Ime;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public AAAA() {
    }

    public AAAA( String ime) {
        Ime = ime;
    }

    public String getIme() {
        return Ime;
    }

    public void setIme(String ime) {
        Ime = ime;
    }
}
