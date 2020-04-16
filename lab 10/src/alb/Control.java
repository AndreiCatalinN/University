package alb;

public class Control {
    public static void main(String[] args) {
        TestHashSet susan = new TestHashSet();

        susan.printSet();
        susan.addEntry("Vatican");
        susan.addEntry("Alepigusatican");
        susan.sortSet();
        susan.printSet();
    }
}
