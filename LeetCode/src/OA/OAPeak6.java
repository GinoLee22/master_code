package OA;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ginolee on 9/13/17.
 */
public class OAPeak6 {
    /**
     * Problem 1
     */

    public int problem1(int[] playerSpds, int[][] spdMatrix) {
        return runScore(playerSpds, spdMatrix);
    }

    /**
     * return if the current player can hit the pitch
     * spdLmt: represents the speed limit of current player
     * pitchSpds: size == 3 -> represents the speed of 3 pitches
     */
    private boolean playerHit(int spdLmt, int[] pitchSpds) {
        for (int spd : pitchSpds) {
            if (spdLmt >= spd) {
                return true;
            }
        }
        return false;
    }

    /**
     * return the final run score
     * playerSpds: dimension n, speed limit of each player
     * spdMatrix: demension n * 3, eah row is pitchSpds
     * Here is a trick: initial set runscore = -3
     */
    private int runScore(int[] playerSpds, int[][] spdMatrix) {
        int score = -3;
        int n = playerSpds.length;
        for (int i = 0; i < n; i++) {
            if (playerHit(playerSpds[i], spdMatrix[i])) {
                score++;
            }
        }
        return score <= 0 ? 0 : score;
    }

    /**
     * problem 2
     * presumption: playersPos.length == rs.length
     */
    public boolean problem2(int[][] playersPos, int[] rs, int ballX, int ballY) {
        int n = playersPos.length;
        for (int i = 0; i < n; i++) {
            List<int[]> positions = reachPos(playersPos[i], rs[i]);
            if (isReach(positions, ballX, ballY)) {
                return true;
            }
        }
        return false;
    }


    /**
     * return all possible positions of a specific play can reach
     */
    private List<int[]> reachPos (int[] curPos, int r) {
        List<int[]> res = new ArrayList<>();
        res.add(curPos);
        // X reach points
        for (int x = -r; x <= r; x++) {
            if (x == 0) {
                continue;
            }
            res.add(new int[] {curPos[0] + x, curPos[1]});
        }
        // Y reach points
        for (int y = -r; y <= r; y++) {
            if (y == 0) {
                continue;
            }
            res.add(new int[] {curPos[0], curPos[1] + y});
        }
        return res;
    }

    private boolean isReach(List<int[]> positions, int ballX, int ballY) {
        for (int[] position : positions) {
            if (ballX * position[1] == ballY * position[0]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("\n ----- self-testing for problem 1");
        OAPeak6 oaPeak6 = new OAPeak6();
//        int[] playerSpds = new int[] {5, 2, 4, 3, 5};
//        int[][] spdMatrix = new int[][] {{5, 4, 4}, {3, 3, 3}, {3, 4, 5}, {5, 3, 3}, {7, 4, 4}};
//        System.out.println(oaPeak6.problem1(playerSpds, spdMatrix));

        int[] batterSpeedLimits = {10,10,10,10,10};
        int[][] pitchSpeeds = {{11,11,11},
                {1,1,1},
                {2,2,2},
                {2,2,2},
                {5,5,5}};
        System.out.println(oaPeak6.problem1(batterSpeedLimits, pitchSpeeds));

        System.out.println("\n ----- self-testing for problem 2");
        List<int[]> test = oaPeak6.reachPos(new int[] {3, 4}, 2);
        for (int[] t : test) {
            System.out.print("(" + t[0] + ", " + t[1] + ") ");
            System.out.println();
        }
        int ballTrajectoryX = 2;
        int ballTrajectoryY = 3;
        int[][] outfieldPlayerPositions = new int[][] {{3,4}};
        int[] outfieldPlayerReaches = {2};
        System.out.println(oaPeak6.problem2(outfieldPlayerPositions, outfieldPlayerReaches, ballTrajectoryX, ballTrajectoryY));

    }
}
