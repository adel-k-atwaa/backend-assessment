package com.example.SystemDesign.Repository;


import com.example.SystemDesign.Domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long> {
}
