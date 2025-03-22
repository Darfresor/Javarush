package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int numHour;
        int appleaOfLongevity;
        int mangoOfInsight;
        int kiwiForOvercomesThunderousSadness;
        int otherFruit;

        numHour = (int ) (24*Math.random());
        appleaOfLongevity = (int) (100*Math.random());
        mangoOfInsight = (int) (10*Math.random());
        kiwiForOvercomesThunderousSadness = (int) (1*Math.random());
        otherFruit = (int) (666*Math.random());
        boolean ishiddenEvent = (kiwiForOvercomesThunderousSadness ==1);

        loadOfSumulate();
        generateMood();
        System.out.println("Открытие магазина произошло в "+ numHour);
        System.out.println("На момент начала продаж в началии есть:");
        System.out.println("Яблоко долголетия, шт. = " + appleaOfLongevity);
        System.out.println("Манго прозрения, шт. = " + mangoOfInsight);
        System.out.println("Киви для преодоления грозовой скорби, шт. = " + kiwiForOvercomesThunderousSadness);
        System.out.println("И еще " + otherFruit +" разнововидностей фруктов");
        System.out.println("Закончив инвентаризацию вы приступаете к работе");
        System.out.println("------------------------------------------------");
        if(ishiddenEvent){
            hiddenEvent();
        }else{
            generateEvent();
            System.out.println("В конце дня вы подсчитываете сколько товаров осталось после продаж:");
            appleaOfLongevity -= (int) (appleaOfLongevity*Math.random());
            mangoOfInsight -= (int) (mangoOfInsight*Math.random());
            kiwiForOvercomesThunderousSadness -= (int) (kiwiForOvercomesThunderousSadness*Math.random());
            otherFruit -= (int) ((otherFruit)*Math.random());
            System.out.println("Яблоко долголетия, шт. = " + appleaOfLongevity);
            System.out.println("Манго прозрения, шт. = " + mangoOfInsight);
            System.out.println("Киви для преодоления грозовой скорби, шт. = " + kiwiForOvercomesThunderousSadness);
            System.out.println("Симуляция завершена штатно");
        };






    }
    private static void loadOfSumulate(){
        System.out.println("┌----------------------------------------------------------------------------┐");
        System.out.println("|Все эти годы вы уже отчаялись ждать, но ваш золотой палец наконец пробужден!|");
        System.out.println("|>>подождите немного...                                                      |");
        System.out.println("|  *звук загрузки dial-up модема*                                            |");
        System.out.println("|  *звук загрузки dial-up модема*                                            |");
        System.out.println("|  *звук загрузки dial-up модема*                                            |");
        System.out.println("|  Поздравляем. Установка завершена П0ЧтИ YсПеШн000.                         |");
        System.out.println("|  ☯ Добро пожаловать в симулятор магазина Бессмертного ☯                   |");
        System.out.println("└----------------------------------------------------------------------------┘");
    };
    private static void generateMood(){
        int moodNum = (int) (4*Math.random());
        if(moodNum == 0)
            System.out.println("☯ Вы верите что успех сопутствует тем, кто рано встает, поэтому...");
        if(moodNum == 1)
            System.out.println("☯ Вы четко осознаете что с вашими навыки бесполезно стараться, поэтому...");
        if(moodNum == 2)
            System.out.println("☯ Вы верите, что только четкое следование графику позволит вашей прибыли повыситься, поэтому...");
        if(moodNum == 3||moodNum == 4)
            System.out.println("☯ У вас есть тактика, который вы неукоснительно следуете. После того как подброшенный кубик падает вы...");
    };
    private static void generateEvent(){
        int eventNum = (int) (4*Math.random());
        if(eventNum == 0)
            System.out.println("☯ Сегодня за окном снова идет кислотный дождь поэтому продажи движутся неважно.");
        if(eventNum == 1)
            System.out.println("☯ К вам пришли грабители. Посочувствовали. Оставили свои фрукты для помощи.");
        if(eventNum == 2)
            System.out.println("☯ Манго прозрения обрели самосознание. Теперь при их продаже вы стоите перед сложной моральной дилемой");
        if(eventNum == 3)
            System.out.println("☯ Сарофанное радио разнесло вести, что у вас есть фрукты для сохранения лица. От клиентов нет отбоя.");
        if(eventNum == 4)
            System.out.println("☯ Наводнение захлестнуло все вокруг. К счастью у вас были фрукты подводного дыхания и вы уцелели.");
    };
    private static void hiddenEvent(){
        System.out.println("☯ Внезапно вы замечаете пропажу единственого в магазине киви и почти сразу же за окном слышен тихий рокот грома.");
        System.out.println("☯ Тучи собираются над вашим магазином и водопад фиолетовых молний обрушивается на здание.");
        System.out.println("☯ Поздравляем, вы погибли, но подобранный вами кот пережил скорбь и стал Бессмертным.");
        System.out.println("☯ Симуляция завершена преждевременно.");
    };


}