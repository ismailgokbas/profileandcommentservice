package com.reaction.profileservice.service;

import com.reaction.profileservice.DTO.UserAllCommentsDTO;
import com.reaction.profileservice.model.Comments;
import com.reaction.profileservice.model.VideoComments;
import com.reaction.profileservice.repository.CommentsRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentsService {
    private final CommentsRepo commentsRepo;

    public CommentsService(CommentsRepo commentsRepo) {
        this.commentsRepo = commentsRepo;
    }

    public List<UserAllCommentsDTO> getReactionsByUseridAndCategory(String category,Integer userid){
        List<Comments> comments= getCommentsWithPagination(category,userid);
        List<UserAllCommentsDTO> userAllCommentsDTOList = comments.stream().map((comment)->
                new UserAllCommentsDTO(comment.getCommentid(),comment.getComment(),comment.getCategory()
                ,comment.getVideolink(),comment.commentdate)).collect(Collectors.toList());

        return userAllCommentsDTOList;
    }

    private List<Comments> getCommentsWithPagination(String category,Integer userid){
        List<Comments> comments = commentsRepo.getDistinctByCategoryAndUseridOrderByCommentidAsc(category,userid);
        return comments;
    }

    public Comments addCommentToVideo(Comments comments){
        commentsRepo.save(comments);
        return comments;
    }

}
