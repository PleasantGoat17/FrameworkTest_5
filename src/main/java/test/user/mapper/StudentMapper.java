package test.user.mapper;

import org.apache.ibatis.annotations.Mapper;
import test.user.model.PageRequest;
import test.user.model.Student;

import java.util.List;

@Mapper
public interface StudentMapper {

    List<Student> getAllStudents();

    List<Student> getStudents(PageRequest pageRequest); // 修改这里

    long countStudents();

    Student getStudentById(Long id);

    void insertStudent(Student student);

    void updateStudent(Student student);

    void deleteStudent(Long id);
}
