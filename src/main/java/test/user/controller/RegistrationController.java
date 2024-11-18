package test.user.controller;

import test.user.model.User;
import test.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * RegistrationController 类负责处理用户注册请求
 */
@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    /**
     * 显示注册页面
     * @return 返回注册页面的视图名称
     */
    @GetMapping("/register")
    public String showRegistrationForm() {
        return "registration"; // 返回 registration.html 模板
    }

    /**
     * 处理注册请求
     * @param username 用户输入的用户名
     * @param password 用户输入的密码
     * @param email 用户输入的电子邮件
     * @param model 用于传递数据到视图
     * @return 返回注册成功或失败的页面视图名称
     */
    @PostMapping("/register")
    public String registerUser(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               @RequestParam("email") String email,
                               Model model) {
        // 检查用户名是否已存在
        if (userService.findByUsername(username) != null) {
            model.addAttribute("error", "用户名已被使用"); // 返回错误信息
            return "registration"; // 返回注册页面
        }

        // 创建新的用户对象
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password); // 存储明文密码
        newUser.setEmail(email);

        userService.save(newUser); // 保存用户到数据库
        model.addAttribute("message", "注册成功，请登录"); // 注册成功消息
        return "registration"; // 返回注册页面，显示成功消息
    }
}
