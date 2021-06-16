package com.dh.narihair.repo;

import com.dh.narihair.domain.UserDTO;
import com.dh.narihair.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserRepoEx{
    Page<UserDTO> getUserList(UserDTO user, Pageable page);
}
