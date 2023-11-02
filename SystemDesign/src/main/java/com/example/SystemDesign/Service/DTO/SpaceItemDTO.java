package com.example.SystemDesign.Service.DTO;

import com.example.SystemDesign.Domain.Type;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;


public class SpaceItemDTO extends ItemDTO implements Serializable {

    private final Type type = Type.Space;

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
        return "SpaceItemDTO{" +
                "name="+this.getName()+
                ",type=" + type +
                ",group="+this.getGroup()+
                '}';
    }
}
