package com.theironyard.services;

import com.theironyard.entities.Lecturer;
import com.theironyard.entities.Review;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by jeremypitt on 10/13/16.
 */
public interface LecturerRepository extends CrudRepository<Lecturer, Integer> {

}
