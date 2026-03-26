package com.isha.service;

import com.isha.dao.GetPostDao;
import com.isha.model.Post;

import java.util.List;

public class GetPostService
{
    public List<Post> getPost()
    {
        // Dao object
        GetPostDao getPostDao=new GetPostDao();
         return getPostDao.getPost();
    }
}
