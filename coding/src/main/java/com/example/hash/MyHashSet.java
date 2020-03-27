package com.example.hash;

import com.alibaba.fastjson.JSONArray;
import com.example.util.MyFiles;
import com.google.common.base.Objects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class MyHashSet {

    /** Initialize your data structure here. */
    private Node[] table;
    private int size = 1000;

    public MyHashSet() {
        table = new Node[size];
    }

    public void add(int key) {
        int index = hash(key);
        Node node = table[index];
        Node preNode = null;
        while (node != null) {
            if (node.key == key) {
                return;
            } else {
                preNode = node;
                node = node.next;
            }
        }
        if (preNode == null) {
            table[index] = new Node(key);
        } else {
            preNode.next = new Node(key);
        }
    }

    public void remove(int key) {
        int index = hash(key);
        Node node = table[index];
        Node preNode = null;
        while (node != null) {
            if (node.key == key) {
                if (preNode != null) {
                    preNode.next = node.next;
                } else {
                    table[index] = node.next;
                }
                return;
            } else {
                preNode = node;
                node = node.next;
            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = hash(key);
        Node node = table[index];
        while (node != null) {
            if (node.key == key) {
                return true;
            } else {
                node = node.next;
            }
        }
        return false;
    }

    private int hash(int key) {
        return key % size;
    }

    class Node {
        int key;
        Node next;

        public Node(int key) {
            this.key = key;
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        FileReader fileReader = new FileReader(MyFiles.getResourceStr("myhashset.txt"));
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
        FileReader fileReader = new FileReader(MyFiles.getResourceStr("myhashset.result"));
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