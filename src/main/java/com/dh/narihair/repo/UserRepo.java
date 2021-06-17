package com.dh.narihair.repo;

import com.dh.narihair.entity.Admin;
import com.dh.narihair.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long>, UserRepoEx{
    User findBySeq(long seq);
}
