package com.halo.blog.service.impl;

import com.halo.blog.domain.Archive;
import com.halo.blog.domain.Post;
import com.halo.blog.enums.PostStatusEnum;
import com.halo.blog.enums.PostTypeEnum;
import com.halo.blog.mapper.PostRepository;
import com.halo.blog.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author tangwei
 * @date 2018/10/12 10:58
 */
@Service
public class PostServiceImpl implements PostService{
    @Resource
    private PostRepository postRepository;
    /**
     * 保存文章
     *
     * @param post Post
     * @return Post
     */
    @Override
    public Post saveByPost(Post post) {
        return postRepository.save(post);
    }
    @Override
    public Post removeByPostId(Long postId) {
        Optional<Post> post = this.findByPostId(postId);
        postRepository.delete(post.get());
        return post.get();
    }

    @Override
    public Post updatePostStatus(Long postId, Integer status) {
        return null;
    }

    @Override
    public Page<Post> findPostByStatus(Pageable pageable) {
        return postRepository.findPostsByPostStatusAndPostType(PostStatusEnum.PUBLISHED.getCode(), PostTypeEnum.POST_TYPE_POST.getDesc(), pageable);
    }

    /**
     * 根据编号查询文章
     *
     * @param postId postId
     * @return Optional
     */
    @Override
    public Optional<Post> findByPostId(Long postId) {
        return postRepository.findById(postId);
    }

    @Override
    public List<Post> findPostLatest() {
        return postRepository.findTopFive();

    }
    @Override
    public Long getPostViews() {
        return postRepository.getPostViewsSum();

    }
    @Override
    public List<Post> findPostByStatus(Integer status, String postType) {
        return postRepository.findPostsByPostStatusAndPostType(status, postType);

    }
    @Override
    public Page<Post> findPostByStatus(Integer status, String postType, Pageable pageable) {
        return postRepository.findPostsByPostStatusAndPostType(status, postType, pageable);
    }

    @Override
    public List<Archive> findPostGroupByYear() {
        List<Object[]> objects = postRepository.findPostGroupByYear();
        List<Archive> archives = new ArrayList<>();
        Archive archive = null;
        for (Object[] obj : objects) {
            archive = new Archive();
            archive.setYear(obj[0].toString());
            archive.setCount(obj[1].toString());
            archive.setPosts(this.findPostByYear(obj[0].toString()));
            archives.add(archive);
        }
        return archives;
    }


    /**
     * 根据年份查询文章
     *
     * @param year year
     * @return List
     */
    @Override
    public List<Post> findPostByYear(String year) {
        return postRepository.findPostByYear(year);
    }

    @Override
    public Post findByPostUrl(String postUrl, String postType) {
        return postRepository.findPostByPostUrlAndPostType(postUrl, postType);

    }

    @Override
    public List<Post> findByPostDateAfter(Date postDate) {
        return postRepository.findByPostDateAfterAndPostStatusAndPostTypeOrderByPostDateDesc(postDate,0,"post");
    }

    @Override
    public List<Post> findByPostDateBefore(Date postDate) {
        return postRepository.findByPostDateBeforeAndPostStatusAndPostTypeOrderByPostDateAsc(postDate, 0, "post");
    }

    @Override
    public void updatePostView(Post post) {
        post.setPostViews(post.getPostViews() + 1);
        postRepository.save(post);
    }
}
