package AdvancedDSA.InterviewQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeOverlappingIntervals {
    public static void main(String[] args) {

    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        int n = intervals.size();

        Collections.sort(intervals, new Comparator <Interval>(){
            public int compare (Interval p1, Interval p2){
                if (p1.start != p2.start){
                    return p1.start - p2.start;
                }
                return p1.end - p2.end;
            }
        });

        ArrayList<Interval> ans = new ArrayList<>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (int i = 1; i < n; i++) {
            int currentStart = intervals.get(i).start;
            int currentEnd = intervals.get(i).end;

            if (currentStart <= end) {
                end = Math.max(currentEnd, end);
            } else {
                ans.add(new Interval(start, end));
                start = currentStart;
                end = currentEnd;
            }
        }
        ans.add(new Interval(start, end));
        return ans;
    }
}
