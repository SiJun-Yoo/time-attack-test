class Minesweeper
{
    private static final int dx[] = {0,0,1,1,1,-1,-1,-1};
    private static final int dy[] = {-1,1,1,-1,0,1,-1,0};
    public static int MAP_X = 10;
    public static int MAP_Y = 10;

    private int[][] map;
    private int numOfpick;
    public Minesweeper(int[][] map) { this.map = map; this.numOfpick = 0;}

    public int pick(int x, int y)
    {
        int numOfMine = 0;
        // todo
        if(map[x][y] == 1) return -1;
        if(map[x][y] == 0){
            map[x][y] = 2;
        }
        for(int i=0;i<8;i++){
            int mx = x+dx[i];
            int my = y+dy[i];
            if(mx<0||my<0||mx>=10||my>=10) continue;
            if(map[mx][my] == 0) {
                map[mx][my] = 2;
                continue;
            }
            numOfMine++;
        }
        return numOfMine;
    }

    public int getNumOfpick()
    {
        return numOfpick;
    }

    public boolean checkMap()
    {
        // todo
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                if(map[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }

    public void printMap() {
        for(int i = 0; i < MAP_X; i++) {
            for(int j = 0; j < MAP_Y; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
}