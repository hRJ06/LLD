package Movie_Ticket_Booking_System.ConcreteLockProvider;

import Movie_Ticket_Booking_System.CoreClass.Seat;
import Movie_Ticket_Booking_System.CoreClass.SeatLock;
import Movie_Ticket_Booking_System.CoreClass.Show;
import Movie_Ticket_Booking_System.CoreClass.User;
import Movie_Ticket_Booking_System.Interface.ISeatLockProvider;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class SeatLockProvider implements ISeatLockProvider {
    private final Integer lockTimeout;
    private final Map<Show, Map<Seat, SeatLock>> locks;

    public SeatLockProvider(Integer lockTimeout) {
        this.lockTimeout = lockTimeout;
        this.locks = new ConcurrentHashMap<>();
    }

    @Override
    public void lockSeats(Show show, List<Seat> seats, User user) throws Exception {
        Map<Seat, SeatLock> seatLocks = locks.computeIfAbsent(show, s -> new ConcurrentHashMap<>());
        synchronized (seatLocks) {
            for(Seat seat : seats) {
                if(seatLocks.containsKey(seat)) {
                    SeatLock existingLock = seatLocks.get(seat);
                    if(!existingLock.isLockExpired()) {
                        throw new Exception("Seat " + seat.getSeatId() + " is already locked.");

                    }
                }
            }
            Date now = new Date();
            for(Seat seat : seats) {
                SeatLock seatLock = new SeatLock(seat, show, lockTimeout, now, user);
                seatLocks.put(seat, seatLock);
            }
        }
    }

    @Override
    public void unlockSeats(Show show, List<Seat> seats, User user) {
        Map<Seat, SeatLock> seatLocks = locks.get(show);
        if(Objects.isNull(seatLocks)) return;
        for(Seat seat : seats) {
            SeatLock seatLock = seatLocks.get(seat);
            if(!Objects.isNull(seatLock) && seatLock.getLockedBy().equals(user)) {
                seatLocks.remove(seat);
            }
        }
    }

    @Override
    public boolean validateLock(Show show, Seat seat, User user) {
        Map<Seat, SeatLock> seatLocks = locks.get(show);
        if(Objects.isNull(seatLocks)) return false;
        synchronized (seatLocks) {
            SeatLock lock = seatLocks.get(seat);
            return lock != null && !lock.isLockExpired() && lock.getLockedBy().equals(user);
        }
    }

    @Override
    public List<Seat> getLockedSeats(Show show) {
        Map<Seat, SeatLock> seatLocks = locks.get(show);
        if(Objects.isNull(seatLocks)) {
            return Collections.emptyList();
        }
        synchronized (seatLocks) {
            return seatLocks.entrySet().stream()
                    .filter(entry -> !entry.getValue().isLockExpired())
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());
        }
    }
}
