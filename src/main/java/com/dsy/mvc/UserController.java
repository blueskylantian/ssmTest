package com.dsy.mvc;

import com.dsy.entity.Borrow;
import com.dsy.entity.User;
import com.dsy.service.BorrowService;
import com.dsy.service.UserService;
import com.dsy.utils.EncryptUtils;
import com.dsy.utils.SendEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/**
 * Created by dsy on 2018/7/23
 * Package com.dsy.mvc
 */
@Controller
@Scope("prototype")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BorrowService borrowService;

    @RequestMapping(value = "login.do",method = RequestMethod.POST)
    public String  login(String username, HttpSession session){
        User user = userService.login(username);
        if (user!=null){
            session.setAttribute("user",user);
            session.setAttribute("username",username);
            return "index";
        }
        return "login";
    }


    @RequestMapping(value = "borrow.do",method = RequestMethod.GET)
    public String borrow(int bookid, HttpSession session, Model model){
        Borrow borrow = new Borrow();
        User user = (User) session.getAttribute("user");
        borrow.setUserid(user.getUserid());
        borrow.setBookid(bookid);
        borrow.setTime(new Date());
        borrowService.borrow(borrow);
        return "index";
    }

    @RequestMapping(value = "index.do")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "sign.do")
    public String toRegister(){
        return "register";
    }

    @RequestMapping(value = "tologin.do")
    public String toLogin(){
        return "login";
    }

    @RequestMapping(value = "logout.do")
    public String logout(HttpSession session){
        session.invalidate();
        return "login";
    }

    @RequestMapping(value = "register.do",method = RequestMethod.POST)
    public String register(String email){
        User user = new User();
        user.setUsername(email);
        Calendar c = Calendar.getInstance();
        //现在的时间(单位：毫秒)
        //TODO:时间换算问题，如何处理int和long之间的关系
        long time = c.getTimeInMillis();
        //创建激活码
        String token=EncryptUtils.encrypt(email+time);
        user.setCode(token);
        userService.register(user);
        String id= UUID.randomUUID().toString();
        //发送邮件
        ///邮件的内容
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        StringBuffer sb=new StringBuffer("<div style=\"width:660px;overflow:hidden;border-bottom:1px solid #bdbdbe;\">"+"<div style=\"padding:24px 20px;\">您好，"+email+"<br/><br/><br/><br/>请点击下面链接激活账号，24小时生效，否则重新注册账号，链接只能使用一次，请尽快激活！</br>");
        sb.append("<a href=\"http://localhost:8080/user/update.do?");
        sb.append("code=");
        sb.append(token);
        sb.append("\">http://localhost:8080/user/update.do?");
        sb.append("code=");
        sb.append(token);
        sb.append("</a>"+"<br/>如果以上链接无法点击，请把上面网页地址复制到浏览器地址栏中打开<br/><br/><br/>，专注兴趣，分享创作<br/>"+sdf.format(new Date())+ "</div></div>" );
        //发送邮件
        SendEmail.send(email, sb.toString());
        return "login";
    }

    @RequestMapping(value = "update.do",method = RequestMethod.GET)
    public String updateState(String code){
        User user = userService.findByCode(code);
        userService.updateState(user);
        return "login";
    }

}
