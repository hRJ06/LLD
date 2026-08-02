package Movie_Ticket_Booking_System.CoreClass;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
    private final int id;
    private final String name;
    private final List<Screen> screens;

    public Theatre(int id, String name) {
        this.id = id;
        this.name = name;
        screens = new ArrayList<>();
    }

    public void addScreen(final Screen screen) {
        screens.add(screen);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Screen> getScreens() {
        return screens;
    }
}
