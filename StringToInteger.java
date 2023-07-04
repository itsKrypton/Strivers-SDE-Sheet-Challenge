public class StringToInteger {
    public int myAtoi(String s) {
        int i = 0;
        boolean resultIsNegative = false;
        long answer = 0;

        while(i < s.length() && s.charAt(i) == ' ')
        i++;

        if(i < s.length() && s.charAt(i) == '-')
        {
            resultIsNegative = true;
            i++;
        }

        else if(i < s.length() && s.charAt(i) == '+')
        i++;

        while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9')
        {
            answer = (answer * 10);
            answer = (answer + (s.charAt(i) - '0'));
            i++;

            if(answer >= (long)(Integer.MAX_VALUE) + 1)
            {
                answer = (resultIsNegative) ? Integer.MAX_VALUE + 1 : Integer.MAX_VALUE;
                break;
            }
        }

        return (resultIsNegative) ? (int)(-1 * answer) : (int)answer;
    }
}
