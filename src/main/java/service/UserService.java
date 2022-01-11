package service;

import pojo.User;

import java.util.List;

public interface UserService {
    public int insertUser(User user);

    public int deleteUserById(Integer id);

    public int updateUser(User user);

    public User selectUserById(Integer id);

    public List<User> selectUserByNameFuzzy(String name);

    public User selectUserByName(String name);

    public List<User> selectUserByIdentity(Integer identity);

    public List<User> selectUsers();
}
