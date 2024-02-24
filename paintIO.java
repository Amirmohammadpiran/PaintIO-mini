import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;
import java.util.Random;

public class paintIO{
    
    static String[][] map = buildMap();
    static String[][] map_copy = buildMap();
    static ImageIcon empty = new ImageIcon("images/Empty.jpg");
    static ImageIcon background = new ImageIcon("images/background.jpg");
    static ImageIcon dark_player = new ImageIcon("images/Dark_player.jpg");
    static ImageIcon dark_house = new ImageIcon("images/Dark_house.jpg");
    static ImageIcon dark_path = new ImageIcon("images/Dark_path.jpg");
    static ImageIcon dark_button = new ImageIcon("images/Dark_button.jpg");
    static ImageIcon yellow_player = new ImageIcon("images/Yellow_player.jpg");
    static ImageIcon yellow_house = new ImageIcon("images/Yellow_house.jpg");
    static ImageIcon yellow_path = new ImageIcon("images/Yellow_path.jpg");
    static ImageIcon yellow_button = new ImageIcon("images/Yellow_button.jpg");
    static ImageIcon green_player = new ImageIcon("images/Green_player.jpg");
    static ImageIcon green_house = new ImageIcon("images/Green_house.jpg");
    static ImageIcon green_path = new ImageIcon("images/Green_path.jpg");
    static ImageIcon fast_button = new ImageIcon("images/Fast_button.jpg");
    static ImageIcon medium_button = new ImageIcon("images/Medium_button.jpg");
    static ImageIcon slow_button = new ImageIcon("images/Slow_button.jpg");
    static ImageIcon green_button = new ImageIcon("images/Green_button.jpg");
    static String direction = "Up";
    static String player;
    static String player_house;
    static String player_path;
    static String opponent1;
    static String opponent1_house;
    static String opponent1_path;
    static String opponent2;
    static String opponent2_house;
    static String opponent2_path;
    static int iPlayer = 50;
    static int jPlayer = 50;
    static int iOpponent1 = 30;
    static int jOpponent1 = 50;
    static int iOpponent2 = 50;
    static int jOpponent2 = 80;
    static int speed;
    static int gunUse;
    static Boolean insideHouse = false;
    static Boolean opponent1_dead = false;
    static Boolean opponent2_dead = false;


    public static void buildElementaryHouses(){

        map[51][50] = player_house;
        map[51][51] = player_house;
        map[51][52] = player_house;
        map[52][50] = player_house;
        map[52][51] = player_house;
        map[52][52] = player_house;
        map[53][50] = player_house;
        map[53][51] = player_house;
        map[53][52] = player_house;

        map[30][50] = opponent1;
        map[30][51] = opponent1_path;
        map[30][52] = opponent1_house;
        map[29][52] = opponent1_house;
        map[31][52] = opponent1_house;
        map[30][53] = opponent1_house;
        map[29][53] = opponent1_house;
        map[31][53] = opponent1_house;
        map[30][54] = opponent1_house;
        map[29][54] = opponent1_house;
        map[31][54] = opponent1_house;

        map[50][80] = opponent2;
        map[50][81] = opponent2_path;
        map[50][82] = opponent2_house;
        map[49][82] = opponent2_house;
        map[51][82] = opponent2_house;
        map[50][83] = opponent2_house;
        map[49][83] = opponent2_house;
        map[51][83] = opponent2_house;
        map[50][84] = opponent2_house;
        map[49][84] = opponent2_house;
        map[51][84] = opponent2_house;
    }

    public static void setPlayer(JFrame frame){

        frame.setLayout(null);

        JButton darkButton = new JButton();
        darkButton.setBounds(200, 120, 126, 81);
        frame.add(darkButton);
        darkButton.setIcon(dark_button);

        JButton greenButton = new JButton();
        greenButton.setBounds(200, 271, 126, 81);
        frame.add(greenButton);
        greenButton.setIcon(green_button);

        JButton yellowButton = new JButton();
        yellowButton.setBounds(200, 422, 126, 81);
        frame.add(yellowButton);
        yellowButton.setIcon(yellow_button);

        JLabel textLabel = new JLabel();
        textLabel.setText("Choose your player:");
        textLabel.setFont(new Font(textLabel.getFont().getName(), Font.PLAIN, 32));
        textLabel.setBounds(110, 30, 400, 40);
        frame.add(textLabel);

        JLabel backgroundLabel = new JLabel();
        backgroundLabel.setBounds(0, 0, 546, 604);
        frame.add(backgroundLabel);
        backgroundLabel.setIcon(background);

        while(player == null) {
            yellowButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    player = "Yellow Player";
                    player_house = "Yellow House";
                    player_path =  "Yellow Path";
                    opponent1 = "Dark Player";
                    opponent1_house = "Dark House";
                    opponent1_path = "Dark Path";
                    opponent2 = "Green Player";
                    opponent2_house = "Green House";
                    opponent2_path = "Green Path";
                    frame.dispose();
                    return;
                }
            });

            greenButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    player = "Green Player";
                    player_house = "Green House";
                    player_path =  "Green Path";
                    opponent1 = "Dark Player";
                    opponent1_house = "Dark House";
                    opponent1_path = "Dark Path";
                    opponent2 = "Yellow Player";
                    opponent2_house = "Yellow House";
                    opponent2_path = "Yellow Path";
                    frame.dispose();
                    return;
                }
            });

            darkButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    player = "Dark Player";
                    player_house = "Dark House";
                    player_path =  "Dark Path";
                    opponent1 = "Yellow Player";
                    opponent1_house = "Yellow House";
                    opponent1_path = "Yellow Path";
                    opponent2 = "Green Player";
                    opponent2_house = "Green House";
                    opponent2_path = "Green Path";
                    frame.dispose();
                    return;
                }
            });
        }
    }


        public static void setSpeed(JFrame frame){

            frame.setLayout(null);

            JButton fastButton = new JButton();
            fastButton.setBounds(200, 120, 126, 81);
            frame.add(fastButton);
            fastButton.setIcon(fast_button);

            JButton mediumButton = new JButton();
            mediumButton.setBounds(200, 271, 126, 81);
            frame.add(mediumButton);
            mediumButton.setIcon(medium_button);

            JButton slowButton = new JButton();
            slowButton.setBounds(200, 422, 126, 81);
            frame.add(slowButton);
            slowButton.setIcon(slow_button);

            JLabel textLabel = new JLabel();
            textLabel.setText("Choose speed:");
            textLabel.setFont(new Font(textLabel.getFont().getName(), Font.PLAIN, 32));
            textLabel.setBounds(150, 30, 400, 40);
            frame.add(textLabel);

            JLabel backgroundLabel = new JLabel();
            backgroundLabel.setBounds(0, 0, 546, 604);
            frame.add(backgroundLabel);
            backgroundLabel.setIcon(background);

            while(speed == 0) {
                fastButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        speed = 600;
                        frame.dispose();
                        return;
                    }
                });

                mediumButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        speed = 1000;
                        frame.dispose();
                        return;
                    }
                });

                slowButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        speed = 1400;
                        frame.dispose();
                        return;
                    }
                });
            }
    }


    public static KeyListener change_player(){
        return new KeyListener(){

               public void keyPressed(KeyEvent e) {
                   if(e.getKeyCode() == KeyEvent.VK_UP){
                       direction = "Up";
                   }else if(e.getKeyCode() == KeyEvent.VK_DOWN){
                       direction = "Down";
                   }else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                       direction = "Right";
                   }else if(e.getKeyCode() == KeyEvent.VK_LEFT){
                       direction = "Left";
                   }
               }

               public void keyTyped(KeyEvent e) {}
               public void keyReleased(KeyEvent e) {}
            };
    }

    public static JLabel[][] buildLabels() {

        JLabel[][] labels = new JLabel[7][7];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                labels[i][j] = new JLabel();
            }
        }
        return labels;
    }


    public static String[][] buildMap(){

        String[][] map = new String[100][100];
        for(int i=0; i<100; i++){
            for(int j=0; j<100; j++){
                map[i][j] = "Empty";
            }
        }
        return map;
    }

    public static void showMap(JLabel[][] labels, String[][] map, JFrame frame){

        ImageIcon temp = null;

        for(int i=0; i<7; i++){
            for(int j=0; j<7; j++){

                switch(map[i][j]){
                    case "Empty":{   
                        temp = empty;
                        break;
                    }
                    case "Dark Player":{  
                        temp = dark_player; 
                        break;
                    }
                    case "Dark Path":{  
                        temp = dark_path; 
                        break;
                    }
                    case "Dark House":{  
                        temp = dark_house; 
                        break;
                    }
                    case "Yellow Player":{  
                        temp = yellow_player; 
                        break;
                    }
                    case "Yellow Path":{  
                        temp = yellow_path; 
                        break;
                    }
                    case "Yellow House":{  
                        temp = yellow_house; 
                        break;
                    }
                    case "Green Player":{  
                        temp = green_player; 
                        break;
                    }
                    case "Green Path":{  
                        temp = green_path; 
                        break;
                    }
                    case "Green House":{  
                        temp = green_house; 
                        break;
                    }
                }

                labels[i][j].setBounds(j * 78, i * 81, 78, 81);
                labels[i][j].setIcon(temp);
                frame.getContentPane().add(labels[i][j]);
            }
        }
    }

    public static String[][] cutSmallMap(String[][] map, int i_start, int i_end, int j_start, int j_end){

        String[][] view = new String[i_end-i_start][j_end-j_start];

        for(int i=i_start, i_view=0; i<i_end; i++, i_view++){
            for(int j=j_start, j_view=0; j<j_end; j++, j_view++){
                
                view[i_view][j_view] = map[i][j];
            } 
        }
        return view;
    }

    public static void joinBlocks(int iPlayer, int jPlayer){

        pathToHouse(iPlayer, jPlayer);

        for(int i=1; i<98; i++){
            for(int j=1, surrounded=0; j<98; j++, surrounded=0){

                if(map[i-1][j] == player_house &&
                   map[i-1][j+1] == player_house){
                    surrounded++;
                }
                if(map[i][j-1] == player_house &&
                   map[i+1][j-1] == player_house){
                    surrounded++;
                }
                if(map[i][j+2] == player_house &&
                   map[i+1][j+2] == player_house){
                    surrounded++;
                }
                if(map[i+2][j] == player_house &&
                   map[i+2][j+1] == player_house){
                    surrounded++;
                }


                if(surrounded >= 3){
                    map[i][j] = player_house;
                    map[i+1][j+1] = player_house;
                    map[i][j+1] = player_house;
                    map[i+1][j] = player_house;
                }
            }
        }

        for(int i=1; i<99; i++){
            for(int j=1, surrounded=0; j<99; j++, surrounded=0){

                if(map[i-1][j] == player_house)
                    surrounded++;

                if(map[i][j-1] == player_house)
                    surrounded++;

                if(map[i+1][j] == player_house)
                    surrounded++;

                if(map[i][j+1] == player_house)
                    surrounded++;

                if(surrounded >= 3)
                    map[i][j] = player_house;

            }
        }
    }

    public static void killOpponent(String opponent, String opponent_house, String opponent_path){

        for(int i=0; i<100; i++){
            for(int j=0; j<100; j++){
                if(map[i][j] == opponent || map[i][j] == opponent_house || map[i][j] == opponent_path)
                map[i][j] = map_copy[i][j];
            }
        }
        if(opponent == opponent1){
            opponent1_dead = true;
        }else if(opponent == opponent2){
            opponent2_dead = true;
        }
    }

    public static void pathToHouse(int row, int col) {

        for(int i=row-1; i<=row+1; i++){
            for(int j=col-1; j<=col+1; j++){
                if(map[i][j] == player_path){
                    map[i][j] = player_house;
                    pathToHouse(i, j);
                }
            }
        }
        return;

    }

    public static KeyListener setDirection(){
        return new KeyListener(){
            
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_UP){
                    direction = "Up";
                }
                else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                    direction = "Right";
                }
                else if(e.getKeyCode() == KeyEvent.VK_DOWN){
                    direction = "Down";
                }
                else if(e.getKeyCode() == KeyEvent.VK_LEFT){
                    direction = "Left";
                }
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    gunUse = 1;
                }
                else if(e.getKeyCode() == KeyEvent.VK_SPACE){
                    gunUse = 2;
                }
            }

            public void keyTyped(KeyEvent e) {}
            public void keyReleased(KeyEvent e) {}
        };
    }

    public static void updatePath(String direction, Random rand){

        if(opponent1_dead == false){    
            int opponent1_direction = rand.nextInt(4);
            switch(opponent1_direction){
                case 0:{
                    map[iOpponent1][jOpponent1] = opponent1_path;
                    if(iOpponent1 != 0)
                        iOpponent1--;
                    break;
                }
                case 1:{
                    map[iOpponent1][jOpponent1] = opponent1_path;
                    if(iOpponent1 != 99)
                        iOpponent1++;
                    break;
                }
                case 2:{
                    map[iOpponent1][jOpponent1] = opponent1_path;
                    if(jOpponent1 != 0)
                        jOpponent1--;
                    break;
                }
                case 3:{
                    map[iOpponent1][jOpponent1] = opponent1_path;
                    if(jOpponent1 != 99)
                        jOpponent1++;
                    break;
                }
            }
            map[iOpponent1][jOpponent1] = opponent1;
        }

        if(opponent2_dead == false){    
            int opponent2_direction = rand.nextInt(4);
            switch(opponent2_direction){
                case 0:{
                    map[iOpponent2][jOpponent2] = opponent2_path;
                    if(iOpponent2 != 0)
                        iOpponent2--;
                    break;
                }
                case 1:{
                    map[iOpponent2][jOpponent2] = opponent2_path;
                    if(iOpponent2 != 99)
                        iOpponent2++;
                    break;
                }
                case 2:{
                    map[iOpponent2][jOpponent2] = opponent2_path;
                    if(jOpponent2 != 0)
                        jOpponent2--;
                    break;
                }
                case 3:{
                    map[iOpponent2][jOpponent2] = opponent2_path;
                    if(jOpponent2 != 99)
                        jOpponent2++;
                    break;
                }
                
            }
            map[iOpponent2][jOpponent2] = opponent2;
        }


        if(!insideHouse)
            map[iPlayer][jPlayer] = player_path;

        if(direction == "Up"){
            if(map[iPlayer-1][jPlayer] == player_house){
                insideHouse = true;
                joinBlocks(iPlayer, jPlayer);
            }
            else if(map[iPlayer-1][jPlayer] == opponent1_path){
                killOpponent(opponent1, opponent1_house, opponent1_path);
            }
            else if(map[iPlayer-1][jPlayer] == opponent2_path){
                killOpponent(opponent2, opponent2_house, opponent2_path);
            }
            else{
                insideHouse = false;
                map[iPlayer-1][jPlayer] = player_path;
            }

            iPlayer--;
        }
        else if(direction == "Right"){
            if(map[iPlayer][jPlayer+1] == player_house){
                insideHouse = true;
                joinBlocks(iPlayer, jPlayer);
            }
            else if(map[iPlayer][jPlayer+1] == opponent1_path){
                killOpponent(opponent1, opponent1_house, opponent1_path);
            }
            else if(map[iPlayer][jPlayer+1] == opponent2_path){
                killOpponent(opponent2, opponent2_house, opponent2_path);
            }
            else{
                insideHouse = false;
            }
            
            jPlayer++;
        }
        else if(direction == "Down"){
            if(map[iPlayer+1][jPlayer] == player_house){
                insideHouse = true;
                joinBlocks(iPlayer, jPlayer);
            }
            else if(map[iPlayer+1][jPlayer] == opponent1_path){
                killOpponent(opponent1, opponent1_house, opponent1_path);
            }
            else if(map[iPlayer+1][jPlayer] == opponent2_path){
                killOpponent(opponent2, opponent2_house, opponent2_path);
            }
            else{
                insideHouse = false;
            }

            iPlayer++;
        }
        else if(direction == "Left"){
            if(map[iPlayer][jPlayer-1] == player_house){
                insideHouse = true;
                joinBlocks(iPlayer, jPlayer);
            }
            else if(map[iPlayer][jPlayer-1] == opponent1_path){
                killOpponent(opponent1, opponent1_house, opponent1_path);
            }
            else if(map[iPlayer][jPlayer-1] == opponent2_path){
                killOpponent(opponent2, opponent2_house, opponent2_path);
            }
            else{
                insideHouse = false;
            }

            jPlayer--;
        }

        map[iPlayer][jPlayer] = player;

    } 

    public static int hitGun1(int bullets){

        int i_point = iPlayer;
        int j_point = jPlayer;

        if(direction == "Up"){
            i_point = iPlayer-4;
        }else if(direction == "Down"){
            i_point = iPlayer+4;
        }else if(direction == "Right"){
            j_point = jPlayer+4;
        }else{
            j_point = jPlayer-4;
        }
        
        for(int i = i_point-1; i <= i_point+1; i++){
            for(int j = j_point-1; j <= j_point+1; j++){

                if(map[i][j] == opponent1_path
                   || map[i][j] == opponent1_house
                   || map[i][j] == opponent1){
                    killOpponent(opponent1, opponent1_house, opponent1_path);
                }
                else if(map[i][j] == opponent2_path
                   || map[i][j] == opponent2_house
                   || map[i][j] == opponent2){
                    killOpponent(opponent2, opponent2_house, opponent2_path);
                }
                map[i][j] = player_house;
            }
        }
        return bullets-1;
    }

    public static void main(String[] args){

        JLabel[][] labels = buildLabels();
        int firstGun = 5;
        JFrame f = new JFrame();
        f.setSize(546,604);
        f.setVisible(true);
        setPlayer(f);

        JFrame f1 = new JFrame();
        f1.setSize(546,604);
        f1.setVisible(true);
        setSpeed(f1);

        buildElementaryHouses();
        String[][] view;
        Random rand = new Random();
        JFrame f2 = new JFrame();
        f2.setSize(546,604);

        if(player != null) {
            f2.setVisible(true);
        }

        while(true){

            updatePath(direction, rand);
            if(firstGun > 0){
                if(gunUse == 1) {
                    gunUse = 0;
                    firstGun = hitGun1(firstGun);
                }
            }
            view = cutSmallMap(map, iPlayer-3, iPlayer+4, jPlayer-3, jPlayer+4);
            showMap(labels, view, f2);
            f2.addKeyListener(setDirection());

            try{ TimeUnit.MILLISECONDS.sleep(speed); } 
            catch(InterruptedException InterruptedException){}
        }
    }
}