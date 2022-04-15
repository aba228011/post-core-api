package com.dar.postcoreapi.service;

import com.dar.postcoreapi.model.PostRequest;
import com.dar.postcoreapi.model.PostResponse;

import java.util.List;

public interface IPostService {
    PostResponse sendPost(PostRequest postRequest);

    PostResponse updatePost(PostRequest postRequest);

    List<PostResponse> getAllPosts();

    PostResponse getPostById(String postId);

//    List<PostResponse> getPostByClientId(String clientId);

    void deletePostById(String postId);
}
