package mik.tarnavskyi.iprovider.model.dto.response;

import java.util.List;


import lombok.Data;
@Data
public class UserResponseDto {
    private Long id;
    private String login;
    private Boolean isBlocked;
    private List<Long> servicesIds;
}
