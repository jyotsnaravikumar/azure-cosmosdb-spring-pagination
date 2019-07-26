package com.microsoft.azure.cosmosdb.pagination.volcano.service;

import com.microsoft.azure.cosmosdb.pagination.volcano.model.Volcano;
import com.microsoft.azure.cosmosdb.pagination.volcano.repository.VolcanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VolcanoService {

    @Autowired
    private VolcanoRepository repository;

    public Optional<Volcano> getVolcanoById(String id) {
        Optional<Volcano> volcano = repository.findById(id);
        return volcano;

    }

    public List<Volcano> getAllVolcanoes() {
        List<Volcano> volcanoes = (List<Volcano>) repository.findAll();
        return volcanoes;

    }

    public List<Volcano> getAllVolcanoesByPage(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Volcano> pagedResult = repository.findAll(paging);
        if(pagedResult.hasContent()) {
            System.out.println("content "+ pagedResult.getContent());
            return pagedResult.getContent();
        } else {
            return new ArrayList<Volcano>();
        }
    }
}
