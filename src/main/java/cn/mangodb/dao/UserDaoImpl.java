 package cn.mangodb.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import cn.mangodb.domain.UserEntity;

/**
 * @author xiang
 * @date 2019/01/03
 */
@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    private MongoTemplate mongoTemplate;
    
    @Override
    public void saveUser(UserEntity user) {
        mongoTemplate.save(user);
         
    }

    /** (non-Javadoc)
     * @see cn.mangodb.dao.UserDao#findUserByUserName(java.lang.String)
     */
    @Override
    public UserEntity findUserByUserName(String userName) {
        Query query=new Query(Criteria.where("userName").is(userName));
        UserEntity user =  mongoTemplate.findOne(query , UserEntity.class);
        return user;
    }

    /** (non-Javadoc)
     * @see cn.mangodb.dao.UserDao#updateUser(cn.mangodb.domain.UserEntity)
     */
    @Override
    public void updateUser(UserEntity user) {
        Query query=new Query(Criteria.where("id").is(user.getId()));
        Update update= new Update().set("userName", user.getUserName()).set("passWord", user.getPassWord());
        //更新查询返回结果集的第一条
        mongoTemplate.updateFirst(query,update,UserEntity.class);
        //更新查询返回结果集的所有
        // mongoTemplate.updateMulti(query,update,UserEntity.class);
         
    }

    /** (non-Javadoc)
     * @see cn.mangodb.dao.UserDao#deleteUserById(java.lang.Long)
     */
    @Override
    public void deleteUserById(Long id) {
        Query query=new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query,UserEntity.class);
         
    }

}
