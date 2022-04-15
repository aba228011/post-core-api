package com.dar.postcoreapi.controller;

import com.dar.postcoreapi.model.PostModel;
import com.dar.postcoreapi.model.PostRequest;
import com.dar.postcoreapi.model.PostResponse;
import com.dar.postcoreapi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    Environment env;

    @GetMapping("/check")
    public String checkController() {
        return "post-core-api is working at " + env.getProperty("local.server.port");
    }

    @PostMapping
    public PostResponse sendPost(@Valid @RequestBody PostRequest postRequest) {
        return postService.sendPost(postRequest);
    }

    @PutMapping
    public PostResponse updatePost(@Valid @RequestParam PostRequest postRequest) {
        return postService.updatePost(postRequest);
    }

    @GetMapping("/all")
    public List<PostResponse> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping
    public PostResponse getPostById(@RequestParam String postId) {
        return postService.getPostById(postId);
    }

    @DeleteMapping
    public void deletePostById(@RequestParam String postId) {
        postService.deletePostById(postId);
    }
}
