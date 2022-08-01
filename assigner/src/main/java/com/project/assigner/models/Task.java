package com.project.assigner.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;
import org.apache.tomcat.jni.Local;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@ToString
public class Task {
    @Id
    @SequenceGenerator(
            name = "task_sequence",
            sequenceName = "task_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "task_sequence"
    )
    @Column(name = "task_id")
    private Long id;
    @Column(name = "taskText")
    private String taskText;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @CreationTimestamp
    private Date creationDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "status_id", nullable = false, referencedColumnName = "status_id")
    @JsonBackReference
    private Status status;

    @ManyToOne(optional = false)
    @JoinColumn(name = "project_id",nullable = false, referencedColumnName = "project_id")
    @JsonBackReference
    private Project project;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id",nullable = false, referencedColumnName = "user_id")
    @JsonBackReference
    private User user;


}
