package service;

import dao.UserMapper;
import org.springframework.stereotype.Service;
import pojo.User;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService{

    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public int deleteUserById(Integer id) {
        return userMapper.deleteUserById(id);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public User selectUserById(Integer id) {
        return userMapper.selectUserById(id);
    }

    @Override
    public List<User> selectUserByNameFuzzy(String name) {
        if (name == null || name.equals("")) {
            return userMapper.selectUsers();
        } else {
            return userMapper.selectUserByNameFuzzy(name);
        }
    }

    @Override
    public User selectUserByName(String name) {
        return userMapper.selectUserByName(name);
    }

    @Override
    public List<User> selectUserByIdentity(Integer identity) {
        return userMapper.selectUserByIdentity(identity);
    }

    @Override
    public List<User> selectUsers() {
        return userMapper.selectUsers();
    }

    public User verifyLogin(String name, String password) {
        User user = userMapper.selectUserByName(name);
        if (user != null && Objects.equals(user.getPassword(), password)) {
            return user;
        } else {
            return null;
        }
    }
}
