 package cn.mangodb.domain;

import java.io.Serializable;

/**
 * @author xiang
 * @date 2019/01/03
 */
public class UserEntity implements Serializable {

    private static final long serialVersionUID = -363251523663781205L;
    private Long id;
    private String userName;
    private String passWord;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassWord() {
        return passWord;
    }
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    

}
