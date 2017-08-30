package junk;

public class Test2 {
    public static void main(String[] args) {
        new TestsGen().print(new Gen<C>());
        
    }
}

class A {
    int a=2;
    public void print() { System.out.println(getClass().getSimpleName()); }
}

class B extends A{
    public void print() { System.out.println(getClass().getSimpleName()); }
}

class C extends B {
    public void print() { System.out.println(getClass().getSimpleName()); }
}

class D extends C {
    public void print() { System.out.println(getClass().getSimpleName()); }
}

class E extends D {
    public void print() { System.out.println(getClass().getSimpleName()); }
}


class Gen<T extends B> {
    public void print(T t) { System.out.println(t.a); }
}

class TestsGen {
    public void print(Gen<? extends C> t) { /**/ }
}