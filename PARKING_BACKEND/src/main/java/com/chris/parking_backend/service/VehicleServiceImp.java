package com.chris.parking_backend.service;

import com.chris.parking_backend.model.Vehicle;
import com.chris.parking_backend.exception.ResourceNotFoundException;
import com.chris.parking_backend.repository.VehicleRepo;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImp implements VehicleService{

    private final VehicleRepo vehicleRepo;

    public VehicleServiceImp(VehicleRepo vehicleRepo) {
        this.vehicleRepo = vehicleRepo;
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepo.findAll();
    }

    @Override
    public Vehicle createVehicle(Vehicle vehicle) {
        return vehicleRepo.save(vehicle);
    }

    @Override
    public Vehicle updateVehicle(long id, Vehicle vehicle) throws ResourceNotFoundException {
        Vehicle vehicle1 = vehicleRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("vehicle", "id", id));
        vehicle1.setTitle(vehicle.getTitle());
        vehicle1.setDescription(vehicle.getDescription());
        vehicle1.setContent(vehicle.getContent());
        return vehicleRepo.save(vehicle1);
    }

    @Override
    public void deleteVehicle(long id) throws ResourceNotFoundException {
        Vehicle vehicle = vehicleRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("vehicle", "id", id));
        vehicleRepo.delete(vehicle);
    }


    @Override
    public Vehicle getVehicleById(long id) throws ResourceNotFoundException {
        Optional<Vehicle> vehicle = vehicleRepo.findById(id);
        if(vehicle.isPresent()){
            return vehicle.get();
        }else {
            throw new ResourceNotFoundException("vehicle", "id", id);
        }
    }



    //private final PostResository postRepository;



/*
    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post updatePost(long id, Post postRequest) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));

        post.setTitle(postRequest.getTitle());
        post.setDescription(postRequest.getDescription());
        post.setContent(postRequest.getContent());
        return postRepository.save(post);
    }

    @Override
    public void deletePost(long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));

        postRepository.delete(post);
    }

    @Override
    public Post getPostById(long id) {
        Optional<Post> result = postRepository.findById(id);
        if(result.isPresent()) {
            return result.get();
        }else {
            throw new ResourceNotFoundException("Post", "id", id);
        }

 */

//		Post post = postRepository.findById(id)
//				.orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        //return post;
//}
}
