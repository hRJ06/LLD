package Movie_Ticket_Booking_System.Interface;

import Movie_Ticket_Booking_System.CoreClass.Seat;
import Movie_Ticket_Booking_System.CoreClass.Show;
import Movie_Ticket_Booking_System.CoreClass.User;

import java.util.List;

public interface ISeatLockProvider {
    void lockSeats(Show show, List<Seat> seats, User user) throws Exception;
    void unlockSeats(Show show, List<Seat> seats, User user);
    boolean validateLock(Show show, Seat seat, User user);
    List<Seat> getLockedSeats(Show show);
}
