package com.example.RestaurantManagement.Respository;

import com.example.RestaurantManagement.Model.Viewer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IViewerRepo extends JpaRepository<Viewer , Long> {
}
