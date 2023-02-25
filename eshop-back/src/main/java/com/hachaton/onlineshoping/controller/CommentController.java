package com.hachaton.onlineshoping.controller;

import com.hachaton.onlineshoping.entity.Comment;
import com.hachaton.onlineshoping.service.CommentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommentController {
    private final CommentService commentService;

    @GetMapping("/product/{id}")
    public List<Comment> getCommentByProduct(@PathVariable("id") Long productId){
      return  commentService.getCommetByProduct(productId);
    }

    @GetMapping("/{id}")
    public Comment getComment(@PathVariable("id")Long commentId){
        return commentService.get(commentId);
    }

    @DeleteMapping("/{id}")
    public Comment deleteComment(@PathVariable("id") Long commentId){
        return commentService.deleteComment(commentId);
    }

    @PutMapping
    public Comment updateComment(@RequestBody Comment comment){
        return commentService.update(comment);
    }

    @GetMapping
    public Comment createComment(@RequestParam("userId") Long userId,
                                 @RequestParam("productId")Long productId,
                                 @RequestParam("comment") String content){
        return commentService.save(userId,productId,content);
    }
}
