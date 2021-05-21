import com.dmy.dao.UserMapper;
import com.dmy.pojo.User;
import com.dmy.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {

    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

//        List<User> userList = mapper.getUsers();
//
//        for (User user : userList) {
//            System.out.println(user);
//        }

//        User user = mapper.getUserByID(1);
//        System.out.println(user);

//        mapper.addUser(new User(5,"Hello","123456"));

//        mapper.updateUser(new User(5,"to","222222"));

        mapper.deleteUser(5);

        sqlSession.close();
    }
}
