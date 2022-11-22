package mik.tarnavskyi.iprovider.dao;

import mik.tarnavskyi.iprovider.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
