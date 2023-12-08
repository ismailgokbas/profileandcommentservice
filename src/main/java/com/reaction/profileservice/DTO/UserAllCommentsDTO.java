package com.reaction.profileservice.DTO;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;


@AllArgsConstructor
@Data
public class UserAllCommentsDTO {
    private Long commentid;
    private String comment;
    private String category;
    private String videolink;
    private Date commentdate;
}
