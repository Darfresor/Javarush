package org.example;

import java.util.ArrayList;
import java.util.List;
/**
 * Static class for generate random events in simulate.
 * */
public class Event {
    private final static ArrayList<String> MOOD_LIST = new ArrayList<>(List.of(
            "☯ Вы верите что успех сопутствует тем, кто рано встает, поэтому... "
            ,"☯ Вы четко осознаете что с вашими навыки бесполезно стараться, поэтому... "
            ,"☯ Вы верите, что только четкое следование графику позволит вашей прибыли повыситься, поэтому..."
            ,"☯ У вас есть тактика, который вы неукоснительно следуете. После того как подброшенный кубик падает вы..."
    ));
    private final static ArrayList<String> EVENT_LIST = new ArrayList<>(List.of(
            "☯ Сегодня за окном снова идет кислотный дождь поэтому продажи движутся неважно."
            ,"☯ К вам пришли грабители. Посочувствовали. Оставили свои фрукты для помощи."
            ,"☯ Манго прозрения обрели самосознание. Теперь при их продаже вы стоите перед сложной моральной дилемой"
            ,"☯ Сарофанное радио разнесло вести, что у вас есть фрукты для сохранения лица. От клиентов нет отбоя."
            ,"☯ Наводнение захлестнуло все вокруг. К счастью у вас были фрукты подводного дыхания и вы уцелели."
        ));
    private final static ArrayList<String> HIDDEN_EVENT_TEXT = new ArrayList<>(List.of(
            "☯ Внезапно вы замечаете пропажу единственого в магазине киви и почти сразу же за окном слышен тихий рокот грома."
            ,"☯ Тучи собираются над вашим магазином и водопад фиолетовых молний обрушивается на здание."
            ,"☯ Поздравляем, вы погибли, но подобранный вами кот пережил скорбь и стал Бессмертным."
            ,"☯ Симуляция завершена преждевременно."
    ));
    private final static String SPLIT = "------------------------------------------------";

    public Event() {
    }



    public static void generateMood(){
        printInConsole(MOOD_LIST);
    }

    public static void generateEvent(){
        printInConsole(EVENT_LIST);
    }
    private static void printInConsole(ArrayList<String> arrayList) {
        int arrayNum = (int) (arrayList.size() * Math.random());
        System.out.println(SPLIT);
        System.out.println(arrayList.get(arrayNum));
        System.out.println(SPLIT);
    }
    /**
     * Triggers a hidden event script.
     * Should be called if specific user-defined conditions are met.
     */
    public  static void hiddenEvent() {
        for (int i = 0; i < HIDDEN_EVENT_TEXT.size(); i++) {
            System.out.println(HIDDEN_EVENT_TEXT.get(i));
        }
    }
}
