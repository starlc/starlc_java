package com.starlc.redis;

import java.util.ArrayList;
import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;



public class RedisClient {

    private Jedis jedis;//非切片额客户端连接
    private JedisPool jedisPool;//非切片连接池
    private ShardedJedis shardedJedis;//切片额客户端连接
    private ShardedJedisPool shardedJedisPool;//切片连接池
    
    public RedisClient() 
    { 
        initialPool(); 
        initialShardedPool(); 
        shardedJedis = shardedJedisPool.getResource(); 
        jedis = jedisPool.getResource(); 
        
        
    } 
 
    /**
     * 初始化非切片池
     */
    private void initialPool() 
    { 
        // 池基本配置 
        JedisPoolConfig config = new JedisPoolConfig(); 
        config.setMaxIdle(20); 
        config.setMaxIdle(5); 
        config.setMaxWaitMillis(1000l); 
        config.setTestOnBorrow(false); 
        
        jedisPool = new JedisPool(config,"192.168.0.110",6379);
    }
    
    /** 
     * 初始化切片池 
     */ 
    private void initialShardedPool() 
    { 
        // 池基本配置 
        JedisPoolConfig config = new JedisPoolConfig(); 
        config.setMaxIdle(20); 
        config.setMaxIdle(5); 
        config.setMaxWaitMillis(1000l); 
        config.setTestOnBorrow(false); 
        // slave链接 
        List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>(); 
        shards.add(new JedisShardInfo("192.168.0.110", 6379, "master")); 

        // 构造池 
        shardedJedisPool = new ShardedJedisPool(config, shards); 
    } 

    public void show() {     
        KeyOperate(); 
        StringOperate(); 
        ListOperate(); 
        SetOperate();
        SortedSetOperate();
        HashOperate(); 
        jedisPool.returnResource(jedis);
        jedis.set("shenlinnan", "hahahahahaha");  
        System.out.println(jedis.get("shenlinnan")); 
        shardedJedisPool.returnResource(shardedJedis);
    } 
    public static void main(String[] args) {
        new RedisClient().show(); 
    }
      private void KeyOperate() {
         //
      }

      private void StringOperate() {
         //
      }

      private void ListOperate() {
         //
      }

      private void SetOperate() {
         //
      }

      private void SortedSetOperate() {
         //
      }
    
      private void HashOperate() {
         //
      }
}