package org.easy.threads.wit;


import lombok.extern.java.Log;

@Log
public class Deadlock {

    static class Friend {
        private final String name;
        public Friend(String name) {
            this.name = name;
        }
        public String getName() {
            return this.name;
        }
        public synchronized void bow(Friend bower) {
            log.info(bower.getName()+ " has bowed to me!");
            bower.bowBack(this);
        }
        public synchronized void bowBack(Friend bower) {
            log.info(bower.getName()+ " has bowed to me!");
        }
    }

    public static void main(String[] args) {
        final Friend alphonse = new Friend("Alphonse");
        final Friend gaston = new Friend("Gaston");
        new Thread(() -> alphonse.bow(gaston)).start();
        new Thread(() -> gaston.bow(alphonse)).start();
    }
}

