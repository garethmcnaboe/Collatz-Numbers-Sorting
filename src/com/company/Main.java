package com.company;

import java.util.Scanner;

class node {
    int number;
    int collatzNumber;

    public node(){

    }

    public node(int number, int collatzNumber) {
        this.number = number;
        this.collatzNumber = collatzNumber;
    }
}

class ArrayIns {

    public node[] objArray;
    public int numElements;

    public ArrayIns(int max) {
        objArray = new node[max];
        numElements = 0;
    }

    public void insertMethod(int number) {
        int collatzNumber = collatzMethod(number);
        node temp = new node(number, collatzNumber);
        objArray[numElements] = temp;
        numElements++;
    }

    public void printMethod(int z) {
        System.out.print("Number:" + objArray[z - 1].number);
        System.out.println("Collatz Number: " + objArray[z - 1].collatzNumber);
    }

    public int collatzMethod(int i) {
        if (i == 1) {
            return 0;
        }
        int counter = 1;
        while (i != 1) {
            if (i % 2 == 0) {
                i = i / 2;
            } else {
                i = (i * 3) + 1;
            }
            counter++;
        }
        return counter;
    }

    public void selectionSort() {
        int min;

        for (int outer = 0; outer < objArray.length; outer++) {
            min = outer;
            for (int i = outer + 1; i < objArray.length; i++) {
                if (objArray[i].collatzNumber < objArray[min].collatzNumber) {
                    min = i;
                }
                if (objArray[i].collatzNumber == objArray[min].collatzNumber) {
                    if (objArray[i].number < objArray[min].number) {
                        min = i;
                    }
                }
            }
            swap(outer, min);
        }
    }

    public void swap(int num1, int num2) {
        node temp = objArray[num1];
        objArray[num1] = objArray[num2];
        objArray[num2] = temp;
    }

    }


public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();

        int maxElements = y - x + 1;

        ArrayIns objArray = new ArrayIns(maxElements);

        for (int i = x; i < (y + 1); i++) {
            objArray.insertMethod(i);
        }

        objArray.selectionSort();

        for(int i = 1; i<=maxElements; i++){
            objArray.printMethod(i);
        }

        objArray.printMethod(z);
    }
}