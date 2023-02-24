package com.hachaton.onlineshoping.service;

import com.hachaton.onlineshoping.entity.Category;
import com.hachaton.onlineshoping.entity.Comment;
import com.hachaton.onlineshoping.entity.Product;
import com.hachaton.onlineshoping.entity.User;

import java.util.List;

public interface CommentService {
    Comment get(Long id);
    Comment getByName(String name);
    Comment save(Comment comment);
    List<Comment> getAll();
    List<Comment> getCommentByUser(User user);
    List<Comment> getCommetByProduct(Product product);
}
