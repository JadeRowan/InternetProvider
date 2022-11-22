package mik.tarnavskyi.iprovider.dao;

import mik.tarnavskyi.iprovider.model.TariffPlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TariffPlanRepository extends JpaRepository<TariffPlan, Long> {
}
