package com.example.jvm;

import java.util.LinkedList;
import java.util.List;

public class HeapError {

    public void makeHeapOutOfMemoryError() {
        List<Object> objectList = new LinkedList<>();
        while (true) {
            objectList.add(new byte[1024 * 1024]);
        }
    }

    public static void main(String[] args) {
        HeapError heapError = new HeapError();
        heapError.makeHeapOutOfMemoryError();
    }
}
