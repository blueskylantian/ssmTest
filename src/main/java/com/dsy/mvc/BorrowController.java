package com.dsy.mvc;

import com.dsy.entity.User;
import com.dsy.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Created by dsy on 2018/7/25
 * Package com.dsy.mvc
 */
@Controller
@Scope("prototype")
@RequestMapping("/borrow")
public class BorrowController {

    @Autowired
    private BorrowService borrowService;

    @RequestMapping(value = "myBorrow.do",method = RequestMethod.GET)
    public String findBorrowByUserId(HttpSession session, Model model,@RequestParam(value = "page",defaultValue = "1",required = false) Integer page){
        User user = (User) session.getAttribute("user");
        model.addAttribute("pageBean",borrowService.findBorrowsByUserIdByPage(user.getUserid(),page));
        return "myBorrow";
    }

    @RequestMapping(value = "index.do",method = RequestMethod.GET)
    public String retuenIndex(){
        return "index";
    }

    @RequestMapping(value = "return.do",method = RequestMethod.GET)
    public String returnBook(Integer borrowid){
        borrowService.returnBook(borrowid);
        return "myBorrow";
    }
}
