package com.spring.library.dao;

import com.spring.library.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Integer> {

    public List<Library> findAllByOrderByBookTitleAsc();

}


