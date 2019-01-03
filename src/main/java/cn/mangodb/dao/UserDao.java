 package cn.mangodb.dao;

import cn.mangodb.domain.UserEntity;

/**
 * @author xiang
 * @date 2019/01/03
 */
public interface UserDao {
    void saveUser(UserEntity user);
    UserEntity findUserByUserName(String userName);
    void updateUser(UserEntity user);
    void deleteUserById(Long id);
}
