package dao;

import org.apache.ibatis.annotations.Param;
import pojo.User;

import java.util.List;

public interface UserMapper {
    public int insertUser(User user);

    public int deleteUserById(@Param("id") Integer id);

    public int updateUser(User user);

    public User selectUserById(@Param("id") Integer id);

    public List<User> selectUserByNameFuzzy(@Param("name") String name);

    public User selectUserByName(@Param("name") String name);

    public List<User> selectUserByIdentity(@Param("identity") Integer identity);

    public List<User> selectUsers();
}
