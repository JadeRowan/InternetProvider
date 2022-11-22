package mik.tarnavskyi.iprovider.dao;

import mik.tarnavskyi.iprovider.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Long> {
}
