package com.example.galleryservice.controllers;

import com.example.galleryservice.entities.Gallery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/")
public class MainController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Environment env;

    @RequestMapping("/")
    public String home() {
        // This is useful for debugging
        // When having multiple instance of gallery service running at different ports.
        // We load balance among them, and display which instance received the request.
        return "Hello from Gallery Service running at port: " + env.getProperty("local.server.port");
    }

    @RequestMapping("/{id}")
    public Gallery getGallery(@PathVariable final int id) {
        // create gallery object
        Gallery gallery = new Gallery();
        gallery.setId(id);

        /*
            Get list of available images:
            Since we are using restTemplate — which in turn uses Eureka Server for naming of services,
            and Ribbon for load balancing. So, we can use the service name like "image-service" instead of "localhost:port"
         */
        List<Object> images = restTemplate.getForObject("http://image-service/images/", List.class);
        gallery.setImages(images);

        return gallery;
    }

    /*
        -------- Admin Area --------
        This method should only be accessed by users with role of 'admin'
        We'll add the logic of role based auth later
     */
    @RequestMapping("/admin")
    public String homeAdmin() {
        return "This is the admin area of Gallery service running at port: " + env.getProperty("local.server.port");
    }
}
