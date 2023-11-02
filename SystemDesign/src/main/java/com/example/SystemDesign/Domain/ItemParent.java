package com.example.SystemDesign.Domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

public interface ItemParent {
    @ManyToOne
    @JoinColumn(name = "parent_id",referencedColumnName = "id")
    Item parent = new Item();

    Item getParent();

    void setParent(Item item);
}
