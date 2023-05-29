

import java.util.List;

public class Main {
    public static void main(String[] args){
        MapToProduct mapToProduct = new MapToProduct();
        Pet cat = new Pet("Барсик", Status.AVAILABLE,
                List.of(new Photo("Барсик с цветочком","https://placekitten.com/200/300"),
                        new Photo("Барсик на ручках", "https://placekitten.com/500/605")));
        Animal animalCat = mapToProduct.mapToProductDto(cat);
        System.out.println(animalCat.toString());

    }
}