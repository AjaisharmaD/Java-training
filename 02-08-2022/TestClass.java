interface Inter1 {
    void call();
    public default void disply() {
        System.out.println("hii");
    }
}

interface Inter2 {
    public default void disply() {
        System.out.println("helo");
    }
}

class TestClass implements Inter1, Inter2 {
    public void disply() {
	Inter1.super.disply();
        Inter2.super.disply();
    } 

    public void call() {
	System.out.println("this is call method");
    }

    public static void main (String[] args) {
	TestClass tobj = new TestClass();
	tobj.call();
	tobj.disp();
    }
}	