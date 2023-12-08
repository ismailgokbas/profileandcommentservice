package com.reaction.profileservice.service;

import com.reaction.profileservice.DTO.GeneralInfoDTO;
import com.reaction.profileservice.DTO.PasswordChangerDTO;
import com.reaction.profileservice.model.Profiles;
import com.reaction.profileservice.repository.ProfilesRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class ServiceProfile {

    ProfilesRepo profilesRepo;

    public GeneralInfoDTO getUserGeneralInfoById(Long userid){
        var allinformationOfProfile = profilesRepo.getProfilesByUserid(userid);
        return new GeneralInfoDTO(
                allinformationOfProfile.getUserid(),
                allinformationOfProfile.getUsername(),
                allinformationOfProfile.getUseremail(),
                allinformationOfProfile.getReactedvideosids(),
                allinformationOfProfile.getEntrydate()
        );
    }

    public ResponseEntity createUser(Profiles newProfile){
        List<Profiles> user = profilesRepo.findAllByUseremail(newProfile.getUseremail());
        if (user.isEmpty()){
            profilesRepo.save(newProfile);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
    }

    public void changePassword(PasswordChangerDTO passwordChangerDTO){
        profilesRepo.updateProfilesByUserpassword(passwordChangerDTO.userpassword, passwordChangerDTO.userid);
    }

}
