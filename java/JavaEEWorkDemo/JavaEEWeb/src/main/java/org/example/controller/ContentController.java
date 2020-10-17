package org.example.controller;

import org.example.pojo.Content;
import org.example.service.ContentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ContentController {
    private ContentService contentService;
    @RequestMapping(value = "/index.ftl", method = RequestMethod.GET)
    @ResponseBody
    public List<Content> showProducts(){
        return contentService.show();
    }

}
