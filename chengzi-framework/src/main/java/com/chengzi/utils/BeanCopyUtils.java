package com.chengzi.utils;

import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class BeanCopyUtils {

    private BeanCopyUtils() {}

    public static <V> V copyBean(Object resource, Class<V> clazz){
        V vo = null;
        try {
            //创建目标对象
            vo = clazz.newInstance();
            //实现属性拷贝
            BeanUtils.copyProperties(resource,vo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //返回结果
        return vo;
    }

    public static <O,V> List<V> copyBeanList(List<O> list, Class<V> clazz){
        return list.stream()
                .map(o -> copyBean(o, clazz))
                .collect(Collectors.toList());
    }
}
