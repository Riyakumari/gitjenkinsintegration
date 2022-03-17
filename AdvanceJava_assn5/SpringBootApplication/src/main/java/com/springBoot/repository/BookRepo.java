package com.springBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.springBoot.model.BookList;

public interface BookRepo extends JpaRepository<BookList, Integer>{

}
