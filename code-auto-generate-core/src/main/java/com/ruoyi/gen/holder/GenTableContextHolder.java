package com.ruoyi.gen.holder;

import com.ruoyi.gen.constant.SecurityConstants;
import com.ruoyi.gen.domain.GenTable;
import com.ruoyi.gen.text.Convert;
import com.ruoyi.gen.util.StringUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GenTableContextHolder {
    private static final ThreadLocal<Map<String, Object>> THREAD_LOCAL = new ThreadLocal<>();

    public static void set(String key, Object value) {
        Map<String, Object> map = getLocalMap();
        map.put(key, value == null ? StringUtils.EMPTY : value);
    }

    public static String get(String key) {
        Map<String, Object> map = getLocalMap();
        return Convert.toStr(map.getOrDefault(key, StringUtils.EMPTY));
    }

    public static <T> T get(String key, Class<T> clazz) {
        Map<String, Object> map = getLocalMap();
        return StringUtils.cast(map.getOrDefault(key, null));
    }

    public static Map<String, Object> getLocalMap() {
        Map<String, Object> map = THREAD_LOCAL.get();
        if (map == null) {
            map = new ConcurrentHashMap<String, Object>();
            THREAD_LOCAL.set(map);
        }
        return map;
    }

    public static void setLocalMap(Map<String, Object> threadLocalMap) {
        THREAD_LOCAL.set(threadLocalMap);
    }

    public static void setGenTables(Map<String, GenTable> genTables) {
        set(SecurityConstants.GEN_TABLE, genTables);
    }

    public static Map<String, GenTable> getGenTables() {
        return get(SecurityConstants.GEN_TABLE, Map.class);
    }

    public static void remove() {
        THREAD_LOCAL.remove();
    }
}
