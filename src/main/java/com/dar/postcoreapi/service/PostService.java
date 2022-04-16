package com.dar.postcoreapi.service;

import com.dar.postcoreapi.model.PostRequest;
import com.dar.postcoreapi.model.PostResponse;
import com.dar.postcoreapi.repository.PostEntity;
import com.dar.postcoreapi.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PostService implements IPostService {

    @Autowired
    private PostRepository postRepository;

    static ModelMapper modelMapper = new ModelMapper();

    static {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    @Override
    public PostResponse sendPost(PostRequest postRequest) {
        postRequest.setPostId(UUID.randomUUID().toString());

        PostEntity postEntity = modelMapper.map(postRequest, PostEntity.class);
        postEntity = postRepository.save(postEntity);

        return modelMapper.map(postEntity, PostResponse.class);
    }

    @Override
    public PostResponse updatePost(PostRequest postRequest) {
        PostEntity postEntity = modelMapper.map(postRequest, PostEntity.class);

        PostEntity findPost = postRepository.getPostEntityByPostId(postRequest.getPostId());
        postEntity.setId(findPost.getId());

        postEntity = postRepository.save(postEntity);

        return modelMapper.map(postEntity, PostResponse.class);
    }

    @Override
    public List<PostResponse> getAllPosts() {
        return postRepository.getPostEntitiesBy().stream()
                .map(post -> modelMapper.map(post, PostResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostResponse getPostById(String postId) {
        PostEntity postEntity = postRepository.getPostEntityByPostId(postId);
        return modelMapper.map(postEntity, PostResponse.class);
    }


    @Override
    public void deletePostById(String postId) {
        postRepository.deletePostEntitiesByPostId(postId);
    }
}
