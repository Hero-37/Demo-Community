package com.nowcoder.community;

import com.nowcoder.community.util.SensitiveFilter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = DemoCommunityApplication.class)
public class SensitiveTests {

    @Autowired
    private SensitiveFilter sensitiveFilter;

    @Test
    public void testSensitiveFilter() {
        String text = "哪里可以嫖娼，还能吸毒，还可以赌博呢？同时也充满了暴力！";
        text = sensitiveFilter.filter(text);
        System.out.println(text);

        text = "哪里可以⭐嫖⭐娼⭐，还能⭐吸⭐毒⭐，还可以⭐赌⭐博⭐呢？同时也充满了⭐暴⭐力⭐！";
        text = sensitiveFilter.filter(text);
        System.out.println(text);

    }
}
