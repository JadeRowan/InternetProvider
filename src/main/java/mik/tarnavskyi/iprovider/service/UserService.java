package mik.tarnavskyi.iprovider.service;

import java.util.ArrayList;


import lombok.AllArgsConstructor;
import mik.tarnavskyi.iprovider.dao.UserRepository;
import mik.tarnavskyi.iprovider.model.TariffPlan;
import mik.tarnavskyi.iprovider.model.User;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserService {
    public static final String USER_ROLE = "USER";
    private UserRepository userRepository;
    private TariffPlanService tariffPlanService;

    public User addUser(String login) {
        return userRepository.save(buildUser(login));
    }

    //todo test that rewrite instead of add new user
    public User addBalance(Long id, Double addAmount) {
        User user = userRepository.findById(id).orElseThrow();
        user.setBalance(user.getBalance() + addAmount);
        return userRepository.save(user);
    }

    public User addService(Long userId, Long tariffId) {
        User user = userRepository.findById(userId).orElseThrow();
        TariffPlan tariffPlan = tariffPlanService.findById(tariffId);
        user.getTariffPlans().add(tariffPlan);
        return userRepository.save(user);
    }

    public User setIsBlocked(Long id, Boolean isBlocked) {
        User user = userRepository.findById(id).orElseThrow();
        user.setIsBlocked(isBlocked);
        return userRepository.save(user);
    }

    private User buildUser(String login) {
        return User.builder()
            .login(login)
            .balance(0.0)
            .role(USER_ROLE)
            .isBlocked(false)
            .tariffPlans(new ArrayList<>())
            .build();
    }

}
