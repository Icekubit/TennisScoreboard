package io.diegogarcia.icekubit.models;


import jakarta.persistence.*;

@Entity
@Table(name = "hello_world")
public class HelloWorldEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "message")
    private String message;

    public HelloWorldEntity() {}

    public HelloWorldEntity(String message) {
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "HelloWorldEntity{" +
                "id=" + id +
                ", message='" + message + '\'' +
                '}';
    }
}