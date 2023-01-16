package com.example.demo.mapper;

import com.example.demo.controller.request.TeacherRequest;
import com.example.demo.domain.Teacher;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

@RunWith(MockitoJUnitRunner.class)
public class TeacherRequestToTeacherMapperTest {

    @InjectMocks
    TeacherRequestToTeacherMapper tested;

    @Mock
    private ModelMapper modelMapper;

    @Test
    public void testApply() {
        TeacherRequest teacherRequest = this.mockTeacherRequest();
        Teacher teacher = this.mockTeacher();

        Mockito.when(modelMapper.map(teacherRequest, Teacher.class))
            .thenReturn(teacher);

        Teacher result = tested.apply(teacherRequest);

        Mockito.verify(modelMapper)
            .map(teacherRequest, Teacher.class);

        Assert.assertNotNull(result);
        Assert.assertEquals(teacher.getLogin(), result.getLogin());
        Assert.assertEquals(teacher.getSiape(), result.getSiape());
    }

    private TeacherRequest mockTeacherRequest(){
        TeacherRequest teacherRequest = new TeacherRequest();
        teacherRequest.setLogin("raqs");
        teacherRequest.setSiape("8896621");

        return teacherRequest;
    }

    private Teacher mockTeacher(){
        Teacher teacher = new Teacher();
        teacher.setLogin("raqs");
        teacher.setSiape("8896621");

        return teacher;
    }

}