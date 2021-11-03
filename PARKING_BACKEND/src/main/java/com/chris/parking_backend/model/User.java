package com.chris.parking_backend.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User {
    @Id
    private String username;
    private String userPassword;
    private String changeUserPassword;
    private String userEmailVerification;

    /*
    boolean isactive
     */

    @CreationTimestamp
    private Timestamp dateCreated;

    @UpdateTimestamp
    private Timestamp dateUpdated;

    @ManyToOne(cascade = CascadeType.ALL,
            targetEntity = Role.class,
            fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
    joinColumns = @JoinColumn(name = "username"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Role role;

    public User(String username, Timestamp dateCreated, Timestamp dateUpdated, Role role) {
        this.username = username;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.role = role;
    }
}
