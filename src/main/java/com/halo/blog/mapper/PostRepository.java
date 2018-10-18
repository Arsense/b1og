package com.halo.blog.mapper;

import com.halo.blog.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author tangwei
 * @date 2018/10/12 11:01
 */
public interface PostRepository extends JpaRepository<Post, Long> {

    /**
     * 根据文章的状态查询 分页
     *
     * @param status   0，1，2
     * @param postType post or page
     * @param pageable 分页信息
     * @return Page
     */
    Page<Post> findPostsByPostStatusAndPostType(Integer status, String postType, Pageable pageable);


    /**
     * 查询前五条文章
     *
     * @return List
     */
    @Query(value = "SELECT * FROM post where post_type='post' ORDER BY post_date DESC LIMIT 5", nativeQuery = true)
    List<Post> findTopFive();



    /**
     * 获取所有文章阅读量总和
     *
     * @return Long
     */
    @Query(value = "select sum(post_views) from post", nativeQuery = true)
    Long getPostViewsSum();


    /**
     * 根据文章的状态查询
     *
     * @param status   0,1,2
     * @param postType post or page
     * @return List
     */
    List<Post> findPostsByPostStatusAndPostType(Integer status, String postType);




}
