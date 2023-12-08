package com.reaction.profileservice.DTO;

import lombok.AllArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
public class GeneralInfoDTO {
    public Long userid;
    public String username;
    public String useremail;
    public String reactedvideosids;
    public Date entrydate;
}

