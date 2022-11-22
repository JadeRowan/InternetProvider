package mik.tarnavskyi.iprovider.model.dto.request;

import lombok.Data;

@Data
public class TariffPlanRequestDto {
    private String title;
    private String description;
    private Double price;
    private Long serviceId;
}
