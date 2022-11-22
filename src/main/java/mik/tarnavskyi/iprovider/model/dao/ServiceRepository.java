package mik.tarnavskyi.iprovider.model.dao;

import mik.tarnavskyi.iprovider.domain.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Long> {
}
