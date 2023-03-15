package com.example.sellingPlatform.model.enumerations;

public enum Category {
    ADAPTER("Адаптери"),
    CAR_HOLDER("Држачи за автомобили"),
    EXTERNAL_BATTERY("Екстерни батерии"),
    CASE("Футроли"),
    MEMORY_CARD("Мемориски картички"),
    OTHER("Корисни додатоци за телефон"),
    CHARGER("Полначи"),
    WATCH_BELT("Ремени за Smart Watch"),
    STYLUS_PEN("Stylus пенкала"),
    HEADPHONES("Слушалки"),
    CABLE("USB и AUX кабли"),
    USB("USB"),
    PROTECTIVE_GLASS("Заштитни фолии и стакла");

    private final String label;

    Category(String label){
        this.label = label;
    }
}
