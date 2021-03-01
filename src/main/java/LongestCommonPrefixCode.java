import java.util.List;

public class LongestCommonPrefixCode {

    public static void main(String[] args) {
        String[] strings = {"flower", "flow", "floight"};
        Same same = new Same();
        String min = same.getMin(strings);
        System.out.println(same.findsame(strings,min));


    }


    static class Same {

        public String getMin(String[] str) {
            int minLength = Integer.MAX_VALUE;
            String min = "";
            for (String s : str) {
                if (s.length() < minLength) {
                    minLength = s.length();
                    min=s;
                } else if (s.length() == minLength) {
                   min=s;
                }
            }
            return min;
        }
        public String findsame(String[] strings ,String MIN) {


            String chars = strings[0].substring(0,MIN.length());
            String result = "";
            for (int i = 1; i < MIN.length(); i++) {
//            while (strings[i].startsWith(chars.substring(i-1,i),i-1))
//            {
//                String value = String.valueOf(chars.substring(i-1,i));
//                result=result+value;
//                return result;
//            }
                if (strings[i].startsWith(chars.substring(i - 1, i), i - 1)) {
                    String value = chars.substring(i - 1, i);
                    result = result.concat(value);

                }

            }
            return result;
        }

    }
}