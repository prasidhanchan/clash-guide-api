package com.clash.guide;

import com.clash.guide.domain.Troop;

public class TestUtils {

    public static Troop createTroopA() {
        return Troop.builder()
                ._id("1")
                .name("Barbarian")
                .description("This is a test")
                .image("Test image")
                .color("0XFFFFFFFF")
                .build();
    }

    public static Troop createTroopAUpdated() {
        return Troop.builder()
                ._id("1")
                .name("Barbarian updated")
                .description("This is a update test")
                .image("Updated Test image")
                .color("0XFFFFFFFF")
                .build();
    }

    public static Troop createTroopB() {
        return Troop.builder()
                ._id("2")
                .name("Archer")
                .description("This is a test")
                .image("Test image")
                .color("0XFFFFFFFF")
                .build();
    }
}
