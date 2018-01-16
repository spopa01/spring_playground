package com.learnsome.spring_xmlconfig;

import org.springframework.context.support.ClassPathXmlApplicationContext;

interface Quest {
    void embark();
}

interface Knight {
    void beBrave();
}

class SlayDragonQuest implements Quest {
    @Override
    public void embark() {
        System.out.println("Slay the dragon quest has started!");
    }
}

class QuestSolvingKnight implements Knight {
    private Quest quest;

    public QuestSolvingKnight(Quest quest) {
        this.quest = quest;
    }

    @Override
    public void beBrave() {
        quest.embark();
    }
}

class Minstrel {
    public void singBefore() {
        System.out.println("The knight is brave!");
    }

    public void singAfter() {
        System.out.println("The brave knight did embark on a quest!");
    }
}

public class ApplicationXMLConfig {
    public static void  main(String[] args) {
        (new ClassPathXmlApplicationContext("config.xml")).getBean(Knight.class).beBrave();
    }
}