package com.example.clientsservice.services.data.db.address;

import com.example.clientsservice.models.address.Region;
import com.example.clientsservice.repositories.address.RegionRepository;
import com.example.clientsservice.services.data.address.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionServiceDb implements RegionService {
    @Autowired
    private RegionRepository regionRepository;

    @Override
    public Region save(Region region) {
        return regionRepository.save(region);
    }

    @Override
    public List<Region> saveAll(List<Region> regions) {
        List<Region> list = regionRepository.saveAll(regions);
        return list.size() > 0 ? list : null;
    }

    @Override
    public Region getReferenceById(int i) {
        return regionRepository.getReferenceById(i);
    }

    @Override
    public List<Region> findAll() {
        List<Region> list = regionRepository.findAll();
        return list.size() > 0 ? list : null;
    }

    @Override
    public Region findById(Integer id) {
        return regionRepository.findById(id).orElse(null);
    }

    @Override
    public Region findByName(String region) {
        Region reg = new Region();
        reg.setRegion(region);
        Example<Region> example = Example.of(reg);
        return regionRepository.findBy(example, FluentQuery.FetchableFluentQuery::first).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        regionRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        regionRepository.deleteAll();
    }
}
