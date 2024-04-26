package com.learn.java.security.oauth2.client.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class OAuth2UserService extends DefaultOAuth2UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OAuth2UserService.class);

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
    	LOGGER.info("Load user {}", userRequest);
    	System.out.println("Load user ");
    	return super.loadUser(userRequest);
    }
}    




//
//import java.util.Objects;
//import java.util.Optional;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
//import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
//import org.springframework.security.oauth2.core.user.OAuth2User;
//import org.springframework.stereotype.Service;
//
//import com.learn.java.security.oauth2.client.model.UserPrincipal;
//import com.learn.java.security.oauth2.client.model.document.User;
//import com.learn.java.security.oauth2.client.model.response.Oauth2UserInfoDto;
//import com.learn.java.security.oauth2.client.repository.UserRepository;
//
//import lombok.SneakyThrows;
//
//@Service
//public class OAuth2UserService2 extends DefaultOAuth2UserService {
//
//	private static final Logger LOGGER = LoggerFactory.getLogger(OAuth2UserService2.class);
//
//	@Autowired
//    private UserRepository userRepository;
//
//    @Override
//    @SneakyThrows
//    public OAuth2User loadUser(OAuth2UserRequest oAuth2UserRequest) {
//    	LOGGER.info("Load user {}", oAuth2UserRequest);
//        OAuth2User oAuth2User = super.loadUser(oAuth2UserRequest);
//        return processOAuth2User(oAuth2UserRequest, oAuth2User);
//    }
//
//    private OAuth2User processOAuth2User(OAuth2UserRequest oAuth2UserRequest, OAuth2User oAuth2User) {
//    	
//    	//Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//    	if(Objects.isNull(oAuth2User.getAttributes())) {
//    		LOGGER.info("oAuth2User.getAttributes() is null");
//    		return oAuth2User;
//    	}
//    	LOGGER.info(""+oAuth2User.getAttributes());
//        Oauth2UserInfoDto userInfoDto = Oauth2UserInfoDto
//                .builder()
//                .name(oAuth2User.getAttributes().get("name").toString())
//                .id(oAuth2User.getAttributes().get("sub").toString())
//                .email(oAuth2User.getAttributes().get("email").toString())
//                .picture(oAuth2User.getAttributes().get("picture").toString())
//                .build();
//
//        LOGGER.trace("User info is {}", userInfoDto);
//        Optional<User> userOptional = userRepository.findByUsername(userInfoDto.getEmail());
//        LOGGER.trace("User is {}", userOptional);
//        User user = userOptional
//                .map(existingUser -> updateExistingUser(existingUser, userInfoDto))
//                .orElseGet(() -> registerNewUser(oAuth2UserRequest, userInfoDto));
//        return UserPrincipal.create(user, oAuth2User.getAttributes());
//    }
//    
//    private User registerNewUser(OAuth2UserRequest oAuth2UserRequest, Oauth2UserInfoDto userInfoDto) {
//        User user = new User();
//        user.setProvider(oAuth2UserRequest.getClientRegistration().getRegistrationId());
//        user.setProviderId(userInfoDto.getId());
//        user.setName(userInfoDto.getName());
//        user.setUsername(userInfoDto.getEmail());
//        user.setPicture(userInfoDto.getPicture());
//        return userRepository.save(user);
//    }
//
//    private User updateExistingUser(User existingUser, Oauth2UserInfoDto userInfoDto) {
//        existingUser.setName(userInfoDto.getName());
//        existingUser.setPicture(userInfoDto.getPicture());
//        return userRepository.save(existingUser);
//    }
//
//}
