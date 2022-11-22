package mik.tarnavskyi.iprovider.controller;

import java.util.List;
import java.util.stream.Collectors;


import lombok.AllArgsConstructor;
import mik.tarnavskyi.iprovider.model.TariffPlan;
import mik.tarnavskyi.iprovider.model.dto.request.TariffPlanRequestDto;
import mik.tarnavskyi.iprovider.model.dto.response.TariffPlanResponseDto;
import mik.tarnavskyi.iprovider.service.TariffPlanService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/tariff")
public class TariffPlanController {

    private final TariffPlanService tariffPlanService;
    private final ModelMapper mapper;

    @PatchMapping("/{id}")
    public void updateTariffPlan(@PathVariable Long id, @RequestBody TariffPlanRequestDto dto) {
        tariffPlanService.updateTariffPlan(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteTariffPlan(@PathVariable Long id) {
        tariffPlanService.deleteTariffPlan(id);
    }

    @PostMapping
    public void addTariffPlan(@RequestBody TariffPlanRequestDto dto) {
        tariffPlanService.addTariffPlan(dto);
    }

    @GetMapping("/sorted")
    public List<TariffPlanResponseDto> getAllSortedBy(@RequestParam String fieldBy,
                                                      @RequestParam(defaultValue = "ASC", required = false) String order) {
        List<TariffPlan> tariffPlans = tariffPlanService.getAllSortedBy(fieldBy, order);
        return tariffPlans.stream()
            .map(t -> mapper.map(t, TariffPlanResponseDto.class))
            .collect(Collectors.toList());
    }
}
