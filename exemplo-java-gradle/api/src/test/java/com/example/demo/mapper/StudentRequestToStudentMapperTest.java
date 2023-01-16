package com.example.demo.mapper;

import com.example.demo.controller.request.StudentRequest;
import com.example.demo.domain.Student;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

@RunWith(MockitoJUnitRunner.class)
public class StudentRequestToStudentMapperTest {

    @InjectMocks
    StudentRequestToStudentMapper tested;

    @Mock
    private ModelMapper modelMapper;

    @Test
    public void testApply() {
        StudentRequest studentRequest = this.mockStudentRequest();
        Student student = this.mockStudent();

        Mockito.when(modelMapper.map(studentRequest, Student.class))
            .thenReturn(student);

        Student result = tested.apply(studentRequest);

        Mockito.verify(modelMapper)
            .map(studentRequest, Student.class);

        Assert.assertNotNull(result);
        Assert.assertEquals(student.getLogin(), result.getLogin());
        Assert.assertEquals(student.getPassword(), result.getPassword());
    }

    private StudentRequest mockStudentRequest(){
        StudentRequest studentRequest = new StudentRequest();
        studentRequest.setLogin("hollow");
        studentRequest.setPassword("password");

        return studentRequest;
    }

    private Student mockStudent(){
        Student student = new Student();
        student.setLogin("hollow");
        student.setPassword("password");

        return student;
    }

}