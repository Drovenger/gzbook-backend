package com.gzbook.controller;

import com.gzbook.model.payload.reponse.MessageResponse;
import com.gzbook.model.payload.request.SignupRequest;
import com.gzbook.model.user.ERole;
import com.gzbook.model.user.Role;
import com.gzbook.model.user.User;
import com.gzbook.repository.IRoleRepository;
import com.gzbook.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("")
public class LoginSignupController {
    @Autowired
    IUserRepository userRepository;

    @Autowired
    IRoleRepository roleRepository;

//    @Autowired
//    PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        User user = new User(signUpRequest.getUsername(),signUpRequest.getGender(), signUpRequest.getEmail(), signUpRequest.getPassword());

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                if ("admin".equals(role)) {
                    Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(adminRole);
                } else {
                    Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(userRole);
                }
            });
        }

        user.setAvatarUrl("https://firebasestorage.googleapis.com/v0/b/porject-module6-vh2.appspot.com/o/wp3313545%20-%20Copy.jpg?alt=media&token=f870ab79-247d-4b39-88c6-454fb39557f1");
        user.setCoverPhotoUrl("https://firebasestorage.googleapis.com/v0/b/porject-module6-vh2.appspot.com/o/wp3313545.jpg?alt=media&token=353b7206-321a-4eee-b845-36015a19c37e");
        user.setDateOfBirth("--");
        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}
