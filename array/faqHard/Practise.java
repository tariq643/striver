package dsa.striver.array.faqHard;

class Parent {
    void show() {
        System.out.println("Parent");
    }
}

class Child extends Parent {
    void show() {
        System.out.println("Child");
    }
}

public class Practise {

    static void main() {
        Parent obj = new Child();
        obj.show();
    }
}
