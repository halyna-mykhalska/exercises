package com.softserveinc.linkedlist;

import java.util.*;
import java.util.function.Consumer;

public class Ticket {
    public String cityFrom;
    public String cityTo;
    public Ticket prev;
    public Ticket next;

    public Ticket(String cityFrom, String cityTo) {
        this.cityFrom = cityFrom;
        this.cityTo = cityTo;
    }

    @Override
    public String toString() {
        return cityFrom + " - " + cityTo;
    }

    public static List<Ticket> restoreTripOrder(Set<Ticket> tickets) {
        Ticket head = null;
        for (Ticket t : tickets) {
            Optional<Ticket> ticket = tickets.stream().filter(next -> t.cityTo.equals(next.cityFrom)).findFirst();
            if (ticket.isPresent())
                t.next = ticket.get();

            ticket = tickets.stream().filter(prev -> prev.cityTo.equals(t.cityFrom)).findFirst();
            if (ticket.isPresent())
                t.prev = ticket.get();

            if (t.prev == null) {
                head = t;
            }
        }

        List<Ticket> result = new ArrayList<>();
        Ticket iterator = head;
        do {
            result.add(iterator);
            iterator = iterator.next;

        } while (iterator != null);

        return result;
    }

    public static void main(String[] args) {
        Set<Ticket> tickets = new HashSet<>();

        tickets.add(new Ticket("Kiev", "Lviv"));
        tickets.add(new Ticket("Warshava", "Praga"));
        tickets.add(new Ticket("Kharkiv", "Kiev"));
        tickets.add(new Ticket("Praga", "Paris"));
        tickets.add(new Ticket("Lviv", "Warshava"));

        System.out.println(restoreTripOrder(tickets));
    }
}

