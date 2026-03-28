package com.isha.model;


import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;

@Entity
@Table(name = "users")
public class UserRegistration
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;
    @Column(nullable = false)
    private String name;
    @Column(unique = true,nullable = false) // email cannot be null and need to be unique
    private String email;
    @Column(nullable = false)
    // use hashing like BCrypt in real big projects for password but here we're learning so took it as String
    private String password;
    private String bio;
    //@Lob// Hibernate sometimes treats @Lob as OID instead of bytea in PostgreSQL so removed as error
    // for MySQL @Column(columnDefinition = "LONGBLOB")
    // error was here
    //This is a Hibernate-specific annotation (not JPA).
    @JdbcTypeCode(org.hibernate.type.SqlTypes.BINARY) // Hey, don’t guess the datatype, treat this as binary data (bytea) in PostgreSQL.
    // for Postgre
    @Column(columnDefinition = "BYTEA")
    private byte[] profilePicture=null;

    // zero para constructor
    public UserRegistration()
    {
        System.out.println("Zero param constructor of UserRegistration");
    }
    // getter setters
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name=name;
    }

    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email=email;
    }

    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password)
    {
        this.password=password;
    }

    public String getBio()
    {
        return bio;
    }
    public void setBio(String bio)
    {
        this.bio=bio;
    }

    public byte[] getProfilePicture()
    {
        return profilePicture;
    }
    public void setProfilePicture(byte[] profilePicture)
    {
        this.profilePicture=profilePicture;
    }

}