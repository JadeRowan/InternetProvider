package mik.tarnavskyi.iprovider.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import mik.tarnavskyi.iprovider.model.dto.request.UserRequestDto;
import mik.tarnavskyi.iprovider.service.UserService;
import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final ModelMapper modelMapper;

    @PatchMapping("/{id}/add-balance")
    public void addBalance(@PathVariable Long id, @RequestBody String addAmountJson) {
        Double addAmount = new JSONObject(addAmountJson).getDouble("addAmount");
        userService.addBalance(id, addAmount);
    }

    @PostMapping
    public void addUser(@RequestBody UserRequestDto userRequestDto) {
        userService.addUser(userRequestDto.getLogin());
    }

    @PostMapping("/{id}/add-tariff")
    public void addService(@PathVariable(name = "id") Long userId, @RequestBody String tariffIdJson) {
        Long tariffId = new JSONObject(tariffIdJson).getLong("tariffId");
        userService.addService(userId, tariffId);
    }

    @PostMapping("/{id}/block")
    public void blockUser(@PathVariable Long id) {
        userService.setIsBlocked(id, true);
    }

    @PostMapping("/{id}/unblock")
    public void unblockUser(@PathVariable Long id) {
        userService.setIsBlocked(id, false);
    }
}
