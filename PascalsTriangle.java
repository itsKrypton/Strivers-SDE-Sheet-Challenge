import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> output = new ArrayList<>();
        if(numRows == 1)
        {
            return new ArrayList<>(
                Arrays.asList(
                    Arrays.asList(1)
                )
            );
        }
        
        for(int i = 0; i < numRows; i++)  {
            output.add(new ArrayList<Integer>());
        }

        output.get(0).add(1);

        for(int i=1;i<numRows;i++)
        {
            for(int j=0;j<=i;j++)
            {
                if(j==0 || j==i)
                {
                    output.get(i).add(1);
                    continue;
                }

                output.get(i).add(
                    output.get(i-1).get(j-1) + output.get(i-1).get(j)
                );
            }
        }

        return output;
    }
}
