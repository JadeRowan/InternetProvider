package mik.tarnavskyi.iprovider.model.service;

import lombok.AllArgsConstructor;
import mik.tarnavskyi.iprovider.model.dao.ServiceRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ServiceService {
    private final ServiceRepository serviceRepository;

    public mik.tarnavskyi.iprovider.domain.entity.Service getById(Long serviceId) {
        return serviceRepository.findById(serviceId).orElseThrow();
    }
}
