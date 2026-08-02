package Movie_Ticket_Booking_System.CoreClass;

import java.time.Instant;
import java.util.Date;

public class SeatLock {
    private final Seat seat;
    private final Show show;
    private final Integer timeoutInSeconds;
    private final Date lockTime;
    private final User lockedBy;

    public SeatLock(Seat seat, Show show, Integer timeoutInSeconds, Date lockTime, User lockedBy) {
        this.seat = seat;
        this.show = show;
        this.timeoutInSeconds = timeoutInSeconds;
        this.lockTime = lockTime;
        this.lockedBy = lockedBy;
    }

    public boolean isLockExpired() {
        final Instant lockInstant = lockTime.toInstant().plusSeconds(timeoutInSeconds);
        final Instant currentInstant = new Date().toInstant();
        return lockInstant.isBefore(currentInstant);
    }
    public Seat getSeat() {
        return seat;
    }

    public Show getShow() {
        return show;
    }

    public Integer getTimeoutInSeconds() {
        return timeoutInSeconds;
    }

    public Date getLockTime() {
        return lockTime;
    }

    public User getLockedBy() {
        return lockedBy;
    }
}
