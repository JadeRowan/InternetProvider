package mik.tarnavskyi.iprovider.model.dao;

import mik.tarnavskyi.iprovider.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
