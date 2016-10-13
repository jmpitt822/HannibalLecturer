package com.theironyard.controllers;

import com.theironyard.entities.Lecturer;
import com.theironyard.entities.Review;
import com.theironyard.services.LecturerRepository;
import com.theironyard.services.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;


@RestController
public class HannibalLecturerController {
    @Autowired
    LecturerRepository lecturers;

    @Autowired
    ReviewRepository reviews;

    @RequestMapping(path = "/lecturers", method = RequestMethod.GET)
    public List<Lecturer> getLecturers(){
        return (List<Lecturer>) lecturers.findAll();
    }

    @RequestMapping(path = "/lecturers", method = RequestMethod.POST)
    public void createLecturer(HttpSession session, HttpServletResponse response, String name, String topic, String image) {
        Lecturer lecturer = new Lecturer(name, topic, image);
        lecturers.save(lecturer);
    }

    @RequestMapping(path = "/reviews{lecturerId}", method = RequestMethod.GET)
    public List<Review> getReviews(int lecturerId){
        return (List<Review>) reviews.findByLecturerId(lecturerId);
    }

    @RequestMapping(path = "/reviews", method = RequestMethod.POST)
    public void createReview(String author, String text, int lecturerId, boolean isGood) {
        Review review = new Review(author, text, isGood, lecturerId);
        reviews.save(review);
    }
}
