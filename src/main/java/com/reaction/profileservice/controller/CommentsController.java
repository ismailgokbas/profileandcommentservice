package com.reaction.profileservice.controller;

import com.reaction.profileservice.DTO.UserAllCommentsDTO;
import com.reaction.profileservice.model.Comments;
import com.reaction.profileservice.model.VideoComments;
import com.reaction.profileservice.service.CommentsService;
import com.reaction.profileservice.service.VideoCommentsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
@AllArgsConstructor
@CrossOrigin
public class CommentsController {

    private final CommentsService commentsService;
    private final VideoCommentsService videoCommentsService;

    @GetMapping("{category}/{id}")
    public ResponseEntity<List<UserAllCommentsDTO>> getUserComments(@PathVariable String category
            , @PathVariable Integer id){
        return ResponseEntity.ok(commentsService.getReactionsByUseridAndCategory(category,id));
    }

    @GetMapping("/forVideo/{videoId}")
    public ResponseEntity<List<VideoComments>> getCommentsForVideo(@PathVariable String videoId,@RequestParam Integer size,@RequestParam Integer page){
        return ResponseEntity.ok(videoCommentsService.getCommentsOfVideo(videoId,size,page));
    }


    @PostMapping("/addComment")
    public ResponseEntity addCommentvideo (@RequestBody Comments tempComment){
        return ResponseEntity.ok(this.commentsService.addCommentToVideo(tempComment));
    }
}
