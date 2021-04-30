import java.util.Random;
import java.util.Scanner;

public class HomeWorkApp4 {

    public static class Lesson04 {

        public static char[][] map;
        public static int mapSizeX = 5;
        public static int mapSizeY = 8;
        public static int victoryCondition = 4; //условие выигрыша

        public static char human = 'X';
        public static char ai = 'O';
        public static char empty_field = '_';

        public static Scanner scanner = new Scanner(System.in);
        public static Random random = new Random();

        public static void createMap() {
            map = new char[mapSizeY][mapSizeX];

            for (int y = 0; y < mapSizeY; y++) {
                for (int x = 0; x < mapSizeX; x++) {
                    map[y][x] = empty_field;
                }
            }
        }

        public static void showMap() {
            for (int y = 0; y < mapSizeY; y++) {
                for (int x = 0; x < mapSizeX; x++) {
                    System.out.print(map[y][x] + "|");
                }
                System.out.println();
            }
            System.out.println("----------");
        }

        public static void humanTurn() {
            int x;
            int y;

            do {
                System.out.println("Enter your turn coordinates y[1;" + mapSizeY + "] and x[1;" + mapSizeX + "]:");
                y = scanner.nextInt() - 1;
                x = scanner.nextInt() - 1;
            } while (!isValidCell(y, x) || !isEmptyCell(y, x));
            map[y][x] = human;
        }

        public static void aiTurn() {
            int y;
            int x;
            int[] arrayYXai = preWinningCombination(ai);
            int[] arrayYXhuman = preWinningCombination(human);

            if (isValidCell(arrayYXai[0], arrayYXai[1])){
                System.out.println("AI turn is [" + (arrayYXai[0] + 1) + ":" + (arrayYXai[1] + 1) + "]");
                map[arrayYXai[0]][arrayYXai[1]] = ai;
            } else if (isValidCell(arrayYXhuman[0], arrayYXhuman[1])){
                System.out.println("AI turn is [" + (arrayYXhuman[0] + 1) + ":" + (arrayYXhuman[1] + 1) + "]");
                map[arrayYXhuman[0]][arrayYXhuman[1]] = ai;
            } else {
                do {
                    y = random.nextInt(mapSizeY); //[0;mapSize)
                    x = random.nextInt(mapSizeX);
                } while (!isEmptyCell(y, x));
                System.out.println("AI turn is [" + (y + 1) + ":" + (x + 1) + "]");
                map[y][x] = ai;
            }
        }

        public static boolean isValidCell(int y, int x) {
            return y >= 0 && y < mapSizeY && x >= 0 && x < mapSizeX;
        }

        public static boolean isEmptyCell(int y, int x) {
            return map[y][x] == empty_field;
        }

        public static boolean isDraw() {
            for (int y = 0; y < mapSizeY; y++) {
                for (int x = 0; x < mapSizeX; x++) {
                    if (map[y][x] == empty_field) {
                        return false;
                    }
                }
            }
            return true;
        }

        // определение победителя
        public static boolean isWin(char player) {
            int filledInRow = 0;

            // проходим по-горизонталям
            for (int i = 0; i < mapSizeY; i++) {
                for (int j = 0; j < mapSizeX; j++) {
                    if (map[i][j] == player) {
                        filledInRow++;
                        if (filledInRow == victoryCondition) {
                            return true;
                        }
                    } else {
                        filledInRow = 0;
                    }
                }
                filledInRow = 0;
            }

            //проходим по-вертикалям
            for (int j = 0; j < mapSizeX; j++){
                for (int i = 0; i < mapSizeY; i++){
                    if (map[i][j] == player) {
                        filledInRow++;
                        if (filledInRow == victoryCondition) {
                            return true;
                        }
                    } else {
                        filledInRow = 0;
                    }
                }
            filledInRow = 0;
            }

            //проходим по диагоналям под углом -45°
            for (int numberDiagonals = -mapSizeX + 1; numberDiagonals < mapSizeY; numberDiagonals++) {
                for (int i = 0; i < mapSizeY; i++) {
                    for (int j = 0; j < mapSizeX; j++) {
                        if (j == i - numberDiagonals) {
                            if (map[i][j] == player) {
                                filledInRow++;
                                if (filledInRow == victoryCondition){
                                    return true;
                                }
                            } else {
                                filledInRow = 0;
                            }
                        }
                    }
                }
                filledInRow = 0;
            }

            // проходим по диагоналям под углом 45°
            for (int numberDiagonals = -mapSizeX + 1; numberDiagonals < mapSizeY; numberDiagonals++) {
                for (int i = 0; i < mapSizeY; i++) {
                    for (int j = 0; j < mapSizeX; j++) {
                        if (j == i - numberDiagonals) {
                            if (map[mapSizeY - i - 1][j] == player) {
                                filledInRow++;
                                if (filledInRow == victoryCondition){
                                    return true;
                                }
                            } else {
                                filledInRow = 0;
                            }
                        }
                    }
                }
                filledInRow = 0;
            }
            return false;
        }

        //получение координат в предвыигрышной ситуации
        public static int[] preWinningCombination (char player){
            int[] arrayYX = new int[2];

            // заполняем невалидными значениями по умолчанию
            arrayYX[0] = mapSizeY;
            arrayYX[1] = mapSizeX;
            int filledInRow = 0;

            // проходим по-горизонталям
            for (int i = 0; i < mapSizeY; i++) {
                for (int j = 0; j < mapSizeX; j++) {
                    if (map[i][j] == player) {
                        filledInRow++;
                        if (filledInRow == victoryCondition - 1) {
                            if(isValidCell(i, j + 1) && isEmptyCell(i, j+1)){
                                arrayYX[0] = i;
                                arrayYX[1] = j + 1;
                                return arrayYX;
                            } else if (isValidCell(i, j - victoryCondition + 1) && isEmptyCell(i, j - victoryCondition + 1)){
                                arrayYX[0] = i;
                                arrayYX[1] = j - victoryCondition + 1;
                                return arrayYX;
                            }
                        }
                    } else {
                        filledInRow = 0;
                    }
                }
                filledInRow = 0;
            }

            //проходим по-вертикалям
            for (int j = 0; j < mapSizeX; j++){
                for (int i = 0; i < mapSizeY; i++){
                    if (map[i][j] == player) {
                        filledInRow++;
                        if (filledInRow == victoryCondition - 1) {
                            if(isValidCell(i + 1, j) && isEmptyCell(i + 1, j)){
                                arrayYX[0] = i + 1;
                                arrayYX[1] = j;
                                return arrayYX;
                            } else if (isValidCell(i - victoryCondition + 1, j) && isEmptyCell(i - victoryCondition + 1, j)){
                                arrayYX[0] = i - victoryCondition + 1;
                                arrayYX[1] = j;
                                return arrayYX;
                            }
                        }
                    } else {
                        filledInRow = 0;
                    }
                }
                filledInRow = 0;
            }

            //проходим по диагоналям под углом -45°
            for (int numberDiagonals = -mapSizeX + 1; numberDiagonals < mapSizeY; numberDiagonals++) {
                for (int i = 0; i < mapSizeY; i++) {
                    for (int j = 0; j < mapSizeX; j++) {
                        if (j == i - numberDiagonals) {
                            if (map[i][j] == player) {
                                filledInRow++;
                                if (filledInRow == victoryCondition - 1){
                                    if (isValidCell(i + 1, j + 1) && isEmptyCell(i + 1, j + 1)){
                                        arrayYX[0] = i + 1;
                                        arrayYX[1] = j + 1;
                                        return arrayYX;
                                    } else if (isValidCell(i - victoryCondition + 1, j - victoryCondition + 1) && isEmptyCell(i - victoryCondition + 1, j - victoryCondition + 1)){
                                        arrayYX[0] = i - victoryCondition + 1;
                                        arrayYX[1] = j - victoryCondition + 1;
                                        return arrayYX;
                                    }
                                }
                            } else {
                                filledInRow = 0;
                            }
                        }
                    }
                }
                filledInRow = 0;
            }

            // проходим по диагоналям под углом 45°
            for (int numberDiagonals = -mapSizeX + 1; numberDiagonals < mapSizeY; numberDiagonals++) {
                for (int i = 0; i < mapSizeY; i++) {
                    for (int j = 0; j < mapSizeX; j++) {
                        if (j == i - numberDiagonals) {
                            if (map[mapSizeY - i - 1][j] == player) {
                                filledInRow++;
                                if (filledInRow == victoryCondition - 1){
                                    if (isValidCell(mapSizeY - i - 2, j + 1) && isEmptyCell(mapSizeY - i - 2, j + 1)){
                                        arrayYX[0] = mapSizeY - i - 2;
                                        arrayYX[1] = j + 1;
                                        return arrayYX;
                                    } else if (isValidCell(mapSizeY - i + victoryCondition - 2, j - victoryCondition + 1) && isEmptyCell(mapSizeY - i + victoryCondition - 2, j - victoryCondition + 1)){
                                        arrayYX[0] = mapSizeY - i + victoryCondition - 2;
                                        arrayYX[1] = j - victoryCondition + 1;
                                        return arrayYX;
                                    }
                                }
                            } else {
                                filledInRow = 0;
                            }
                        }
                    }
                }
                filledInRow = 0;
            }

            return arrayYX;
        }

        public static void main(String[] args) {
            createMap();
            showMap();

            while (true) {
                humanTurn();
                showMap();
                if (isWin(human)) {
                    System.out.println("Human win!!!");
                    break;
                }

                if (isDraw()) {
                    System.out.println("Is Draw!!!");
                    break;
                }

                aiTurn();
                showMap();

                if (isWin(ai)) {
                    System.out.println("AI win!!!");
                    break;
                }

                if (isDraw()) {
                    System.out.println("Is Draw!!!");
                    break;
                }
            }
            System.out.println("Game over!");
        }
    }
}
