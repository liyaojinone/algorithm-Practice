public class Soultion {
    public static void main(String[] args) {
        String[] s = new String[]{"flower", "flow", "flight"};
        System.out.println("longestCommonPrefix(s) = " + longestCommonPrefix(s));

    }
        public static String longestCommonPrefix(String[] strs) {
            int len=strs.length;
            if (strs==null||len==0){
                return "";
            }
            String pre=strs[0];
            for (int i = 1; i < len; i++) {
                pre=longestCommonPrefix(pre,strs[i]);
                if (pre.length()==0){
                    break;
                }
            }

            return pre;
        }

    private static String longestCommonPrefix(String pre, String str) {
        int len=Math.min(pre.length(),str.length());
        int index=0;
        while (index<len&&pre.charAt(index)==str.charAt(index)){
            index++;
        }
        return pre.substring(0,index);
    }


}
