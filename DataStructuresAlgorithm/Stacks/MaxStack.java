package Stacks;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Collections;
import java.lang.Integer;
import java.lang.String;
public class MaxStack {
    Stack<Integer>st;
    ArrayList<Integer>arr;
    private MaxStack() {
        st = new Stack<>();
        arr = new ArrayList<>();
    }

    private void specialPush(int value) {
        st.push(value);
        arr.add(value);
        Collections.sort(arr);
    }

    private int specialPop() {
        if(st.isEmpty()) {
            return -1;
        }
        int val = st.pop();
        arr.remove(Integer.valueOf(val));
        Collections.sort(arr);
        return val;
    }

    private int specialTop() {
        if(st.isEmpty()) {
            return -1;
        }
        return st.peek();
    }

    private int specialMax() {
        if(arr.isEmpty()) {
            return -1;
        }
        return arr.get(arr.size()-1);
    }
}