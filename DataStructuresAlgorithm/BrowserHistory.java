import java.util.ArrayList;
import java.util.List;
class Browser {
    private List<String> history;
    private int curr;
    public Browser(String homepage) {
        history = new ArrayList<>();
        history.add(homepage);
        curr = 0;
    }
    public void visit(String url) {
        while (curr + 1 < history.size()) {
            // Pop until current page and previous webpages left
            history.remove(history.size() - 1);
        }
        // Push new URL and make it current
        history.add(url);
        curr++;
    }
    public String back(int steps) {
        while (steps > 0 && curr != 0) {
            curr--;
            steps--;
        }
        return history.get(curr);
    }
    public String forward(int steps) {
        while (steps > 0 && curr != history.size() - 1) {
            curr++;
            steps--;
        }
        return history.get(curr);
    }
}

public class  BrowserHistory {
    public static void main(String[] args) throws Exception {
        Browser browser = new Browser("https://www.example.com");
        browser.visit("https://www.example.com/page1");
        browser.visit("https://www.example.com/page2");
        browser.visit("https://www.example.com/page3");
        System.out.println(browser.back(2));
        System.out.println(browser.forward(1));
        browser.visit("https://www.example.com/page4");
        System.out.println(browser.back(3));
    }
}