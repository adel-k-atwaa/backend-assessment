package com.example.SystemDesign.Service.DTO;

import com.example.SystemDesign.Domain.File;
import com.example.SystemDesign.Domain.Group;
import com.example.SystemDesign.Domain.Item;
import com.example.SystemDesign.Domain.Type;

import java.util.List;

public class ItemDTO {

    private Long id;

    private Type type;

    private String name;
    private Group group;

    private Item parent;

    private List<Item> childes;

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

    public void setName(String name) {
        this.name = name;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Item getParent() {
        return parent;
    }

    public void setParent(Item parent) {
        this.parent = parent;
    }

    public List<Item> getChildes() {
        return childes;
    }

    public void setChildes(List<Item> childes) {
        this.childes = childes;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
