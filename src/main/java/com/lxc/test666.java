package com.lxc;

public class test666 extends parent{
    public static void main(String[] args) {
        parent p=new test666();
        p.a();
    }

    @Override
    void b() {
        System.out.println(2222);
    }
}
abstract class parent{

   void a(){
        b();
   }
   void b(){
       System.out.println(11111);
    }
}


