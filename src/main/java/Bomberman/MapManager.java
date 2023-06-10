package Bomberman;


import AllirEngine.GameObject;

public class MapManager {

    static TileTypes[][][] mapArray = new TileTypes[4][16][32];
    static GameObject[][][] objectMap = new GameObject[4][16][32];
    public static int currentMap=1;

    public MapManager(){
        for(int z=0;z<4;z++) {
            for (int y = 0; y < 16; y++) {
                for (int x = 0; x < 32; x++) {
                    mapArray[z][y][x] = TileTypes.empty;
                }
            }
        }
    }

    public static void SetTile(TileTypes tile,int mapNr, int x, int y){
        mapArray[mapNr-1][y][x]=tile;
    }
    public static TileTypes GetTile(int mapNr,int x, int y){
        return mapArray[mapNr-1][y][x];
    }
    public static void SetObject(GameObject object,int mapNr, int x, int y){
        objectMap[mapNr-1][y][x]=object;
    }
    public static GameObject GetObject(int mapNr,int x, int y){
        return objectMap[mapNr-1][y][x];
    }



}
