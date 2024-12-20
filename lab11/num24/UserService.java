package lab11.num24;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void registerUser(String name, String email) throws SQLException {
        if (!userDAO.emailExists(email)) {
            userDAO.create(new User(name, email));
        } else {
            throw new IllegalArgumentException("Email уже существует.");
        }
    }

    public List<User> listAllUsers() throws SQLException {
        return userDAO.findAll();
    }

    public void deleteUser(int id) throws SQLException {
        if (userDAO.findById(id) != null) {
            userDAO.delete(id);
        } else {
            throw new IllegalArgumentException("Пользователь не найден.");
        }
    }

    public void updateUser(int id, String newName, String newEmail) throws SQLException {
        if (userDAO.findById(id) != null) {
            userDAO.update(new User(id, newName, newEmail));
        } else {
            throw new IllegalArgumentException("Пользователь  не найден.");
        }
    }
}
