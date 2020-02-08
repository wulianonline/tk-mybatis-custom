package com.wulian.tkmybatis.service;

import com.wulian.tkmybatis.entity.User;
import java.util.List;

public interface UserService {

    User getUserById(Long userId);

    List<User> getAllUser();


}
