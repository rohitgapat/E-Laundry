package com.controller.test;

import com.Service.UserService;
import com.controler.UserController;
import com.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void testGetAllUsers() throws Exception {
        User u1 = new User(1L, "Rohit", "rohit@example.com", "1234", "9999999999", "USER", null);
        User u2 = new User(2L, "Amit", "amit@example.com", "5678", "8888888888", "ADMIN", null);

        when(userService.getAllUesr()).thenReturn(Arrays.asList(u1, u2));

        mockMvc.perform(get("/users/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Rohit"))
                .andExpect(jsonPath("$[1].name").value("Amit"));
    }

    @Test
    void testFindUserById() throws Exception {
        User u1 = new User(1l, "Rohit", "rohit@example.com", "1234", "9999999999", "USER", null);

        when(userService.findUserById(1L)).thenReturn(u1);

        mockMvc.perform(get("/users/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Rohit"))
                .andExpect(jsonPath("$.email").value("rohit@example.com"));
    }

    @Test
    void testAddNewUser() throws Exception {
		/*
		 * when(userService.addNewUser(org.mockito.Mockito.any(User.class))) //
		 * .thenReturn();
		 */
        String userJson = """
                {
                  "name": "Rohit",
                  "email": "rohit@example.com",
                  "password": "1234",
                  "phone": "9999999999",
                  "role": "USER"
                }
                """;

        mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(userJson))
                .andExpect(status().isOk())
                .andExpect(content().string("User added successfully"));
    }
}
