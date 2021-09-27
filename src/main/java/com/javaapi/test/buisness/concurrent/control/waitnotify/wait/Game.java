package com.javaapi.test.buisness.concurrent.control.waitnotify.wait;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;



public class Game implements Runnable {
    private Set<Athlete> players = new HashSet<Athlete>();
    private boolean start = false;

    public void addPlayer(Athlete one) {
      players.add(one);
    }

    public void removePlayer(Athlete one) {
      players.remove(one);
    }

    public Collection<Athlete> getPlayers() {
      return Collections.unmodifiableSet(players);
    }

    public void prepare(Athlete athlete) throws InterruptedException {
      System.out.println(athlete + " ready!");
      synchronized (this) {
        while (!start){
        	wait();
        }
          if (start) {
              System.out.println(athlete + " go!");
          }
      }
    }

    public synchronized void go() {
      notifyAll();
    }
    
    public void ready() {
      Iterator<Athlete> iter = getPlayers().iterator();
        while (iter.hasNext()) {
            new Thread(iter.next()).start();
        }
    }
    @Override
    public void run() {
      start = false;
      System.out.println("Ready......");
      System.out.println("Ready......");
      System.out.println("Ready......");
      ready();
		 try {
             System.out.println("倒计时10秒......");

             Thread.sleep(10000);
		 } catch (InterruptedException e) {
		 e.printStackTrace();
		 }
      start = true;
      System.out.println("Go!");
      go();
    }
}