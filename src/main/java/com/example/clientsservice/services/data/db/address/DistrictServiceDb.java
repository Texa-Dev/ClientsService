package com.example.clientsservice.services.data.db.address;

import com.example.clientsservice.models.adress.District;
import com.example.clientsservice.repositories.address.DistrictRepository;
import com.example.clientsservice.services.data.address.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DistrictServiceDb implements DistrictService {
    @Autowired
    private DistrictRepository districtRepository;

    @Override
    public District save(District district) {
        return districtRepository.save(district);
    }

    @Override
    public List<District> saveAll(List<District> districts) {
        return districtRepository.saveAll(districts);
    }

    @Override
    public District getReferenceById(int i) {
        return districtRepository.getReferenceById(i);
    }

    @Override
    public District findByid(Integer id) {
        return districtRepository.findById(id).orElse(null);
    }

    @Override
    public List<District> findAll() {
        List<District> list = districtRepository.findAll();
        return list.size() > 0 ? list : null;
    }

    @Override
    public District findByName(String district) {
        District dist=new District();
        dist.setDistrict(district);
        Example<District> example = Example.of(dist);
        return districtRepository.findBy(example, FluentQuery.FetchableFluentQuery::first).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        districtRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        districtRepository.deleteAll();
    }
}
