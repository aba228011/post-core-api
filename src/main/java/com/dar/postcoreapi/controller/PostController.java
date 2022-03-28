package com.dar.postcoreapi.controller;

import com.dar.postcoreapi.model.PostModel;
import com.dar.postcoreapi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public PostModel sendPost(@Valid @RequestBody PostModel postModel) {
        return postService.sendPost(postModel);
    }

    @PutMapping("/{postId}")
    public PostModel updatePost(@PathVariable String postId, @Valid @RequestBody PostModel postModel) {
        return postService.updatePost(postId, postModel);
    }

    @GetMapping("/all")
    public List<PostModel> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{postId}")
    public PostModel getPostById(@PathVariable String postId) {
        return postService.getPostById(postId);
    }

    @GetMapping("/client/{clientId}")
    public List<PostModel> getPostByClientId(@PathVariable String clientId) {
        return postService.getPostByClientId(clientId);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<String> deletePostById(@PathVariable String postId) {
        if (postService.deletePostById(postId)) {
            return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Wrong id", HttpStatus.BAD_REQUEST);
        }
    }

    @Autowired
    Environment env;

    @GetMapping("/check")
    public String checkController() {
        return "employee-core-api is working at " + env.getProperty("local.server.port");
    }
}
