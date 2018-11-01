package com.halo.blog.mapper;

import com.halo.blog.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
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

    /**
     * 查询文章归档信息 根据年份
     *
     * @return List
     */
    @Query(value = "select year(post_date) as year,count(*) as count from post where post_status=0 and post_type='post' group by year(post_date) order by year desc", nativeQuery = true)
    List<Object[]> findPostGroupByYear();


    /**
     * 根据年份查询文章
     *
     * @param year year
     * @return List
     */
    @Query(value = "select *,year(post_date) as year from post where post_status=0 and post_type='post' and year(post_date)=:year order by post_date desc", nativeQuery = true)
    List<Post> findPostByYear(@Param("year") String year);


    /**
     * 根据路径查询文章
     *
     * @param postUrl  路径
     * @param postType post or page
     * @return Post
     */
    Post findPostByPostUrlAndPostType(String postUrl, String postType);


    /**
     * 查询之后文章
     *
     * @param postDate   发布时间
     * @param postStatus 0，1，2
     * @param postType   post or page
     * @return List
     */
    List<Post> findByPostDateAfterAndPostStatusAndPostTypeOrderByPostDateDesc(Date postDate, Integer postStatus, String postType);


    /**
     * 查询之前的文章
     *
     * @param postDate   发布时间
     * @param postStatus 0，1，2
     * @param postType   post or page
     * @return List
     */
    List<Post> findByPostDateBeforeAndPostStatusAndPostTypeOrderByPostDateAsc(Date postDate, Integer postStatus, String postType);


    /**
     * 查询所有文章 根据文章类型
     *
     * @param postType post or page
     * @return List
     */
    List<Post> findPostsByPostType(String postType);

}
