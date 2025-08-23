package com.userservice.test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.Service.UserService; 
import com.Service.UserServiceImp;
import com.entity.User;
import com.repository.UserRepository;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImp userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddUser() {
        User user = new User();
        user.setId(1L);
        user.setName("Rohit");
        user.setEmail("rohit@example.com");
        user.setPassword("pass123");
        user.setPhone("9834235626");
        user.setRole("Tester");

        when(userRepository.save(any(User.class))).thenReturn(user);

        User savedUser = userService.addNewUser(user);

        assertNotNull(savedUser);
        assertEquals("Rohit", savedUser.getName());
        assertEquals("rohit@example.com", savedUser.getEmail());
        assertEquals("pass123", savedUser.getPassword());

        verify(userRepository, times(1)).save(any(User.class));
    }
}
