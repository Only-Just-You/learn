package org.example.dao;

import org.example.pojo.Content;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentMapper {
    List<Content> queryAll();
}
