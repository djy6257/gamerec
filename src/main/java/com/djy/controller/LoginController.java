package com.djy.controller;

import com.djy.codeutil.IVerifyCodeGen;
import com.djy.codeutil.SimpleCharVerifyCodeGenImpl;
import com.djy.codeutil.VerifyCode;
import com.djy.po.User;
import com.djy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class LoginController {

    @Autowired
     private UserService userService;

    /**
     * 获取验证码
     * @param request
     * @param response
     */
    @RequestMapping("/verifyCode")
    public void verifyCode(HttpServletRequest request, HttpServletResponse response) {
        IVerifyCodeGen iVerifyCodeGen = new SimpleCharVerifyCodeGenImpl();
        try {
            //设置长宽
            VerifyCode verifyCode = iVerifyCodeGen.generate(80, 28);
            String code = verifyCode.getCode();
//            LOGGER.info(code);
            //将VerifyCode绑定session
            request.getSession().setAttribute("VerifyCode", code);
            //设置响应头
            response.setHeader("Pragma", "no-cache");
            //设置响应头
            response.setHeader("Cache-Control", "no-cache");
            //在代理服务器端防止缓冲
            response.setDateHeader("Expires", 0);
            //设置响应内容类型
            response.setContentType("image/jpeg");
            response.getOutputStream().write(verifyCode.getImgBytes());
            response.getOutputStream().flush();
        } catch (IOException e) {
//            LOGGER.info("", e);
            System.out.println("异常处理");
        }
    }

    /**
     * 登录页面菜单映射
     */
    @RequestMapping("/login")
    public String login(){
        return "page/login";
    }

    @RequestMapping("/loginIn")
    public String loginIndex(HttpServletRequest request, Model model){
        //获取数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String captcha = request.getParameter("captcha");

        //验证登录是否超时
        HttpSession session = request.getSession();
        if(session==null){
            model.addAttribute("msg", "超时");
            return "page/login";
        }

        //获取真正的验证码
        String trueCaptcha = (String) session.getAttribute("VerifyCode");
        //判断验证码真实性，不区分大小写
        if(!( trueCaptcha.toLowerCase().equals(captcha.toLowerCase()))){
            model.addAttribute("msg", "验证码错误");
            return "page/login";
        }

        //判断用户名和密码是否正确
        User user = userService.loginVerify(username, password);
        if(user==null){
            model.addAttribute("msg", "用户名或密码错误");
            return "page/login";
        }
        session.setAttribute("user", user);
        return "redirect:index";
    }


    /**
     * 退出功能
     */
    @RequestMapping("/logOut")
    public String logOut(HttpServletRequest request){
        HttpSession session = request.getSession();
        //清除session
        session.invalidate();
        return "redirect:/login";
    }


}
