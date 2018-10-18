package com.halo.blog.service;

import com.halo.blog.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * <pre>
 *     文章/页面业务逻辑接口
 * </pre>
 * @author tangwei
 * @date 2018/10/12 10:58
 */
public interface PostService {

    /**
     * 新增文章
     *
     * @param post Post
     * @return Post
     */
    Post saveByPost(Post post);


    /**
     * 根据编号删除文章
     *
     * @param postId postId
     * @return Post
     */
    Post removeByPostId(Long postId);

    /**
     * 修改文章状态
     *
     * @param postId postId
     * @param status status
     * @return Post
     */
    Post updatePostStatus(Long postId, Integer status);


    /**
     * 根据文章状态查询 分页，首页分页
     *
     * @param pageable pageable
     * @return Page
     */
    Page<Post> findPostByStatus(Pageable pageable);

    /**
     * 根据编号查询文章
     *
     * @param postId postId
     * @return Post
     */
    Optional<Post> findByPostId(Long postId);


    /**
     * 查询前五条数据
     *
     * @return List
     */
    List<Post> findPostLatest();


    /**
     * 获取所有文章的阅读量
     *
     * @return Long
     */
    Long getPostViews();



    /**
     * 根据文章状态查询
     *
     * @param status   0，1，2
     * @param postType post or page
     * @return List
     */
    List<Post> findPostByStatus(Integer status, String postType);

}
