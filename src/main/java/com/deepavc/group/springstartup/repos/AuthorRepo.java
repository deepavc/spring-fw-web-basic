package com.deepavc.group.springstartup.repos;

import com.deepavc.group.springstartup.datamapping.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepo extends CrudRepository<Author, Long> {
}
