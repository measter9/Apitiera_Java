package com.example.Apitiera_Java.Controllers;

import com.example.Apitiera_Java.Models.DTOs.GHRepositoryResponse;
import com.example.Apitiera_Java.Services.GHRepositoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GHRepositoryControllerTest {

    @Autowired
    private GHRepositoryService ghRepositoryService;

    @Test
    void shouldReturn200WhenGithubUserExists() throws Exception {

        String username = "measter9";

        List<GHRepositoryResponse> result = ghRepositoryService.getAllGHRepository(username);

        assertNotNull(result);
        assertFalse(result.isEmpty());

        GHRepositoryResponse ghRepositoryResponse = result.get(0);
        assertNotNull(ghRepositoryResponse);
        assertEquals(username, ghRepositoryResponse.ownerLogin);
    }
}