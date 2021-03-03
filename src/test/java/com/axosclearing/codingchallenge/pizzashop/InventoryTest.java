package com.axosclearing.codingchallenge.pizzashop;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class InventoryTest {

    @Test
    public void getStock() {
        Path path = Paths.get("./src/test/resources/ingredient_inventory.csv");
        File file = new File(path.toString());
        Inventory inventory = new Inventory(file);
        Assert.assertEquals(inventory.getStock("cheese"),100);
        Assert.assertEquals(inventory.getStock("pepperoni"), 10);
        Assert.assertEquals(inventory.getStock("sausage"), 10);
        Assert.assertEquals(inventory.getStock("mushroom"), 10);
        Assert.assertEquals(inventory.getStock("pineapples"), 5);
        Assert.assertEquals(inventory.getStock("ham"), 7);
        Assert.assertEquals(inventory.getStock("jalapeno"), 5);
    }

    @Test
    public void useItem() {
        Path path = Paths.get("./src/test/resources/ingredient_inventory.csv");
        File file = new File(path.toString());
        Inventory inventory = new Inventory(file);
        inventory.useItem("jalapeno");
        Assert.assertEquals(inventory.getStock("jalapeno"), 4);
        for (int i = 0; i < 5;i += 1) {
            inventory.useItem("jalapeno");
        }
        Assert.assertEquals(inventory.getStock("jalapeno"), 0);
        Assert.assertEquals(inventory.useItem("jalapeno"), false);
    }
}