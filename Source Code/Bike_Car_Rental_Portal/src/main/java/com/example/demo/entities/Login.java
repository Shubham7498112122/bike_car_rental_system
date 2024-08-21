package com.example.demo.entities;
import jakarta.persistence.*;

@Entity
@Table(name = "login")
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "username", nullable = false, length = 100)
    private String username;

    @Column(name = "password", nullable = false, length = 100, unique = true)
    private String password;

    @Column(name = "active_status", nullable = false, length = 100)
    private String activeStatus;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    // Getters and setters
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getActiveStatus() { return activeStatus; }
    public void setActiveStatus(String activeStatus) { this.activeStatus = activeStatus; }

    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }

    // Constructors
    public Login() {}

    public Login(String username, String password, String activeStatus, Role role) {
        this.username = username;
        this.password = password;
        this.activeStatus = activeStatus;
        this.role = role;
    }
}
