public class ReverseWordsInAString {
    public static String reverseString(String str) 
	{
		int start = -1, end = -1;
        StringBuilder sb = new StringBuilder();

        for(int i = str.length() - 1; i >= 0; i--)
        {
            if(str.charAt(i) != ' ')
            {
                end = i;
                while(i >= 0)
                {
                    if(i == 0 || str.charAt(i - 1) == ' ')
                    {
                        start = i;
                        break;
                    }
                    i--;
                }

                if(start != -1 && end != -1)
                {
                    sb.append(str.substring(start, end + 1) + " ");
                    start = -1;
                    end = -1;
                }
            }
        }

        return (sb.length() == 0) ? sb.toString() : sb.deleteCharAt(sb.length() - 1).toString();
	}
}