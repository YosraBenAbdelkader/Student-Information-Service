package com.students.information.system.studentinformationsystem.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.students.information.system.model.Student;
import com.students.information.system.service.StudentService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author ragcrix
 */
@RunWith(SpringRunner.class)
@WebMvcTest
public class StudentRestControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private StudentService studentService;

    private ObjectMapper objectMapper = new ObjectMapper();

    private Student ragcrix;
    private Student yigit;

    private final Long yosraStudentNumber = 23L;
    private final Long ybenabdelkaderStudentNumber = 91L;

    @Before
    public void setup() {
        ragcrix = new Student();
        ragcrix.setId("aBc123");
        ragcrix.setName("yosra");
        ragcrix.setEmail("yosra@rg.com");
        ragcrix.setStudentNumber(yosraStudentNumber);
        ragcrix.setCourseList(Arrays.asList("Math", "Science"));
        ragcrix.setGpa(3.37f);

        yigit = new Student();
        yigit.setId("dEf345");
        yigit.setName("yosr");
        yigit.setEmail("yosra@ygt.com");
        yigit.setStudentNumber(ybenabdelkaderStudentNumber);
        yigit.setCourseList(Arrays.asList("Frensh", "english"));
        yigit.setGpa(3.58f);
    }

    @Test
    public void givenStudents_whenGetAllStudents_thenReturnJsonArray() throws Exception {
        given(studentService.findAll()).willReturn(Arrays.asList(ragcrix));

        mvc.perform(get("/students/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is(ragcrix.getName())));
    }



}