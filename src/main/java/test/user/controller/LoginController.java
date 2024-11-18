package test.user.controller;

import test.user.model.User;
import test.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 显示登录页面
     * @return 返回登录页面的视图
     */
    @GetMapping("/login")
    public String showLoginForm(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("error", "用户名或密码错误");
        }
        return "login";
    }

    /**
     * 处理登录请求
     * @param username 用户输入的用户名
     * @param password 用户输入的密码
     * @param model 用于传递数据到视图
     * @return 返回登录成功或失败的页面视图名称
     */
    @PostMapping("/login")
    public String loginUser(@RequestParam("username") String username,
                            @RequestParam("password") String password,
                            Model model) {
        System.out.println("尝试登录: " + username + " 密码: " + password);
        User user = userService.findByUsername(username);

        // 打印查找用户的信息
        if (user != null) {
            System.out.println("找到用户: " + user.getUsername() + ", 密码: " + user.getPassword());
        } else {
            System.out.println("用户不存在");
        }

        // 校验用户是否存在及密码是否正确（直接比较明文密码）
        if (user != null && password.equals(user.getPassword())) {
            model.addAttribute("user", user);
            return "welcome";
        } else {
            model.addAttribute("error", "用户名或密码错误");
            return "login";
        }
    }

    /**
     * 欢迎页面，仅允许认证用户访问
     * @return 返回欢迎页面的视图
     */
    @GetMapping("/welcome")
    @PreAuthorize("isAuthenticated()") // 确保用户已认证
    public String welcome(Model model) {
        return "welcome"; // 返回欢迎页面的视图
    }
}
