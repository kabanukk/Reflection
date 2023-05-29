import java.lang.reflect.Field;
import java.util.*;

public class MapToProduct {
    public Animal mapToProductDto(Pet pet){
        Class clazz = pet.getClass();
        Animal animal = new Animal();
        try {
            Field titleField = clazz.getDeclaredField("name");
            titleField.setAccessible(true);
            String title = (String) titleField.get(pet);//взяли кличку из класса pet
            Field statusField = clazz.getDeclaredField("status");
            statusField.setAccessible(true);
            Status status = (Status) statusField.get(pet);//взяли Статус из класса pet
            Field photoListField = clazz.getDeclaredField("photosList");
            photoListField.setAccessible(true);
            List<Photo> photos = (List<Photo>) photoListField.get(pet); //взяли Фото из класса pet
            clazz = animal.getClass();
            titleField = clazz.getDeclaredField("title");
            titleField.setAccessible(true);
            titleField.set(animal, title);// установили кличку пета энималу
            statusField = clazz.getDeclaredField("isAvailable");
            Field statusField2 = clazz.getDeclaredField("isSold");
            statusField2.setAccessible(true);
            statusField.setAccessible(true);
            statusField.set(animal, status == Status.AVAILABLE);
            statusField2.set(animal, status == Status.SOLD);
            HashMap<String, String> photosMap = new HashMap<>();
            photoListField = clazz.getDeclaredField("photosMap");
            photoListField.setAccessible(true);
            for (Photo photo : photos) {
                photosMap.put(photo.getName(), photo.getURL());
            }
            photoListField.set(animal, photosMap);// установили фото пета энималу
        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println("Ошибка!!" + e);
        }


        return animal;
    }
}