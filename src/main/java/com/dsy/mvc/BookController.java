package com.dsy.mvc;

import com.dsy.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by dsy on 2018/7/23
 * Package com.dsy.mvc
 */
@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "likeSearch.do",method = {RequestMethod.POST,RequestMethod.GET})
    public String findByKeyWords(String key, @RequestParam(value = "page",defaultValue = "1",required = false) Integer page, Model model){
        model.addAttribute("pageBean",bookService.findByKey(key,page));
        model.addAttribute("key",key);
        return "index";
    }

}
