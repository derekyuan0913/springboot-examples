package org.yuanding.user;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.yuanding.pagination.SimplePageInfo;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRestServiceImpl userService;

    @GetMapping
    public SimplePageInfo<User> userList(
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "10") int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new SimplePageInfo<>(userService.listByPage());
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
        return userService.get(id);
    }

    @PostMapping
    public int addUser(@RequestBody User user) {
        return userService.add(user);
    }

    @PatchMapping("/{id}")
    public int updateUser(@PathVariable int id, @RequestBody User user) {
        user.setId(id);
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    public int deleteUser(@PathVariable int id) {
        return userService.delete(id);
    }
}
