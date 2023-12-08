package com.reaction.profileservice.repository;

import com.reaction.profileservice.model.VideoComments;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VideoCommentRepository extends JpaRepository<VideoComments,Long> {
    @Query(value = "select commentid,comment,commentdate,username,profiles.userid from profiles,comments where comments.userid=profiles.userid and comments.videoid=?1 order by commentid desc ",nativeQuery = true)
    List<VideoComments> getSpecialCommentsForVideo(String videoId,PageRequest pageRequest);
}
