package mik.tarnavskyi.iprovider.model.dto.response;

import lombok.Data;

@Data
public class TariffPlanResponseDto {
    private Long id;
    private String title;
    private String description;
    private Double price;
}
