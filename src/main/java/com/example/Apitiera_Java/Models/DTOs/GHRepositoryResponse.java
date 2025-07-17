package com.example.Apitiera_Java.Models.DTOs;

import lombok.*;

import java.util.List;

@Builder
@ToString
public class GHRepositoryResponse {

    public String repositoryName;
    public String ownerLogin;
    public List<Branch> branches;
}
