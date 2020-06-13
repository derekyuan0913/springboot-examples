package org.yuanding.user;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yuanding.base.BaseRestService;

import java.util.List;

@Service
public class UserRestServiceImpl implements BaseRestService<User> {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> list() {
        return userMapper.listUser();
    }

    @Override
    public Page<User> listByPage() {
        return userMapper.listByPage();
    }

    @Override
    public User get(int id) {
        return userMapper.getUser(id);
    }

    @Override
    public int add(User entity) {
        return userMapper.addUser(entity);
    }

    @Override
    public int delete(int id) {
        return userMapper.deleteUser(id);
    }

    @Override
    public int update(User entity) {
        return userMapper.updateUser(entity);
    }
}
