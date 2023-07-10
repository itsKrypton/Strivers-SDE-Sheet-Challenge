public class CountAndSay {
    public String countAndSay(int n) {
        if(n == 1)
        return "1";

        String s = countAndSay(n - 1);
        StringBuilder ans = new StringBuilder();
        int i = 0;

        while(i < s.length())
        {
            char currCh = s.charAt(i);
            int count = 1;

            while(i < s.length() - 1 && currCh == s.charAt(i + 1))
            {
                count++;
                i++;
            }

            ans.append(Integer.toString(count));
            ans.append(currCh);
            i++;
        }

        return ans.toString();
    }
}
