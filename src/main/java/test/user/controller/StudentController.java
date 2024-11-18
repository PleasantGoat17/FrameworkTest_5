package test.user.controller;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import test.user.model.Student;
import test.user.service.StudentService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    private final int pageSize = 10; // 设置每页显示的学生数量

    // 显示所有学生（带分页）
    @GetMapping
    @PreAuthorize("isAuthenticated()") // 只有已认证的用户可以访问
    public String viewStudentsPage(Model model, @RequestParam(defaultValue = "0") int page, Authentication authentication) {
        Page<Student> studentPage = studentService.getStudents(PageRequest.of(page, pageSize));
        model.addAttribute("students", studentPage.getContent());
        model.addAttribute("currentPage", studentPage.getNumber());
        model.addAttribute("totalPages", studentPage.getTotalPages());

        // 将用户名添加到模型中
        if (authentication != null) {
            model.addAttribute("username", authentication.getName());
        }

        return "students";  // 这个页面会渲染 resources/templates/students.html
    }

    // 显示创建新学生的表单
    @GetMapping("/new")
    @PreAuthorize("isAuthenticated()")
    public String showNewStudentForm(Model model, Authentication authentication) {
        Student student = new Student();
        model.addAttribute("student", student);

        // 将用户名添加到模型中
        if (authentication != null) {
            model.addAttribute("username", authentication.getName());
        }

        return "new_student";  // 这个页面会渲染 resources/templates/new_student.html
    }

    // 处理保存新学生
    @PostMapping("/save")
    @PreAuthorize("isAuthenticated()")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveOrUpdateStudent(student);
        return "redirect:/students";
    }

    // 显示编辑学生的表单
    @GetMapping("/edit/{id}")
    @PreAuthorize("isAuthenticated()")
    public String showEditStudentForm(@PathVariable("id") Long id, Model model, Authentication authentication) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);

        // 将用户名添加到模型中
        if (authentication != null) {
            model.addAttribute("username", authentication.getName());
        }

        return "edit_student";  // 这个页面会渲染 resources/templates/edit_student.html
    }

    // 处理更新学生信息
    @PostMapping("/update/{id}")
    @PreAuthorize("isAuthenticated()")
    public String updateStudent(@PathVariable("id") Long id, @ModelAttribute("student") Student student) {
        student.setId(id);
        studentService.saveOrUpdateStudent(student);
        return "redirect:/students";
    }

    // 删除学生
    @GetMapping("/delete/{id}")
    @PreAuthorize("isAuthenticated()")
    public String deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }

    // 导出学生信息到 Excel
    @GetMapping("/export")
    @PreAuthorize("isAuthenticated()")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        List<Student> students = studentService.getAllStudents(); // 假设有这个方法返回所有学生
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("学生列表");

        // 创建表头
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("姓名");
        headerRow.createCell(1).setCellValue("邮箱");
        headerRow.createCell(2).setCellValue("年龄");

        // 填充数据
        int rowNum = 1;
        for (Student student : students) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(student.getName());
            row.createCell(1).setCellValue(student.getEmail());
            row.createCell(2).setCellValue(student.getAge());
        }

        // 设置响应
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=students.xlsx");
        workbook.write(response.getOutputStream());
        workbook.close();
    }
}
