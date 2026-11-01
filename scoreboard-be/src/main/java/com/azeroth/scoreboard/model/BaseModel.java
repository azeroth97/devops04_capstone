package com.azeroth.scoreboard.model;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class BaseModel {
  @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  
  @Column(name = "created_at")
  @JsonIgnore  
  private LocalDateTime createdAt;
  
  @Column(name = "updated_at")
  @JsonIgnore
  private LocalDateTime updatedAt;
}
