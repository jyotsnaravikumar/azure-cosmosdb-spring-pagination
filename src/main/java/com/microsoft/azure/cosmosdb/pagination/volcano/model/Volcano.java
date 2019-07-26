package com.microsoft.azure.cosmosdb.pagination.volcano.model;

import com.microsoft.azure.cosmosdb.pagination.Constants;
import com.microsoft.azure.spring.data.cosmosdb.core.mapping.Document;
import com.microsoft.azure.spring.data.cosmosdb.core.mapping.PartitionKey;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;


@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@Document(collection = Constants.DEFAULT_VOLCANO_COLLECTION_NAME)

public class Volcano {

    @Id
    private String id;

    private String volcanoName;

    private String country;

    private String region;

    private Location location;

    private Integer elevation;

    @PartitionKey
    private String type;

    private String status;

    private String lastKnownEruption;


    public String getVolcanoName() {
        return volcanoName;
    }

    public void setVolcanoName(String volcanoName) {
        this.volcanoName = volcanoName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Integer getElevation() {
        return elevation;
    }

    public void setElevation(Integer elevation) {
        this.elevation = elevation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLastKnownEruption() {
        return lastKnownEruption;
    }

    public void setLastKnownEruption(String lastKnownEruption) {
        this.lastKnownEruption = lastKnownEruption;
    }


}