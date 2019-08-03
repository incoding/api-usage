package com.javaapi.test.buisness.concurrent.thread.waitnotify.wait;

public class Athlete implements Runnable {
    private final int id;
    private Game game;

    public Athlete(int id, Game game) {
        this.id = id;
        this.game = game;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Athlete)) {
            return false;
        }
        Athlete athlete = (Athlete) o;
        return id == athlete.id;
    }

    public String toString() {
        return "Athlete<" + id + ">";
    }

    public int hashCode() {
        return new Integer(id).hashCode();
    }

    public void run() {
        try {
            game.prepare(this);
        } catch (InterruptedException e) {
            System.out.println(this + " quit the game");
        }
    }
}
