package com.zozospider.java8.optional;

import com.zozospider.java8.entity.Idol;
import com.zozospider.java8.entity.Man;
import com.zozospider.java8.entity.OldIdol;
import com.zozospider.java8.entity.OldMan;
import org.junit.Test;

import java.util.Optional;

public class OptionalTest2 {

    private static final String DEFAULT_NAME = "DEFAULT_NAME";
    private static final String DEFAULT_IDOL_NAME = "DEFAULT_IDOL_NAME";

    private OldMan oldMan = null;
    // private OldMan oldMan = new OldMan();
    // private OldMan oldMan = new OldMan("Bob");
    // private OldMan oldMan = new OldMan("Bob", new OldIdol());
    // private OldMan oldMan = new OldMan("Bob", new OldIdol("Taylor Swift"));

    private Man man = null;
    // private Man man = new Man();
    // private Man man = new Man(Optional.of("Bob"));
    // private Man man = new Man(Optional.of("Bob"), Optional.of(new Idol()));
    // private Man man = new Man(Optional.of("Bob"), Optional.of(new Idol(Optional.of("Taylor Swift"))));

    @Test
    public void oldStyle() {

        // get man
        OldMan oldManNow = oldMan;
        if (oldManNow == null) {
            System.out.println("there are no man");
            oldManNow = new OldMan();
        }

        // get name of oldMan
        String name = oldManNow.getName();
        if (name == null) {
            System.out.println("man do not have a name");
            name = DEFAULT_NAME;
        }

        // get name of idol
        String idolName;
        OldIdol idol = oldManNow.getIdol();
        if (idol == null) {
            System.out.println(name + " do not have a idol");
            idolName = DEFAULT_IDOL_NAME;
        } else {
            idolName = idol.getName();
            if (idolName == null) {
                System.out.println(name + " have a no name idol");
                idolName = DEFAULT_IDOL_NAME;
            }
        }

        System.out.println("------");

        System.out.println(name + " have a processed idol name: " + idolName);
    }

    @Test
    public void optionalStyle() {

        Man manNow = Optional.ofNullable(this.man)
                .orElseGet(() -> {
                    System.out.println("there are no man");
                    return new Man();
                });

        // get name of man
        String name = manNow.getOptionalName()
                .orElseGet(() -> {
                    System.out.println("man do not have a name");
                    return DEFAULT_NAME;
                });

        // get name of idol
        String idolName = manNow.getOptionalIdol()
                .orElseGet(() -> {
                    System.out.println(name + " do not have a idol");
                    return new Idol(Optional.of(DEFAULT_IDOL_NAME));
                })
                .getOptionalName()
                .orElseGet(() -> {
                    System.out.println(name + " have a no name idol");
                    return DEFAULT_IDOL_NAME;
                });

        System.out.println("------");

        System.out.println(name + " have a processed idol name: " + idolName);
    }

}
