package leetcode.furthest_building_java;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        System.out.println("hello");
    }
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        Queue<Integer> q = new PriorityQueue<>();
        int i;
        for(i=0;i<heights.length-1;i++){
            if(heights[i] >= heights[i+1]) continue;
            int h = heights[i+1] - heights[i];

            if (ladders == 0) {
                if(!q.isEmpty()){
                    if(q.peek() < h) {
                        bricks -= q.poll();
                        q.add(h);
                    }
                    else bricks -= h;
                }
                else bricks -= h;
                if (bricks < 0) break;
            }
            else {
                ladders--;
                q.add(h);
            }
        }
        return i;
    }
}
