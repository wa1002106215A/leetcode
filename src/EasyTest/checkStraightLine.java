package EasyTest;

import java.util.Scanner;

public class checkStraightLine {
    public static boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length==1||coordinates.length==2)
            return true;
        if (coordinates[1][1]-coordinates[0][1]==0)
        {
            for (int i=2;i<coordinates.length;i++)
            {
                if(coordinates[i][1]!=coordinates[0][1])
                    return false;
            }
            return true;
        }
        if(coordinates[1][0]-coordinates[0][0]==0)
        {
            for (int i=2;i<coordinates.length;i++){
                if(coordinates[i][0]!=coordinates[0][0])
                    return false;
            }
            return true;
        }

        double k=((coordinates[1][1]-coordinates[0][1])*1.0)/(coordinates[1][0]-coordinates[0][0]);
        for(int i=2;i<coordinates.length;i++)
        {
            int x1=coordinates[i-1][0];
            int y1=coordinates[i-1][1];
            int x2=coordinates[i][0];
            int y2=coordinates[i][1];
            if((double)(y2-y1)/(x2-x1)!=k)
            {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int len=scanner.nextInt();
        int[][] coordinates=new int[len][2];
        for (int i=0;i<len;i++){
            for(int j=0;j<2;j++)
            {
                coordinates[i][j]=scanner.nextInt();
            }
        }
        System.out.println(checkStraightLine(coordinates));


    }
}
