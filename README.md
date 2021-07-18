# landmines
踩地雷landmines

使用java製作

遊戲初始畫面
![landmines1](https://user-images.githubusercontent.com/87599252/126067000-92185ed9-f4b7-4b00-8684-85e06570c613.png)

最終勝利
![landmines2](https://user-images.githubusercontent.com/87599252/126067012-2f5f026a-f574-458a-af92-a429a453f490.png)

踩到地雷，遊戲失敗
![landmines3](https://user-images.githubusercontent.com/87599252/126067022-8903ba79-cb97-47e4-95d3-ebc5443246de.png)



程式為最初開發必須要每一個按鈕都要自己來按，此版本有做改良，

當選擇到的按鈕周遭都沒有地雷時，會幫玩家將周圍8格也一起打開，增加遊戲體驗順暢度

預設地圖為9*9，地雷10個，可以自行設定變更，

在Frame.java中，第22,23行
public static JButton button[][]=new JButton[9][9];
public static int bomb_num = 10;
