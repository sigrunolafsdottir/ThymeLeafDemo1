package com.example.demo.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Present implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;

    //om man vill ha en bidirectional manyToMany
  //  @ManyToMany(mappedBy="wishes")
 //   private List<Child> children;

    public Present(){}

    public Present(String name) {
        this.name = name;
    }

    public Present(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
/*
    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }
    */

}
