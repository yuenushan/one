package com.example.hash;

import com.alibaba.fastjson.JSONArray;
import com.example.util.MyFiles;
import com.google.common.base.Objects;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class MyHashMap {
    /** Initialize your data structure here. */
    private Entry[] table;
    private int size = 10000;

    public MyHashMap() {
        table = new Entry[size];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hashVal = hash(key);
        Entry entry = table[hashVal];
        while (true) {
            if (entry == null) {
                entry = new Entry(key, value);
                table[hashVal] = entry;
            } else {
                if (entry.key == key) {
                    entry.value = value;
                    return;
                } else {
                    if (entry.next != null) {
                        entry = entry.next;
                    } else {
                        entry.next = new Entry(key, value);
                    }
                }
            }
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        Entry entry = table[hash(key)];
        while (true) {
            if (entry == null) {
                return -1;
            }
            if (entry.key == key) {
                return entry.value;
            }
            entry = entry.next;
        }
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        Entry entry = table[hash(key)];
        Entry preEntry = null;
        while (true) {
            if (entry == null) {
                break;
            }
            if (entry.key == key) {
                if (preEntry == null) {
                    table[hash(key)] = entry.next;
                } else {
                    preEntry.next = entry.next;
                }
                break;
            }
            preEntry = entry;
            entry = entry.next;
        }
    }

    private int hash(int key) {
        return key % size;
    }

    class Entry {
        int key;
        int value;
        Entry next;

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        FileReader fileReader = new FileReader(MyFiles.getResourceStr("myhashmap.txt"));
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String opsStr = bufferedReader.readLine();
        String resultStr = bufferedReader.readLine();
        bufferedReader.close();
        List<String> opsList = JSONArray.parseArray(opsStr, String.class);
        List<String> resultList = JSONArray.parseArray(resultStr, String.class);
        String clzStr = opsList.remove(0);
        Class<?> clz = Class.forName(MyHashMap.class.getPackage().getName() + "." + clzStr);
        JSONArray jsonArray = JSONArray.parseArray(resultList.remove(0));
        Object object = clz.getConstructor(getParamTypes(jsonArray)).newInstance(jsonArray.toArray());
        JSONArray resultArray = getResults();
        resultArray.remove(0);
        for (int i = 0; i < opsList.size(); i++) {
            JSONArray jsonArray1 = JSONArray.parseArray(resultList.get(i));
            Method method = clz.getMethod(opsList.get(i), getParamTypes(jsonArray1));
            Object result = method.invoke(object, jsonArray1.toArray());
            if (!Objects.equal(result, resultArray.get(i))) {
                System.out.println(result + ":" + resultArray.get(i));
            }
//            assert result == resultArray.get(i);
        }
    }

    private static JSONArray getResults() throws IOException {
        FileReader fileReader = new FileReader(MyFiles.getResourceStr("myhashmap.result"));
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        JSONArray jsonArray = JSONArray.parseArray(bufferedReader.readLine());
        bufferedReader.close();
        return jsonArray;
    }

    private static Class[] getParamTypes(JSONArray jsonArray) {
        Class[] classes = new Class[jsonArray.size()];
        for (int i = 0; i < jsonArray.size(); i++) {
            classes[i] = jsonArray.get(i).getClass().equals(Integer.class) ? int.class: jsonArray.get(i).getClass();
        }
        return classes;
    }

}
