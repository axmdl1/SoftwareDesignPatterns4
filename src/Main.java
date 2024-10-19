import interpreter.Expression;
import interpreter.Interpreter;
import memento.History;
import memento.TextEditor;
import observer.NewsAgency;
import observer.NewsChannel;

public class Main {
    public static void main(String[] args) {
        String expression = "5+2-3";
        Expression evaluator = new Interpreter(expression);
        System.out.println("Result: " + evaluator.interpret());

        System.out.println("---------------------------------------------------------------");

        TextEditor textEditor = new TextEditor();
        History history = new History();

        textEditor.type("Software Design Patterns");
        System.out.println("Text: " + textEditor.getText());
        history.saveState(textEditor.save());

        textEditor.type(" Assignment 4");
        System.out.println("Text: " + textEditor.getText());

        textEditor.restore(history.undo());
        System.out.println("Undo: " + textEditor.getText());

        System.out.println("---------------------------------------------------------------");

        NewsAgency newsAgency = new NewsAgency();

        NewsChannel NYT = new NewsChannel("NYT");
        NewsChannel Qazaqstan = new NewsChannel("Qazaqstan");

        newsAgency.addObserver(NYT);
        newsAgency.addObserver(Qazaqstan);

        newsAgency.setNews("Assignment 4 done !!!");
        newsAgency.removeObserver(NYT);
        newsAgency.setNews("NYT deleted!");
    }
}