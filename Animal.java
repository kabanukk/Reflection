import java.util.Map;

public class Animal {
    private String title;
    private boolean isAvailable;
    private boolean isSold;
    private Map<String, String> photosMap;

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (isAvailable){
            stringBuilder.append(title + " Available " + photosMap);
        }else{
            stringBuilder.append(title + " Sold " + photosMap);
        }
        return String.valueOf(stringBuilder);
    }
}
