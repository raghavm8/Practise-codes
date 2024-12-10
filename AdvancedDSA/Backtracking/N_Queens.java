package AdvancedDSA.Backtracking;

import java.util.ArrayList;

public class N_Queens {
    public static void main(String[] args) {
        int n = 4;
        N_Queens queens = new N_Queens();
        ArrayList<ArrayList<String>> ans = queens.solveNQueens(n);

        for (ArrayList<String> arrayList : ans) {
            for (String string : arrayList) {
                System.out.print(string);
                // System.out.print("** ");
            }
            // System.out.println("||");
        }
    }

    public ArrayList<ArrayList<String>> solveNQueens(int a) {
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();

        for (int i = 0; i < a; i++) {
            temp.add(-1);
        }
        nQueens(ans, a, 0, temp);
        return ans;
    }

    private void nQueens(ArrayList<ArrayList<String>> ans, int a, int row, ArrayList<Integer> queenPositions) {
        if (row == a) {
            ans.add(getPositionString(queenPositions));
            return;
        }

        for (int col = 0; col < a; col++) {
            if (isValid(row, col, queenPositions)) {
                queenPositions.set(row, col);
                nQueens(ans, a, row + 1, queenPositions);
                queenPositions.set(row, -1);
            }
        }
    }

    public boolean isInPath(int x1, int y1, int x2, int y2) {
        return (x1 == x2 || y1 == y2 || (x1 + y1 == x2 + y2) || (x1 - y1 == x2 - y2));
    }

    public boolean isValid(int row, int col, ArrayList<Integer> queenPositions) {
        for (int i = 0; i < row; i++) {
            if (isInPath(row, col, i, queenPositions.get(i)))
                return false;
        }
        return true;
    }

    private ArrayList<String> getPositionString(ArrayList<Integer> queenPositions) {
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < queenPositions.size(); i++) {
            StringBuilder string = new StringBuilder();
            for (int j = 0; j < queenPositions.size(); j++) {
                if (queenPositions.get(i) == j)
                    string.append('Q');
                else
                    string.append('.');
            }
            ans.add(string.toString());
        }
        return ans;
    }
}

