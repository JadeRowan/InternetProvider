package mik.tarnavskyi.iprovider.domain.dto.response;

import lombok.Data;

@Data
public class TariffPlanResponseDto {
    private Long id;
    private String title;
    private String description;
    private Double price;
}
