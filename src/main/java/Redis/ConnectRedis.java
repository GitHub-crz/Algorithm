package Redis;

import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.Set;

/**
 * @description:
 * @author: rzcai
 * @time: 2022/3/31 15:37
 */

public class ConnectRedis {
    public static void main(String[] args) throws Exception {
        showRedis();
    }
    private static void showRedis() {
        //连接redis数据库
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        //设置 key value
        jedis.set("baidu","QQ");
        //获取key对应的value
        String StrVal = jedis.get("baidu");
        System.out.println(StrVal);
        //获取数据库中所有keys
        System.out.println("数据库中所有键如下：");
        Set<String> keys = jedis.keys("*");
        Iterator<String> it=keys.iterator() ;
        while(it.hasNext()){
            String key = it.next();
            System.out.println(key);
        }
    }
}
