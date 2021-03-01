package recursion;

public class mazeTest {
    public static void main(String[] args) {
        int[][] ints = mazeMake(8, 7);
        mazeWay(ints,1,1);
        show(ints);
        // 1：墙 2：走过的 3：走过不通的 0：未走过的
        // Q：最短路径？
    }

    public static int[][] mazeMake(int a, int b) {
        int[][] x = new int[a][b];
        for (int i = 0; i < a; i++) {
            x[i][0] = 1;
            x[i][b - 1] = 1;
        }
        for (int j = 0; j < b; j++) {
            x[a - 1][j] = 1;
            x[0][j] = 1;
        }
        x[3][1] = 1;
        x[3][2] = 1;

        return x;
    }

    public static void show(int[][] x) {
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[x.length - 1].length; j++) {
                System.out.print(x[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static boolean mazeWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {
                //按照 下 右 上 左的循序
                map[i][j]=2;
                if(mazeWay(map,i+1,j)){
                    return true;
                }else if(mazeWay(map,i,j+1)){
                    return true;

                }else if(mazeWay(map, i-1, j)){
                    return true;
                }else if(mazeWay(map, i, j-1)){
                    return true;
                }else {
                    //不通置为 3
                    map[i][j]=3;
                    return false;
                }
            }else {
                //当遇到的数字不为0时，1,2,3时
                //按照常理 不可能为2 ，因为如果是2会一直处于递归中，要么成功，要么是3；
                return false;
            }
        }
    }
}