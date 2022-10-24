package shool.Repositories.Interface;

import shool.Entities.User;

public interface IUser {
    public User findUserByLoginAndPassword(String login, String password);
    
}
