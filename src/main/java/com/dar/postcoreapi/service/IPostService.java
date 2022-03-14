package com.dar.postcoreapi.service;

import com.dar.postcoreapi.model.PostModel;

import java.util.List;

public interface IPostService {
    PostModel sendPost(PostModel postModel);

    PostModel updatePost(String postId, PostModel postModel);

    List<PostModel> getAllPosts();

    PostModel getPostById(String postId);

    List<PostModel> getPostByClientId(String clientId);

    boolean deletePostById(String postId);
}
