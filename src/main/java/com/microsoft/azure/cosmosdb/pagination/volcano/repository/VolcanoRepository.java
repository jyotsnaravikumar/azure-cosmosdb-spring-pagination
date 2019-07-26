package com.microsoft.azure.cosmosdb.pagination.volcano.repository;

import com.microsoft.azure.cosmosdb.pagination.volcano.model.Location;
import com.microsoft.azure.cosmosdb.pagination.volcano.model.Volcano;
import com.microsoft.azure.spring.data.cosmosdb.repository.DocumentDbRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface VolcanoRepository extends DocumentDbRepository<Volcano, String> {


}


