public class CompareVersionNumbers {
    public static int compareVersions(String a, String b) 
    {
        String[] v1 = a.split("\\.");
        String[] v2 = b.split("\\.");

        for(int i = 0; i < Math.max(v1.length, v2.length); i++)
        {
            if(i < v1.length && i < v2.length)
            {
                String currV1 = v1[i];
                String currV2 = v2[i];
                int index1 = removeZeroes(currV1);
                int index2 = removeZeroes(currV2);

                if(currV1.length() - index1 > currV2.length() - index2)
                return 1;

                else if(currV1.length() - index1 < currV2.length() - index2)
                return -1;

                while(index1 < currV1.length())
                {
                    if(currV1.charAt(index1) > currV2.charAt(index2))
                    return 1;

                    else if(currV1.charAt(index1) < currV2.charAt(index2))
                    return -1;

                    index1++;
                    index2++;
                }
            }

            else if(i >= v1.length && v2[i].charAt(removeZeroes(v2[i])) != '0')
            return -1;

            else if(i >= v2.length && v1[i].charAt(removeZeroes(v1[i])) != '0')
            return 1;
        }

        return 0;
    }

    public static int removeZeroes(String s)
    {
        int i = 0;

        while(i < s.length() - 1 && s.charAt(i) == 0)
        i++;

        return i;
    }

    // If it is mentioned that the version numbers fit inside an integer value
    /* public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        for(int i = 0; i < Math.max(v1.length, v2.length); i++)
        {
            if(i < v1.length && i < v2.length)
            {
                if(Integer.valueOf(v1[i]) < Integer.valueOf(v2[i]))
                return -1;

                else if(Integer.valueOf(v1[i]) > Integer.valueOf(v2[i]))
                return 1;
            }

            else if(i >= v1.length && Integer.valueOf(v2[i]) != 0)
            return -1;

            else if(i >= v2.length && Integer.valueOf(v1[i]) != 0)
            return 1;
        }

        return 0;
    } */
}
