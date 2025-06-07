package ru.itis.inf403.control_work;

import java.io.Serializable;
import java.util.Date;

public class Game implements Comparable<Game>, Serializable {
    public String gamer;
    public Integer rating;
    public Date gameDate;

    @Override
    public int compareTo(Game o) {
        return o.rating - this.rating;
    }

    @Override
    public String toString() {
        return gamer + " - " + rating +
                " (" + gameDate + ")";
    }
}
