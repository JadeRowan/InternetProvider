package mik.tarnavskyi.iprovider.model.dao;

import mik.tarnavskyi.iprovider.domain.entity.TariffPlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TariffPlanRepository extends JpaRepository<TariffPlan, Long> {
}
