package Movie_Ticket_Booking_System.CoreClass;

import java.util.ArrayList;
import java.util.List;

public class Screen {
    private final int id;
    private final String name;
    private final Theatre theatre;
    private final List<Seat> seats;

    public Screen(int id, String name, Theatre theatre) {
        this.id = id;
        this.name = name;
        this.theatre = theatre;
        this.seats = new ArrayList<>();
    }

    public void addSeat(final Seat seat) {
        seats.add(seat);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public List<Seat> getSeats() {
        return seats;
    }
}
