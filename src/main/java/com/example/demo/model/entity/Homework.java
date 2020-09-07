package com.example.demo.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "homework")
public class Homework extends BaseEntity {

    private LocalDateTime addedOn;
    private String gitAddress;
    private User author;
    private Exercise exercise;

    public Homework() {
    }

    @Column(name = "added_on", nullable = false)
    public LocalDateTime getAddedon() {
        return addedOn;
    }

    public void setAddedon(LocalDateTime addedon) {
        this.addedOn = addedOn;
    }

    @Column(name = "git_address", nullable = false, unique = true)
    public String getGitAddress() {
        return gitAddress;
    }

    public void setGitAddress(String gitAddress) {
        this.gitAddress = gitAddress;
    }

    //one user can make many different homeworks
    //many homeworks can have one user
    @ManyToOne
    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    //many homeworks can have that one excercise;
    //one exercise can be in many different homeworks
    @ManyToOne
    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }
}
