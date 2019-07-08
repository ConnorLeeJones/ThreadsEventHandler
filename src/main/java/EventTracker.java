import java.util.HashMap;
import java.util.Map;

public class EventTracker implements Tracker {


    private static EventTracker INSTANCE = new EventTracker();


    private Map<String, Integer> tracker;

    private EventTracker() {
        this.tracker = new HashMap<>();
    }

    synchronized public static EventTracker getInstance() {
        return INSTANCE;
    }

    synchronized public void push(String message) {
        this.tracker.merge(message, 1, Integer::sum);
    }


    synchronized public boolean has(String message) {
        return (this.tracker.containsKey(message) && this.tracker.get(message) > 0);
    }

    synchronized public void handle(String message, EventHandler e) {
        if (has(message)) {
            e.handle();
            this.tracker.merge(message, -1, Integer::sum);
        }
    }

    public Map<String, Integer> tracker() {
        return this.tracker;
    }

    // Do not use this. This constructor is for tests only
    // Using it breaks the singleton class
    EventTracker(Map<String, Integer> tracker) {
        this.tracker = tracker;
    }





}
