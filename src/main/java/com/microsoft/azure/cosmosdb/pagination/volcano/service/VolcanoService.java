package com.microsoft.azure.cosmosdb.pagination.volcano.service;

import com.microsoft.azure.cosmosdb.pagination.volcano.model.Volcano;
import com.microsoft.azure.cosmosdb.pagination.volcano.repository.VolcanoRepository;
import com.microsoft.azure.spring.data.cosmosdb.core.query.DocumentDbPageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
public class VolcanoService {

    @Autowired
    private VolcanoRepository repository;



    public List<Volcano> getAllVolcanoesByPage(Integer pageNo, Integer pageSize, String sortBy) {
        final Pageable pageable = new DocumentDbPageRequest(0, pageSize, null);
        List<Volcano> content = null;

        Page<Volcano> page = this.repository.findAll(pageable);
        if (pageNo == 0) {
            content = page.getContent();
            for (Volcano volcano : content) System.out.println(volcano.toString());
            return content;
        } else {
            Page<Volcano> nextPage = null;
            for (int i = 1; i <= pageNo; i++) {
                nextPage = this.repository.findAll(page.getPageable());
                /* reset page to nextpage like a linkedlist*/
                page = nextPage;
                content = nextPage.getContent();
                for (Volcano volcano : content) System.out.println(volcano.toString());
            }
            return content;
        }
    }

    public List<Volcano> getAllVolcanoes() {
        return (List<Volcano>) repository.findAll();
    }

    public Optional<Volcano> getVolcanoById(String volcanoId) {
        if (StringUtils.isEmpty(volcanoId)) {
            throw new NullPointerException("volcanoId cannot be empty or null");
        }
        Optional<Volcano> volcano = repository.findById(volcanoId);
        if (volcanoId.isEmpty()) {
            return Optional.empty();
        } else {
            return volcano;
        }
    }
}


