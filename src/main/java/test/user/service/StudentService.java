package test.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import test.user.mapper.StudentMapper;
import test.user.model.PageRequest;
import test.user.model.Student;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    // 获取所有学生
    public List<Student> getAllStudents() {
        return studentMapper.getAllStudents();
    }

    // 根据ID获取学生
    public Student getStudentById(Long id) {
        return studentMapper.getStudentById(id);
    }

    // 保存或更新学生
    public void saveOrUpdateStudent(Student student) {
        if (student.getId() == null) {
            studentMapper.insertStudent(student);
        } else {
            studentMapper.updateStudent(student);
        }
    }

    // 删除学生
    public void deleteStudent(Long id) {
        studentMapper.deleteStudent(id);
    }

    // 获取分页的学生列表
    public Page<Student> getStudents(Pageable pageable) {
        // 使用 PageRequest 将 pageable 转换为适合 MyBatis 的参数
        List<Student> students = studentMapper.getStudents(new PageRequest(pageable.getPageNumber(), pageable.getPageSize()));
        long total = studentMapper.countStudents();
        return new PageImpl<>(students, pageable, total);
    }
}
