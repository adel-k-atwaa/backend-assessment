package com.example.SystemDesign.Service.DTO;

import com.example.SystemDesign.Domain.Item;
import com.example.SystemDesign.Domain.Type;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public class FolderItemDTO extends ItemDTO implements Serializable {

    @NotEmpty
    private Item parent;

    private final Type type = Type.Folder;

    public Item getParent() {
        return parent;
    }

    public void setParent(Item parent) {
        this.parent = parent;
    }

    @Override
    public void setType(Type type) {
//        super.setType(type);
        throw new RuntimeException("Can't change type");
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "FolderItemDTO{" +
                "name="+this.getName()+
                ",parent=" + parent +
                ", type=" + type +
                ",group="+this.getGroup()+
                '}';
    }
}
