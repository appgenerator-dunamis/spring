package  com.dunamis.leadManagement.service;
import  com.dunamis.leadManagement.domain.Role;
import java.util.List;

public interface RoleService {
    public Role findById(Integer id);
    public void saveRole(Role role);
    public List<Role> findAll();
  //  public List<User> findAllByPersonId(Integer  person);
}