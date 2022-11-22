package mik.tarnavskyi.iprovider.model.service;

import java.util.List;


import lombok.AllArgsConstructor;
import mik.tarnavskyi.iprovider.model.dao.TariffPlanRepository;
import mik.tarnavskyi.iprovider.domain.entity.TariffPlan;
import mik.tarnavskyi.iprovider.domain.dto.request.TariffPlanRequestDto;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TariffPlanService {
    private TariffPlanRepository tariffPlanRepository;
    private ServiceService serviceService;

    public TariffPlan updateTariffPlan(Long id, TariffPlanRequestDto dto) {
        TariffPlan tariffPlan = buildTariffPlan(dto);
        tariffPlan.setId(id);
        return tariffPlanRepository.save(tariffPlan);
    }

    public TariffPlan findById(Long id) {
        return tariffPlanRepository.findById(id).orElseThrow();
    }

    public boolean deleteTariffPlan(Long id) {
        tariffPlanRepository.deleteById(id);
        return true;
    }

    public TariffPlan addTariffPlan(TariffPlanRequestDto dto) {
        return tariffPlanRepository.save(buildTariffPlan(dto));
    }

    public List<TariffPlan> getAllSortedBy(String fieldBy, String order) {
        return tariffPlanRepository.findAll(Sort.by(Sort.Direction.fromString(order), fieldBy));
    }

    private TariffPlan buildTariffPlan(TariffPlanRequestDto dto) {
        return TariffPlan.builder()
            .title(dto.getTitle())
            .description(dto.getDescription())
            .price(dto.getPrice())
            .service(serviceService.getById(dto.getServiceId()))
            .build();
    }
}
