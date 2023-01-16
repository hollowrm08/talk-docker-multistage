package com.example.demo.repository;

import com.example.demo.domain.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Integer> {

    //Todo: Create logic to listTopics

}
