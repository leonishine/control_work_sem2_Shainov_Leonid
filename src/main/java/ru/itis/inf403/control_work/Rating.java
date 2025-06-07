package ru.itis.inf403.control_work;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Rating implements Serializable {
    public List<Game> games;

    public Rating() {
        games = new ArrayList<>();
    }
}
