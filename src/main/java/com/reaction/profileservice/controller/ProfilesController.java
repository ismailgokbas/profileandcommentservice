package com.reaction.profileservice.controller;

import com.reaction.profileservice.DTO.GeneralInfoDTO;
import com.reaction.profileservice.DTO.PasswordChangerDTO;
import com.reaction.profileservice.model.Profiles;
import com.reaction.profileservice.service.ServiceProfile;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("profiles")
@AllArgsConstructor
public class ProfilesController {

    private final ServiceProfile serviceProfile;


    @GetMapping("/info/{id}")
    public ResponseEntity<GeneralInfoDTO> getUserGeneralInfoWithId(@PathVariable Long id){
        return ResponseEntity.ok(this.serviceProfile.getUserGeneralInfoById(id));
    }

    @PostMapping("/createUser")
    public ResponseEntity createNewUser(@RequestBody Profiles newProfile){
        return this.serviceProfile.createUser(newProfile);
    }

    @PutMapping("/changePassword")
    public ResponseEntity updatePassword(@RequestBody PasswordChangerDTO passwordChangerDTO){
            this.serviceProfile.changePassword(passwordChangerDTO);
            return new ResponseEntity<>(HttpStatus.OK);
    }

}
