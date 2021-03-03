package com.axosclearing.codingchallenge.pizzashop;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.HashSet;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void joinToppings() {
        Main main = new Main();
        HashSet<String> oneTopping = new HashSet<>();
        HashSet<String> twoToppings = new HashSet<>();
        HashSet<String> threeToppings = new HashSet<>();
        Collections.addAll(oneTopping, "cheese");
        Collections.addAll(twoToppings, "cheese", "ham");
        Collections.addAll(threeToppings, "cheese", "ham", "jalapeno");
        Assert.assertEquals(main.joinToppings(oneTopping), "cheese");
        Assert.assertEquals(main.joinToppings(twoToppings), "ham and cheese");
        Assert.assertEquals(main.joinToppings(threeToppings), "ham, jalapeno, and cheese");
    }
}