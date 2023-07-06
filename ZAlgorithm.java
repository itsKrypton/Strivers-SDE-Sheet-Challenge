/*
 * Used KMP. In the end when all the characters in pattern match all the characters in string. We move the j pointer back to lps[j - 1] as we know that characters before
 * that already match so we don't have to match them again.
 */

public class ZAlgorithm {
    // This is not ZAlgo, I have used KMP, need to learn Z Algo
    public static int zAlgorithm(String s, String p, int n, int m) {
		if(p == "") return 0;
        int[] lps = new int[p.length()];

        int prevLPS = 0, i = 1;
        while(i < p.length())
        {
            if(p.charAt(i) == p.charAt(prevLPS))
            {
                lps[i] = prevLPS + 1;
                prevLPS++;
                i++;
            }

            else if(prevLPS == 0)
            {
                lps[i] = 0;
                i++;
            }

            else
            prevLPS = lps[prevLPS - 1];
        }

        i = 0;
        int j = 0;
		int count = 0;
        while(i < s.length())
        {
            if(s.charAt(i) == p.charAt(j))
            {
                i++;
                j++;
            }

            else
            {
                if(j == 0) 
                i++;

                else
                j = lps[j - 1];
            }

            if(j == p.length())
            {
				count++;
				j = lps[j - 1];
			}
        }

        return count;
	}
}

