import java.util.HashMap;
import java.util.Set;

public class HashMaps {

    public static void main(String[] args) {

        HashMap<String, String> trackList = new HashMap<>();


        trackList.put("kryptonite", "Well, I took a walk around the world to ease my troubled mind,\n" +
                "I left my body lying somewhere in the sands of time\n" +
                "Well, I watched the world float to the dark side of the moon");

        trackList.put("Edge Of The Earth", "You know enough to know the way\n" +
                "Six billion people just one name\n" +
                "(I found)\n" +
                "I found tomorrow in today…");

        trackList.put("Kiss Of Death", "そばに来て 崩れゆく抑制\n" +
                "ボクを怖がらないで\n" +
                "飛べない鳥が夢見た空\n" +
                "交わってく色 それは違う");


        trackList.put("Hurricane", "No matter how many times that you told me you wanted to leave.\n" +
                "No matter how many breaths that you took you still couldn't breathe.\n" +
                "No matter how many nights that you lied wide awake to the sound of the poison rain.");


        System.out.println("-------------------------");
        System.out.println(trackList.get("Hurricane"));
        System.out.println("-------------------------");

        Set<String> keys = trackList.keySet();
        for (String key : keys) {
            System.out.print("[");
            System.out.print("Title: " + key + " : " + "Lyrics: " + trackList.get(key));
            System.out.println("]");
            System.out.println();
        }


    }


}
