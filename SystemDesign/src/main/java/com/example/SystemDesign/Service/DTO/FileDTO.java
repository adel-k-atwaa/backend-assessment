package com.example.SystemDesign.Service.DTO;

import com.example.SystemDesign.Domain.Item;
import jakarta.validation.constraints.NotEmpty;

import java.io.Serializable;

public class FileDTO implements Serializable {
    private Long fileId;
    @NotEmpty
    private byte[] binary;


    @NotEmpty
    private Item item;

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public byte[] getBinary() {
        return binary;
    }

    public void setBinary(byte[] binary) {
        this.binary = binary;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
