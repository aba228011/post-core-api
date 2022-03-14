package com.dar.postcoreapi.service;

import com.dar.postcoreapi.model.PostModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class PostService implements IPostService {

    private static final HashMap<String, PostModel> postHashMap = new HashMap<>();

    static {
        PostModel postModel1 = new PostModel(
                UUID.randomUUID().toString(),
                "client1",
                UUID.randomUUID().toString(),
                "Письмо", "Отправлено");
        PostModel postModel2 = new PostModel(
                UUID.randomUUID().toString(),
                "client1",
                UUID.randomUUID().toString(),
                "Ноутбук", "Отправлено");
        PostModel postModel3 = new PostModel(
                UUID.randomUUID().toString(),
                "client1",
                UUID.randomUUID().toString(),
                "Книга", "Отправлено");
        PostModel postModel4 = new PostModel(
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString(),
                "Деньги", "Доставлено");

        postHashMap.put(postModel1.getPostId(), postModel1);
        postHashMap.put(postModel2.getPostId(), postModel2);
        postHashMap.put(postModel3.getPostId(), postModel3);
        postHashMap.put(postModel4.getPostId(), postModel4);
    }

    @Override
    public PostModel sendPost(PostModel postModel) {
        postModel.setPostId(UUID.randomUUID().toString());
        return postHashMap.put(postModel.getPostId(), postModel);
    }

    @Override
    public PostModel updatePost(String postId, PostModel postModel) {
        postModel.setPostId(postId);
        return postHashMap.put(postId, postModel);
    }

    @Override
    public List<PostModel> getAllPosts() {
        return new ArrayList<>(postHashMap.values());
    }

    @Override
    public PostModel getPostById(String postId) {
        return postHashMap.get(postId);
    }

    @Override
    public List<PostModel> getPostByClientId(String clientId) {
        List<PostModel> postModels = new ArrayList<>(postHashMap.values());
        List<PostModel> resPostModels = new ArrayList<>();
        for (PostModel p: postModels) {
            if (p.getClientId().equals(clientId))  {
                resPostModels.add(p);
            }
        }
        return resPostModels;
    }

    @Override
    public boolean deletePostById(String postId) {
        if (postHashMap.get(postId) != null) {
            postHashMap.remove(postId);
            return true;
        }
        else {
            return false;
        }
    }
}
