package com.pam.jedis.test;


import com.pam.jedis.JedisPoolUtil;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Map;
import java.util.Set;


/**
 * Jedis 测试类
 */

public class JedisTest {
    /**
     * 快速入门
     */
    @Test
    public void test1(){
        //1.获取链接
        Jedis jedis = new Jedis("localhost",6379);
        //2.操作
        jedis.set("username","马云");
        //3.关闭链接
        jedis.close();

    }


    @Test
    public void test2(){
        Jedis jedis = new Jedis();
        jedis.set("name","mayun");
        String userName = jedis.get("name");
        System.out.println(userName);

        jedis.setex("activecode",20,"hehe");

        jedis.close();
    }

    @Test
    public void test3(){
        Jedis jedis = new Jedis();
        jedis.hset("user","name","lisi");
        jedis.hset("user","age","23");
        jedis.hset("user","gender","male");

        //获取hash
        String name = jedis.hget("user","name");
        System.out.println(name);

        //获取hash中的map所有数据
        Map<String,String> user = jedis.hgetAll("user");

        Set<String> keySet = user.keySet();
        for (String key : keySet){
            String value = user.get(key);
            System.out.println(key+":"+ value);
        }

        jedis.close();


    }

    @Test
    public void jedisP(){
        JedisPool jedisPool = new JedisPool();
        Jedis jedis  = jedisPool.getResource();
        jedis.set("haha","haha");
        jedis.close();

    }
    @Test
    public void jp(){
        Jedis jedis = JedisPoolUtil.getJedis();

        jedis.set("hello","word");
        String value = jedis.get("hello");
        System.out.println(value);
        jedis.close();
    }

}
