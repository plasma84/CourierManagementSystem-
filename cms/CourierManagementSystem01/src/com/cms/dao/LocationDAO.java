package com.cms.dao;

import com.cms.entity.Location;
import java.util.List;

public interface LocationDAO {
    void addLocation(Location location);
    Location getLocationById(int locationId);
    List<Location> getAllLocations();
    void updateLocation(Location location);
    void deleteLocation(int locationId);
}
