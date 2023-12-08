package com.reaction.profileservice.repository;

import com.reaction.profileservice.model.Comments;
import com.reaction.profileservice.model.VideoComments;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CommentsRepo extends JpaRepository<Comments,Long> {
    List<Comments> getDistinctByCategoryAndUseridOrderByCommentidAsc(String category, Integer userid);
}