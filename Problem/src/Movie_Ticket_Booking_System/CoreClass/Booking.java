package Movie_Ticket_Booking_System.CoreClass;

import Movie_Ticket_Booking_System.CoreEnum.BookingStatus;

import java.util.List;

public class Booking {
    private final int id;
    private final User user;
    private final List<Seat> seatsBooked;
    private final Show show;
    private final BookingStatus bookingStatus;

    public Booking(int id, User user, List<Seat> seatsBooked, Show show, BookingStatus bookingStatus) {
        this.id = id;
        this.user = user;
        this.seatsBooked = seatsBooked;
        this.show = show;
        this.bookingStatus = bookingStatus;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public List<Seat> getSeatsBooked() {
        return seatsBooked;
    }

    public Show getShow() {
        return show;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }
}
