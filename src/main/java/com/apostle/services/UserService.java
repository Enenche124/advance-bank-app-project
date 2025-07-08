package com.apostle.services;

import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
@Service
public interface UserService {
    String uploadProfilePicture(Long userId, MultipartFile file);
}
