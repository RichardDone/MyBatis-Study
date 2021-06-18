import com.dmy.dao.UserMapper;
import com.dmy.pojo.User;
import com.dmy.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyTest {

    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.queryUserByID(1);
        System.out.println(user);

//        mapper.updateUser(new User(2,"aaaa","123456"));

//        sqlSession.clearCache(); //手动清理缓存

        System.out.println("====================");

        User user1 = mapper.queryUserByID(1);
        System.out.println(user1);

        System.out.println(user==user1);

        sqlSession.close();
    }


    @Test
    public void test2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SqlSession sqlSession2 = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);

        User user = mapper.queryUserByID(1);
        System.out.println(user);
        sqlSession.close();


        User user2 = mapper2.queryUserByID(1);
        System.out.println(user2);
        System.out.println(user==user2);
        sqlSession2.close();
    }
}
