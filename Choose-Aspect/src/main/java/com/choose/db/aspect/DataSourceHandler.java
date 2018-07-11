package com.choose.db.aspect;

/**
 * @className: DataSourceHandler
 * @package: com.choose.db.aspect
 * @describe: 数据选择控制器
 * @auther: liuzhiyong
 * @date: 2018/7/11
 * @time: 下午 2:16
 */
public class DataSourceHandler {

    public static final ThreadLocal<String> handler = new ThreadLocal<String>();

    public static void putDataSource(String dataSource){

        handler.set(dataSource);
    }

    public static String getDataSource(){

        return handler.get();
    }
}
