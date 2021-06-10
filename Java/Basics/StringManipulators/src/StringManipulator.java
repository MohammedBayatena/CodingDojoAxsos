public class StringManipulator {


    public StringManipulator() {
    }

    String trimAndConcat(String A, String B) {
        String string1 = A.trim();
        String string2 = B.trim();
        return string1 + string2;
    }

    Integer getIndexOrNull(String string, char character) {
        int result = string.indexOf(character);
        if (result == -1) {
            return null;
        } else {
            return result;
        }
    }


    Integer getIndexOrNull(String string, String word) {
        int result = string.indexOf(word);
        if (result == -1) {
            return null;
        } else {
            return result;
        }
    }

    String concatSubstring(String string1, int start, int end, String string2) {
        return string1.substring(start, end) + string2;
    }


}
