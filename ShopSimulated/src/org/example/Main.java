package org.example;

public class Main {

    public static void main(String[] args) {
        Shop shop = new Shop();
        shop.loadOfSumulate();
        shop.setIshiddenEvent(true);
        Event.generateMood();
        shop.showCurrentStatus("Начало дня");
        if (shop.getIsHiddenEvent()) {
            Event.hiddenEvent();
        } else {
            Event.generateEvent();
            shop.changeProducts();
            shop.showCurrentStatus("Завершение дня");
        };

    }







}