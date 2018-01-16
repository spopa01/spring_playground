package com.learnsome.spring_javaconfig;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

interface Quest {
    void embark();
}

interface Knight {
    void beBrave();
}

@Component
class SlayDragonQuest implements Quest {
    @Override
    public void embark() {
        System.out.println("Slay the dragon quest has started!");
    }
}

@Component
class QuestSolvingKnight implements Knight {
    private Quest quest;

    @Autowired
    public QuestSolvingKnight(Quest quest) {
        this.quest = quest;
    }

    @Override
    public void beBrave() {
        quest.embark();
    }
}

@Aspect
@Component
class Minstrel {
    @Before("execution(* *.beBrave(..))")
    public void singBefore() {
        System.out.println("The knight is brave!");
    }

    @After("execution(* *.beBrave(..))")
    public void singAfter() {
        System.out.println("The brave knight did embark on a quest!");
    }
}

@Configuration
@EnableAspectJAutoProxy
class Config { }

public class ApplicationJavaConfig {
    public static void  main(String[] args) {
        (new AnnotationConfigApplicationContext(ApplicationJavaConfig.class.getPackage().getName())).getBean(Knight.class).beBrave();
    }
}