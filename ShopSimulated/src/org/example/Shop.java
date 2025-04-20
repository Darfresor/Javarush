package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/**
 * Class for simulate work in shop.
 * */
public class Shop {
    private int numHour;
    private int appleOfLongevity;
    private int mangoOfInsight;
    private int kiwiForOvercomesThunderousSadness;
    private int otherFruit;
    boolean isHiddenEvent;
    public final ArrayList<String> TEXT_FOR_LOAD = new ArrayList<>(List.of(
            "┌----------------------------------------------------------------------------┐ %n"
            , "|Все эти годы вы уже отчаялись ждать, но ваш золотой палец наконец пробужден!| %n"
            , "|>>подождите немного...                                                      | %n"
            , "|  *звук загрузки dial-up модема*                                            | %n"
            , "|  *звук загрузки dial-up модема*                                            | %n"
            , "|  *звук загрузки dial-up модема*                                            | %n"
            , "|  Поздравляем. Установка завершена П0ЧтИ YсПеШн000.                         | %n"
            , "|  ☯ Добро пожаловать в симулятор магазина Бессмертного ☯                   | %n"
            , "└----------------------------------------------------------------------------┘ %n"
    ));
    private final ArrayList<String> TEXT_FOR_SHOW_STATUS = new ArrayList<>(List.of(
            "Открытие магазина произошло в %s %n"
            , "На момент начала продаж в началии есть: %n"
            , "Яблоко долголетия, шт. = %d %n"
            , "Манго прозрения, шт. = %d %n"
            , "Киви для преодоления грозовой скорби, шт. = %d %n"
            , "И еще %d разнововидностей фруктов %n"
            , "Закончив инвентаризацию вы приступаете к работе %n"
            , "------------------------------------------------ %n"
            , "В конце дня вы подсчитываете сколько товаров осталось после продаж: %n"
            , "Симуляция завершена штатно. %n"
    ));


    public Shop() {
        numHour = (int) (24 * Math.random());
        appleOfLongevity = (int) (100 * Math.random());
        mangoOfInsight = (int) (10 * Math.random());
        kiwiForOvercomesThunderousSadness = (int) (1 * Math.random());
        otherFruit = (int) (666 * Math.random());
        isHiddenEvent = (getKiwiForOvercomesThunderousSadness() == 1);
    }

    public boolean getIsHiddenEvent() {
        return isHiddenEvent;
    }

    public void setIshiddenEvent(boolean hiddenEvent) {
        kiwiForOvercomesThunderousSadness = 1;
        isHiddenEvent = hiddenEvent;
    }

    public int getNumHour() {
        return numHour;
    }

    public void setNumHour(int numHour) {
        this.numHour = numHour;
    }

    public int getAppleOfLongevity() {
        return appleOfLongevity;
    }

    public void setAppleOfLongevity(int appleOfLongevity) {
        this.appleOfLongevity = appleOfLongevity;
    }

    public int getMangoOfInsight() {
        return mangoOfInsight;
    }

    public void setMangoOfInsight(int mangoOfInsight) {
        this.mangoOfInsight = mangoOfInsight;
    }

    public int getKiwiForOvercomesThunderousSadness() {
        return kiwiForOvercomesThunderousSadness;
    }

    public void setKiwiForOvercomesThunderousSadness(int kiwiForOvercomesThunderousSadness) {
        this.kiwiForOvercomesThunderousSadness = kiwiForOvercomesThunderousSadness;
    }

    public int getOtherFruit() {
        return otherFruit;
    }

    public void setOtherFruit(int otherFruit) {
        this.otherFruit = otherFruit;
    }

    public void showCurrentStatus(String partOfDay) {
        if (partOfDay.equals("Начало дня")) {
            System.out.printf(TEXT_FOR_SHOW_STATUS.get(0), numHour);
        }
        ;
        if (partOfDay.equals("Завершение дня")) {
            System.out.printf(TEXT_FOR_SHOW_STATUS.get(8));
        }
        System.out.printf(TEXT_FOR_SHOW_STATUS.get(1));
        System.out.printf(TEXT_FOR_SHOW_STATUS.get(2), appleOfLongevity);
        System.out.printf(TEXT_FOR_SHOW_STATUS.get(3), mangoOfInsight);
        System.out.printf(TEXT_FOR_SHOW_STATUS.get(4), kiwiForOvercomesThunderousSadness);
        System.out.printf(TEXT_FOR_SHOW_STATUS.get(5), otherFruit);
        if (!partOfDay.equals("Завершение дня")) {
            System.out.printf(TEXT_FOR_SHOW_STATUS.get(6));
        } else {
            System.out.printf(TEXT_FOR_SHOW_STATUS.get(9));
        }
        System.out.printf(TEXT_FOR_SHOW_STATUS.get(7));
    }

    public void changeProducts() {
        appleOfLongevity -= (int) (appleOfLongevity * Math.random());
        mangoOfInsight -= (int) (mangoOfInsight * Math.random());
        kiwiForOvercomesThunderousSadness -= (int) (kiwiForOvercomesThunderousSadness * Math.random());
        otherFruit -= (int) ((otherFruit) * Math.random());
    }

    public void loadOfSumulate() {
        for (String s : TEXT_FOR_LOAD) {
            System.out.printf(s);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        ;
        Shop shop = (Shop) obj;
        return appleOfLongevity == shop.appleOfLongevity
                && mangoOfInsight == shop.mangoOfInsight
                && kiwiForOvercomesThunderousSadness == shop.kiwiForOvercomesThunderousSadness
                && otherFruit == shop.otherFruit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numHour, appleOfLongevity, mangoOfInsight, kiwiForOvercomesThunderousSadness, otherFruit);
    }

    @Override
    public String toString() {
        return "Shop{" +
                "numHour=" + numHour +
                ", appleOfLongevity=" + appleOfLongevity +
                ", mangoOfInsight=" + mangoOfInsight +
                ", kiwiForOvercomesThunderousSadness=" + kiwiForOvercomesThunderousSadness +
                ", otherFruit=" + otherFruit +
                ", isHiddenEvent=" + isHiddenEvent +
                '}';
    }
}
