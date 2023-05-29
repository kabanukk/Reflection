import org.junit.Assert;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class MapToProductTest {
    @org.junit.Test
    public void testMapToProductAvailable(){
        Pet cat = new Pet("Барсик", Status.AVAILABLE, List.of(new Photo("Барсик с цветочком","https://placekitten.com/200/300"),
                new Photo("Барсик на ручках", "https://placekitten.com/500/605")));
        MapToProduct mapToProduct = new MapToProduct();
        Animal animal = mapToProduct.mapToProductDto(cat);
        Assert.assertEquals("Барсик Available {Барсик с цветочком=https://placekitten.com/200/300, Барсик на ручках=https://placekitten.com/500/605}",
                animal.toString());
    }

    @org.junit.Test
    public void testMapToProductSold(){
        Pet cat = new Pet("Барсик", Status.SOLD, List.of(new Photo("Барсик с цветочком","https://placekitten.com/200/300"),
                new Photo("Барсик на ручках", "https://placekitten.com/500/605")));
        MapToProduct mapToProduct = new MapToProduct();
        Animal animal = mapToProduct.mapToProductDto(cat);
        Assert.assertEquals("Барсик Sold {Барсик с цветочком=https://placekitten.com/200/300, Барсик на ручках=https://placekitten.com/500/605}",
                animal.toString());
    }

}