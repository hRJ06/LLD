package Split_Wise.Utility;

import java.util.Objects;

public class UserPair {
    private User user1;
    private User user2;

    public UserPair(User user1, User user2) {
        this.user1 = user1;
        this.user2 = user2;
    }

    public User getUser1() {
        return user1;
    }

    public User getUser2() {
        return user2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserPair)) return false;

        UserPair pair = (UserPair) o;

        return user1.equals(pair.user1)
            && user2.equals(pair.user2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user1, user2);
    }
}
