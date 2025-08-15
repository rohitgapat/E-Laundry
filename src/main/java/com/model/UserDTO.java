package com.model;

import lombok.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String password; // Optional: You may omit this for security reasons
    private String phone;
    private String role;
    private List<OrderDTO> orders;
}
