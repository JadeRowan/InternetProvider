package mik.tarnavskyi.iprovider.service;

import lombok.AllArgsConstructor;
import mik.tarnavskyi.iprovider.dao.ServiceRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ServiceService {
    private final ServiceRepository serviceRepository;

    public mik.tarnavskyi.iprovider.model.Service getById(Long serviceId) {
        return serviceRepository.findById(serviceId).orElseThrow();
    }
}
