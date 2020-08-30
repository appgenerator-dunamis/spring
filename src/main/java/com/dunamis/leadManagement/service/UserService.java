package  com.dunamis.leadManagement.service;
import  com.dunamis.leadManagement.domain.User;
import  com.dunamis.leadManagement.domain.Person;
import java.util.List;

public interface UserService {
    public User findById(Integer id);
    public User saveUser(User user_1);
    public List<User> findAll();
    public Person getPerson();
  //  public List<User> findAllByPersonId(Integer  person);
}