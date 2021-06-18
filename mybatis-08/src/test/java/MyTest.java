import com.dmy.dao.BlogMapper;
import com.dmy.pojo.Blog;
import com.dmy.utils.IDUtils;
import com.dmy.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MyTest {
    @Test
    public void addInitBlog(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setId(IDUtils.getID());
        blog.setTitle("Mybatis如此简单");
        blog.setAuthor("狂神说");
        blog.setCreateTime(new Date());
        blog.setViews(9999);

        blogMapper.addBlog(blog);

        blog.setId(IDUtils.getID());
        blog.setTitle("Java如此简单");
        blogMapper.addBlog(blog);

        blog.setId(IDUtils.getID());
        blog.setTitle("Spring如此简单");
        blogMapper.addBlog(blog);

        blog.setId(IDUtils.getID());
        blog.setTitle("微服务如此简单");
        blogMapper.addBlog(blog);

        sqlSession.close();
    }

    @Test
    public void queryBlogIF(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
//        map.put("title","Java如此简单");
        map.put("author","狂神说");

        List<Blog> blogs = mapper.queryBlogIF(map);

        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        sqlSession.close();
    }

    @Test
    public void queryBlogChoose(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
//        map.put("title","Java如此简单");
        map.put("author","狂神说");
        map.put("views",9999);

        List<Blog> blogs = mapper.queryBlogChoose(map);

        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        sqlSession.close();
    }

    @Test
    public void updateBlog(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        map.put("title","Mybatis如此简单");
        map.put("author","狂神说");
        map.put("id","c0f9cf0f61864745890a5cb14b0fcdb0");
//        map.put("views",9999);

        mapper.updateBlog(map);

        sqlSession.close();
    }

    @Test
    public void queryBlogForeach(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();

        ArrayList<String> ids = new ArrayList<String>();
        map.put("ids",ids);
        ids.add("c0f9cf0f61864745890a5cb14b0fcdb0");
        ids.add("81847d22107441b49f5e509eb3b12443");
        ids.add("0a6cce8d50604f9abe64a4b79b315a1d");

        List<Blog> blogList = mapper.queryBlogForeach(map);

        for (Blog blog : blogList) {
            System.out.println(blog);
        }

        sqlSession.close();
    }
}
