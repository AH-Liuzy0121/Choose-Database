package com.choose.db.aspect;

import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @className: ChooseDataSource
 * @package: com.choose.db.aspect
 * @describe: 动态选择数据源
 * @auther: liuzhiyong
 * @date: 2018/7/11
 * @time: 下午 2:12
 */
public class ChooseDataSource extends AbstractRoutingDataSource {

    public static Map<String,List<String>> METHOD_TYPE_MAP = new HashMap<String, List<String>>();

    protected Object determineCurrentLookupKey() {

        return DataSourceHandler.getDataSource();
    }

    public void setMethodTypeMap(Map<String,String> map){
        for(String key:map.keySet()){
            List<String> values = new ArrayList<String>();
            String[] types = map.get(key).split(",");
            for(String type:types){
                if(StringUtils.isNotBlank(type)){
                    values.add(type);
                }
            }
            METHOD_TYPE_MAP.put(key,values);
        }
    }
}
