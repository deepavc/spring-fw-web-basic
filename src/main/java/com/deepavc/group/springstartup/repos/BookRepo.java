package com.deepavc.group.springstartup.repos;

import com.deepavc.group.springstartup.datamapping.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepo extends CrudRepository<Book,Long> {
}
