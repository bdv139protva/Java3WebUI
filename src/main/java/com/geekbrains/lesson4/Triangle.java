package com.geekbrains.lesson4;

public class Triangle {

    public static void main(String[] args) throws Exception {
        //SquareOfTriangle(10, 0, 12);
        SquareOfTriangle(1, 10, 5);

    }
    public static double SquareOfTriangle(int a, int b, int c) throws Exception{

        //Heron's formula

        if (a <= 0 || b <= 0 || c <= 0 ) {
            throw new Exception("The side of the triangle must be a positive number. Please, check the values");
        }

        double pp = (double) (a + b + c) / 2;

        if (pp < a || pp < b || pp < c) {
            throw new Exception("There is no such triangle!");
        }

        double s = Math.sqrt(pp * (pp - a) * (pp - b) * (pp - c));
        return s;
    }


}
