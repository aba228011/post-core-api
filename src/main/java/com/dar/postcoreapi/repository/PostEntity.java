package com.dar.postcoreapi.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Posts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostEntity {
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = true, unique = true, length = 50)
    private String postId;
    @Column(nullable = true, unique = false, length = 50)
    private String clientId;
    @Column(nullable = true, unique = false, length = 50)
    private String postRecipientId;
    @Column(nullable = false)
    private String postItem;
    @Column(nullable = false, length = 20)
    private String status;
}
