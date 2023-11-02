package com.example.SystemDesign.Domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

public interface ItemChildes {

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    List<Item> childes = new ArrayList<>();
}
