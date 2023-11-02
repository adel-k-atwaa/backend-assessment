package com.example.SystemDesign.Repository;

import com.example.SystemDesign.Domain.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File,Long> {

}
