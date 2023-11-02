package com.example.SystemDesign.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

//@Entity
//@Table(name = "item")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(unique = true,nullable = false)
    private String name;


    @ManyToOne
    @JoinColumn(name = "permission_group_id")
    @JsonIgnoreProperties(value = {"items"},allowSetters = true)
    private Group group;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    @JsonIgnore
    private Item parent;

    @OneToMany(mappedBy = "parent")
    @JsonIgnoreProperties(value = {"childes"})
    @JsonIgnore
    private List<Item> childes;

    @OneToOne(mappedBy = "item",cascade = CascadeType.ALL)
    private File file;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Group getGroup() {
        return group;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void setParent(Item parent) {
        this.parent = parent;
    }

    public void setChildes(List<Item> childes) {
        this.childes = childes;
    }

    public Item getParent() {
        return parent;
    }

    public List<Item> getChildes() {
        return childes;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", group=" + group +
                ", parent=" + parent +
                ", childes=" + childes +
                '}';
    }
}
