package com.example.SystemDesign.Service.DTO;

import com.example.SystemDesign.Domain.File;
import com.example.SystemDesign.Domain.Item;
import com.example.SystemDesign.Domain.Type;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public class FileItemDTO extends ItemDTO implements Serializable {

    private final Type type = Type.File;

    @NotNull
    @NotEmpty
    private File file;

    @NotNull
    @NotEmpty
    private Item parent;

    @Override
    public void setType(Type type) {
//        super.setType(type);
        throw new RuntimeException("Can't change type");
    }

    @Override
    public Type getType() {
        return type;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public Item getParent() {
        return parent;
    }

    @Override
    public void setParent(Item parent) {
        this.parent = parent;
    }
}
