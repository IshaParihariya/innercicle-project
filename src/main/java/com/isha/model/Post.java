package com.isha.model;

import jakarta.persistence.*;

@Entity(name = "posts")
public class Post
{
    // Post Model
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_number")
    private Integer id;
    @Column(name="post")
    private String post;

    // zero param constructor
    public Post()
    {
        System.out.println("zero param constructor");
    }
    // getter setter
    public Integer getId()
    {
        return id;
    }
    public String getPost()
    {
        return post;
    }

    public void setId(Integer id)
    {
        this.id=id;
    }
    public void setPost(String post)
    {
        this.post=post;
    }

    @Override
    public String toString()
    {
        return "Posts : [ post_number = "+id+" post = "+post+" ]";
    }
}
