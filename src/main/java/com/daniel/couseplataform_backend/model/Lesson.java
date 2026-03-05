package com.daniel.couseplataform_backend.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_lessons")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_module_id")
    private CourseModule courseModule;

    @Column(nullable = false)
    private String title;

    private String description;

    @Column(nullable = false, name = "youtube_url")
    private String youtubeUrl;

    @Column(nullable = false, name = "duration_seconds")
    private Integer durationSeconds;

    @Column(nullable = false, name = "thumbnail_url")
    private String thumbnailUrl;

    @Column(nullable = false, name = "order_index")
    private Integer orderIndex;

    @Column(nullable = false, name = "created_at", updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
}
