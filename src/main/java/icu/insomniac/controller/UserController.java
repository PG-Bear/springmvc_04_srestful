package icu.insomniac.controller;

import icu.insomniac.domain.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @GetMapping
    public Result getAll(){
        List<User> userList = new ArrayList<User>();
        User user1 = new User(1, "Kelex", 22);
        User user2 = new User(2, "Tina", 23);
        User user3 = new User(3, "Annie", 18);
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        return new Result(Code.GET_OK, userList);
    }

    @GetMapping("/{id}")
    public Result getOne(@PathVariable Integer id){
        User user = null;
        if (id == 1){
            user = new User(id, "Kelex", 22);
        }else if (id == 2){
            user = new User(id, "Tina", 23);
        }else if (id == 3){
            user = new User(id, "Kelex", 22);
        }
        return new Result(user != null ? Code.GET_OK : Code.GET_ERR, user, user != null ? "" : "ID incorrect, please retry !!!");
    }

    @DeleteMapping("/{id}")
    public Result deleteOne(@PathVariable Integer id){
        boolean flag;
        flag = id == 1 || id == 2 || id == 3;

        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag);
    }

    @PutMapping
    public Result updateOne(@RequestBody User user){
        boolean flag;
        flag = user.getId() == 1 || user.getId() == 2 || user.getId() == 3;

        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag);
    }

    @PostMapping
    public Result addOne(User user){
        boolean flag;
        flag = user.getId() != 1 && user.getId() != 2 && user.getId() != 3;
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag);
    }
}
