package TicTacToe;


public class TicTacToe {
    private int n, m, k, round = 0, nameCount = 0, board[][], score[];
    private String names[];
    private boolean invisible = false, retard = false;
    public TicTacToe() {
        this(3, 3, 2, "");
    }
    public TicTacToe(String s) {
        this(3, 3, 2, s);
    }
    public TicTacToe(int n) {
        this(n, n, 2, "");
    }
    public TicTacToe(int n, int m) {
        this(n, m, 2, "");
    }
    public TicTacToe(int n, int m, int k) {
        this(n, m, k, "");
    }
    public TicTacToe(int n,String s) {
        this(n, n, 2, s);
    }
    public TicTacToe(int n, int m,String s) {
        this(n, m, 2, s);
    }

    public TicTacToe(int n, int m, int k, String s) {
        switch (s) {
            case "invisible":
            case "i":
                this.n = n;
                this.m = m;
                this.k = k;
                if (n != 1) invisible = true;
                break;
            case "forever alone":
            case "fa":
                this.n = 10;
                this.m = 11;
                this.k = 1;
                break;
            case "normal":
            case "not retard mode":
            case "standard":
                this.n = 3;
                this.m = 3;
                this.k = 2;
                break;
            case "3 player":
                this.n = 4;
                this.m = 4;
                this.k = 3;
                break;
            case "unwinable":
            case "for lolz":
            case "uw":
                this.n = 3;
                this.m = 100;
                this.k = 2;
                break;
            case "random":
            case "retard mode":
            case "retard":
                if (!s.equals("random")) retard = true;
                this.n = ((int) (Math.random()*10)) + 1;
                this.m = ((int) Math.ceil(Math.random()*n));
                this.k = ((int) (Math.random()*10)) + 1;
                if (Math.random()*10 > 7) {
                    this.m = 100;
                }
                if (Math.random()*10 > 9) {
                    invisible = true;
                }
                break;
            default:
                this.n = n;
                this.m = m;
                this.k = k;
                break;
        }
        if (!retard) {
            System.out.printf("%1$dx%1$d brett\n%2$d på rad\n%3$d spillere\n%4$s", this.n, this.m, this.k, invisible ? "Usynelig":"");
        }

        board = new int[this.n][this.n];
        names = new String[this.k];
        score = new int[this.k];
    }

    public int[] placer(int x, int y, int type) {
        int coordinates[];
        coordinates = new int[]{x, y};
        board[x][y] = type;
        return coordinates;
    }

    public int[] place() {
        int coordinates[], x, y;
        do {
            coordinates = TicTacToeProgram.place(n,getPlayer(0));
            x = coordinates[0];
            y = coordinates[1];
        } while (board[x][y] != 0);
        board[x][y] = round%k+1;
        round++;
        return coordinates;
    }

    private boolean DEAD_METHOD_BUT_I_LIKE_IT_ANYWAY(int[] coordinates) {
        int x = coordinates[0];
        int y = coordinates[1];

        if (check(board[x])) return true;
        int[] verticalList = new int[n];
        for (int j = 0;j < n;j++) {
            verticalList[j] = board[j][y];
        }
        if (check(verticalList)) return true;
        if (x == y || x == n-y-1) {
            int[] diagonalList = new int[n];
            for (int i = 0;i < n;i++) {
                if (x == y) {
                    diagonalList[i] = board[i][i];
                } else {
                    diagonalList[i] = board[i][n-i-1];
                }
            }
            return check(diagonalList);
        } else return false;
    }

    public boolean finished(int[] coordinates) {
        int x = coordinates[0];
        int y = coordinates[1];
        int type = board[x][y];
        boolean bool = false;

        for (int i = -1;i <= 1;i++) {
            for (int j = -1;j <= 1;j++) {
                if ((i == 0 && j == 0) ||
                        x+i < 0 || y+j < 0 || x+i >= n || y+j >= n) continue;
                if (board[x+i][y+j] == type) {
                    if (i == 0) {
                        bool = checkLine(coordinates, "vertical");
                    } else if (j == 0) {
                        bool = checkLine(coordinates, "horisontal");
                    } else if (i == j) {
                        bool = checkLine(coordinates, "down diagonal");
                    } else if (i == -j) {
                        bool = checkLine(coordinates, "up diagonal");
                    } else {
                        System.out.println("Something went terribly wrong!");
                    }
                }
                if (bool) {
                    invisible = false;
                    System.out.printf("%s\n%s won!", this, getPlayer(1));
                    return true;
                }
            }
        }
        if (round%(n*n) == 0) {
            invisible = false;
            System.out.println(this);
            System.out.print("\nEPIC FAIL!\nPlay again");
            board = new int[n][n];

        }
        return m == 1;
    }

    private boolean checkLine(int[] coordinates, String direction) {
        int x = coordinates[0];
        int y = coordinates[1];

        switch (direction) {
            case "vertical":
                return check(board[x]);
            case "horisontal":
                int[] verticalList = new int[n];
                for (int j = 0;j < n;j++) {
                    verticalList[j] = board[j][y];
                }
                return check(verticalList);
            case "down diagonal":
                int dif = x-y;
                if (n - Math.abs(dif) >= m) {
                    int[] diagonalList = new int[n-Math.abs(dif)];
                    for (int i = 0;i < diagonalList.length;i++) {
                        if (dif < 0) {
                            diagonalList[i] = board[i][i-dif];
                        } else diagonalList[i] = board[i+dif][i];
                    }
                    return check(diagonalList);
                } break;
            case "up diagonal":
                dif = x-(n-y-1);
                if (n - Math.abs(dif) >= m) {
                    int[] diagonalList = new int[n-Math.abs(dif)];
                    for (int i = 0;i < diagonalList.length;i++) {
                        if (dif < 0) {
                            diagonalList[i] = board[n-i-1+dif][i];
                        } else diagonalList[i] = board[n-i-1][i+dif];
                    }
                    return check(diagonalList);
                } break;
            default:
                System.out.println(direction);
                System.out.println("Something went completey wrong!");
                break;
        }
        return false;
    }

    private boolean check(int[] list) {
        int ant = 0, type = 0;

        for (int field : list) {
            if (field != 0 && ant == 0) {
                type = field;
                ant++;
            } else if (field != 0 && type == field) {
                ant++;
            } else {
                ant = 0;
                type = 0;
            }
            if (ant == m) {
                return true;
            }
        }
        return false;
    }

    public void name() {
        TicTacToeProgram.name(names);
    }
    public void name(String name) {
        name(name, nameCount +1);
    }
    public void name(String name, int player) {
        if (player <= k) {
            names[player-1] = name;
            nameCount++;
        }
    }

    public int[] clear() {
        int winner = this.getPlayerInt(1);
        score[winner]++;
        round = 0;
        board = new int[n][n];
        return score;
    }

    private void exept(String s) throws Exception {
        throw new Exception(s);
    }

    public int getPlayerInt(int roundsAgo) {
        return Math.floorMod(round-roundsAgo, k);
    }

    public String getPlayer(int roundsAgo) {
        int playerMod = Math.floorMod(round-roundsAgo, k);
        if (names[playerMod] != null) {
            return names[playerMod];
        } else
            return "Player "+ (playerMod+1);
    }

    public String[] getNames() {
        return names;
    }

    @Override
    public String toString() {
        final char[] piece;
        if (!invisible) piece = new char[]{'.', 'x', 'o', '+'};
        else piece = new char[]{'.', '.', '.', '.'};

        String returnStr = "";
        if (k <= 3 || invisible) {
            for (int[] list : board) {
                returnStr += "\n\n";
                for (int n : list) {
                    returnStr += piece[n%4]+"   ";
                }
            }
        } else {
            for (int[] list : board) {
                returnStr += "\n\n";
                for (int n : list) {
                    returnStr += (n == 0 ? ".":n)+"   ";
                }
            }
        }
        return returnStr;
    }
}
