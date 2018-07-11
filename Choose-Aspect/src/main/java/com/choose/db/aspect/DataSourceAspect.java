package com.choose.db.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.apache.commons.lang3.StringUtils;

/**
 * @className: DataSourceAspect
 * @package: com.choose.db.aspect
 * @describe: 切换数据源
 * @auther: liuzhiyong
 * @date: 2018/7/11
 * @time: 下午 2:19
 */
@Aspect
@Component
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class DataSourceAspect {

    private static final Logger logger =  LoggerFactory.getLogger(DataSourceAspect.class);

    @Pointcut("execution(* com.choose.db.mybatis.dao.*.*(..))")
    public void aspect(){

    }

    @Before("aspect()")
    public void before(JoinPoint joinPoint){
        String className = joinPoint.getTarget().getClass().getName();
        String method = joinPoint.getSignature().getName();
        logger.info(className + "." + method + "(" + StringUtils.join(joinPoint.getArgs(),",") + ")");
        try{
            for(String key:ChooseDataSource.METHOD_TYPE_MAP.keySet()){
                for(String type:ChooseDataSource.METHOD_TYPE_MAP.get(key)){
                    if(method.startsWith(type)){
                        DataSourceHandler.putDataSource(key);
                    }
                }
            }
        }catch (Exception e){
            logger.info("错误的堆栈信息: {}",e.getMessage());
            e.printStackTrace();
        }
    }
}
