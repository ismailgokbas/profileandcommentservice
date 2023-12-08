package com.reaction.profileservice.service;

import com.reaction.profileservice.model.VideoComments;
import com.reaction.profileservice.repository.VideoCommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class VideoCommentsService {

    private final VideoCommentRepository videoCommentRepo;

    public List<VideoComments> getCommentsOfVideo(String videoId,Integer size,Integer commentPage) {
            return videoCommentRepo.getSpecialCommentsForVideo(videoId,PageRequest.of(commentPage,size)).stream().toList();
    }
}