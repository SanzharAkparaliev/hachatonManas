package com.hachaton.onlineshoping.service.impl;

import com.hachaton.onlineshoping.entity.Comment;
import com.hachaton.onlineshoping.entity.Product;
import com.hachaton.onlineshoping.entity.User;
import com.hachaton.onlineshoping.repository.CommentRepository;
import com.hachaton.onlineshoping.repository.ProductRepository;
import com.hachaton.onlineshoping.repository.UserRepository;
import com.hachaton.onlineshoping.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final CommentRepository commentRepository;

    @Override
    public Comment get(Long id) {
        return commentRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Comment by id: " + id + " cannot be found !"));
    }

    @Override
    public Comment save(Long userId, Long productId, String content) {
        User user = userRepository.getById(userId);
        Product product = productRepository.getById(productId);
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setUser(user);
        comment.setProduct(product);
        return         commentRepository.save(comment);
    }


    @Override
    public List<Comment> getAll() {
        return commentRepository.findAll();
    }

    @Override
    public List<Comment> getCommentByUser(User user) {
       return   commentRepository.findByUser(user);
    }

    @Override
    public List<Comment> getCommetByProduct(Product product) {
        return commentRepository.findByProduct(product);
    }

    @Override
    public Comment deleteComment(Long id) {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Comment by id: " + id + " cannot be found !"));
        commentRepository.delete(comment);
        return comment;
    }
}
