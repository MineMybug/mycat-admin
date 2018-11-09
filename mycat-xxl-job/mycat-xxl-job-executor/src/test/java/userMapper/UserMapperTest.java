/**   
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>    
* @date 2018年11月9日  
* @version 1.0  
*/
package userMapper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.MineMybug.security.xxl.job.executor.mapper.UserMapper;
import com.github.MineMybug.security.xxl.job.executor.model.User;

/**   
* <p>Description: </p>  
* @author ruanhang  
* @date 2018年11月9日  
*/
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserMapperTest {
	
	@Autowired
    private UserMapper userMapper;

    @Test
    public void save() {
        User user = new User();
        user.setUsername("zzzz");
        user.setPassword("bbbb");
        user.setSex(1);
        user.setAge(18);
        // 返回插入的记录数 ，期望是1条 如果实际不是一条则抛出异常
        Assert.assertEquals(1,userMapper.save(user));
    }

    @Test
    public void update() {
        User user = new User();
        user.setId(1L);
        user.setPassword("newpassword");
        // 返回更新的记录数 ，期望是1条 如果实际不是一条则抛出异常
        Assert.assertEquals(1,userMapper.update(user));
    }

    @Test
    public void selectById() {
        Assert.assertNotNull(userMapper.selectById(1));
    }

    @Test
    public void deleteById() {
        Assert.assertEquals(1,userMapper.deleteById(1));
    }

}
