package org.example.service.impl;

import org.example.dao.ContentMapper;
import org.example.pojo.Content;
import org.example.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    private ContentMapper contentMapper;
    @Override
    public List<Content> show() {
        return contentMapper.queryAll();
    }
}
