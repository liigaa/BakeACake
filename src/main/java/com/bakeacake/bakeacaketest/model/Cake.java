package com.bakeacake.bakeacaketest.model;

import lombok.*;

import java.util.PrimitiveIterator;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cake {

    private Integer id;
    private String cakeTitle;
    private int flour;
    private int sugar;
    private int eggs;
    private int butter;
    private int creamCheese;
    private int vanillaSugar;
    private int milk;
    private int oil;
    private int gelatin;
    private int cornFlour;
    private int cocoa;
    private int darkChocolate;
    private int whiteChocolate;
    private int salt;
    private int bakingSoda;
    private int bakingPowder;
    private int confectionersSugar;
    private String other;

    public Cake(String cakeTitle, int flour, int sugar, int eggs, int butter, int creamCheese, int vanillaSugar, int milk, int oil, int gelatin, int cornFlour, int cocoa, int darkChocolate, int whiteChocolate, int salt, int bakingSoda, int bakingPowder, int confectionersSugar, String other) {
        this.cakeTitle = cakeTitle;
        this.flour = flour;
        this.sugar = sugar;
        this.eggs = eggs;
        this.butter = butter;
        this.creamCheese = creamCheese;
        this.vanillaSugar = vanillaSugar;
        this.milk = milk;
        this.oil = oil;
        this.gelatin = gelatin;
        this.cornFlour = cornFlour;
        this.cocoa = cocoa;
        this.darkChocolate = darkChocolate;
        this.whiteChocolate = whiteChocolate;
        this.salt = salt;
        this.bakingSoda = bakingSoda;
        this.bakingPowder = bakingPowder;
        this.confectionersSugar = confectionersSugar;
        this.other = other;
    }
}
