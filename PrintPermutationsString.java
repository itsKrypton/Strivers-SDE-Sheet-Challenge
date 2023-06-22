import java.util.ArrayList;
import java.util.List;

public class PrintPermutationsString {
    public static List<String> findPermutations(String s) {
        List<String> ans = new ArrayList<>();
        helper(s, "", ans);

        return ans;
    }

    public static void helper(String uString, String pString, List<String> ans)
    {
        if(uString.length() == 0)
        {
            ans.add(pString);
            return;
        }

        for(int i = 0; i < uString.length(); i++)
        {
            char ch = uString.charAt(i);
            String leftPart = uString.substring(0, i);
            String rightPart = uString.substring(i + 1);
            helper(leftPart + rightPart, pString + ch, ans);
        }
    }
}
