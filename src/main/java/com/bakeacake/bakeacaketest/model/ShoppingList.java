package com.bakeacake.bakeacaketest.model;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ShoppingList {


        private Integer id;
        private double flour;
        private double sugar;
        private double eggs;
        private double butter;
        private double creamCheese;
        private double vanillaSugar;
        private double milk;
        private double oil;
        private double gelatin;
        private double cornFlour;
        private double cocoa;
        private double darkChocolate;
        private double whiteChocolate;
        private double salt;
        private double bakingSoda;
        private double bakingPowder;
        private double confectionersSugar;
        private String other;

        public ShoppingList(double flour, double sugar, double eggs, double butter, double creamCheese, double vanillaSugar, double milk, double oil, double gelatin, double cornFlour, double cocoa, double darkChocolate, double whiteChocolate, double salt, double bakingSoda, double bakingPowder, double confectionersSugar) {
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
        }

        public ShoppingList(double flour, double sugar, double eggs, double butter, double creamCheese, double vanillaSugar, double milk, double oil, double gelatin, double cornFlour, double cocoa, double darkChocolate, double whiteChocolate, double salt, double bakingSoda, double bakingPowder, double confectionersSugar, String other) {
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
