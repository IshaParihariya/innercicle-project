package com.isha.service;

import com.isha.dao.CreatePostDao;

public class CreatePostService
{
    public void postService(String post)
    {
        // if post didnt reach the server or is null
        // if(post.trim().isEmpty()||post==null)
        // If post is null → .trim() will crash
        if(post == null || post.trim().isEmpty())
        {
            throw new IllegalArgumentException("enter something");
        }

        // object of CreatePostDao
        CreatePostDao createPostDao=new CreatePostDao();
        createPostDao.postDao(post);
    }
}
