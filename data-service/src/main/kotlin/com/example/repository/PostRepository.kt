package com.example.repository

import com.example.domain.Post
import org.springframework.data.repository.PagingAndSortingRepository

interface PostRepository : PagingAndSortingRepository<Post, Long> {}
