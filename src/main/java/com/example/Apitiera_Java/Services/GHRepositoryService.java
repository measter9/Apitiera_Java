package com.example.Apitiera_Java.Services;

import com.example.Apitiera_Java.Models.DTOs.Branch;
import com.example.Apitiera_Java.Models.DTOs.GHRepositoryResponse;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class GHRepositoryService {

    RestClient restClient = RestClient.builder()
            .baseUrl("https://api.github.com")
            .build();

    public List<GHRepositoryResponse> getAllGHRepository(String username) {
        List<Map<String, Object>> response = restClient.get()
                .uri("/users/" + username + "/repos")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });


        List<GHRepositoryResponse> result = new ArrayList<>();
        for (Map<String, Object> repo : response) {
            if (repo.get("fork").toString() == "false") {

                Map<String, Object> owner = (Map<String, Object>) repo.get("owner");

                List<Map<String, Object>> branchesResponse = restClient.get()
                        .uri("/repos/" + username + "/" + repo.get("name") + "/branches")
                        .accept(MediaType.APPLICATION_JSON)
                        .retrieve()
                        .body(new ParameterizedTypeReference<>() {
                        });

                List<Branch> branches = new ArrayList<>();
                for (Map<String, Object> branch : branchesResponse) {
                    Map<String, Object> commit = (Map<String, Object>) branch.get("commit");
                    Branch b = new Branch(branch.get("name").toString(), commit.get("sha").toString());
                    branches.add(b);
                }


                GHRepositoryResponse gh = GHRepositoryResponse.builder()
                        .repositoryName(repo.get("name").toString())
                        .ownerLogin(owner.get("login").toString())
                        .branches(branches)
                        .build();


                result.add(gh);
            }
        }
        return result;
    }
}
