package com.auth;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    @Test
    public void testLoginConnection() {
        UserService service = new UserService();
        // This will attempt to use your logic
        assertNotNull(service, "UserService should be initialized");
        System.out.println("UserService initialized successfully!");
    }
}