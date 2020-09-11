package com.javainuse.controller;

import redis.clients.jedis.*;
/**
 * Created by IntelliJ IDEA.
 * User: anlcan
 * Date: 2/24/16
 * Time: 11:36 AM
 */
public class CacheManager {


    /**
     * environment prefix
     */


    private static JedisPool pool = null;

    public static void init(String hostAddresses, int port) {
        try {

            pool = new JedisPool(buildPoolConfig(), hostAddresses, port);
            Jedis jedis = pool.getResource();

        }catch (Exception e ) {
            e.printStackTrace();
        }
    }


    private static JedisPoolConfig buildPoolConfig() {
        final JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxWaitMillis(2000);
        poolConfig.setMaxTotal(30);
        return poolConfig;
    }

    /**
     * values are stored with environment prefix
     * @param key environmet prefix
     * @return prefixed key
     */
    private static String key(String key){
        return "manuel"+"/"+key;
    }


    public static void put(String key, String object){
        try (Jedis jedis = pool.getResource()) {
            jedis.set(key(key), object);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public static Object get(String key) {

        try (Jedis jedis = pool.getResource()) {
            return jedis.get(key(key));

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
