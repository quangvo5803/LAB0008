import Common.Validation;
import Controller.Program;
import Model.Element;

public class App {
    public static void main(String[] args) throws Exception {
        Element e = new Element();
        e.setValue(Validation.getString("Enter your content: "));
        new Program(e).run();
    }
}
