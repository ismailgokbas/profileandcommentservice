package com.reaction.profileservice.repository;

import com.reaction.profileservice.model.Profiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProfilesRepo extends JpaRepository<Profiles,Long> {
    Profiles getProfilesByUserid(Long userid);

    @Query(value = "UPDATE profiles SET userpassword = ?1 WHERE userid= ?2",nativeQuery = true)
    ResponseEntity updateProfilesByUserpassword(String userpassword, Long userid);

    List<Profiles> findAllByUseremail(String useremail);
}
