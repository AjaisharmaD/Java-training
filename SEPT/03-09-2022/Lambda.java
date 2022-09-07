interface Readable {
    void readBook();
}

public class Lambda {
    public static void main(String[] args) {
        Readable reader = ()-> {
            System.out.println("the method which is in the readaable interface will be called");
        }
        reader.readBook();
    }
}