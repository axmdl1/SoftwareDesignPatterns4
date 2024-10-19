package memento;

import java.util.Stack;

public class History {
    Stack<Memento> history  = new Stack<>();

    public void saveState(Memento memento){
        history.push(memento);
    }

    public Memento undo(){
        if (!history.isEmpty()){
            return history.pop();
        } else {
            return null;
        }
    }
}
