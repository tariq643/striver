package dsa.striver.greedyalgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NMeetingsInOneRoom {

    public int maxMeetings(int[] start, int[] end) {
        //your code goes here

        int count = 1;
        List<Meeting> meetingList = new ArrayList<>();
        for (int i = 0; i < start.length; i++) {
            meetingList.add(new Meeting(start[i], end[i], i + 1));
        }

        Collections.sort(meetingList, (m1,m2) -> {
            if (m1.getEndTime() > m2.getEndTime()) {
                return 1;
            }
            return -1;
        });

        int limit = meetingList.get(0).getEndTime();
        for (int i = 1; i < meetingList.size(); i++) {
            if (meetingList.get(i).getStartTime() > limit) {
                count++;
                limit = meetingList.get(i).getEndTime();
            }
        }
        return count;
    }

    public static void main(String[] args) {

        NMeetingsInOneRoom nMeetingsInOneRoom = new NMeetingsInOneRoom();
        int start[] = {1, 3, 0, 5, 8, 5};
        int end[] = {2, 4, 6, 7, 9, 9};
        nMeetingsInOneRoom.maxMeetings(start,end);
    }
}

class Meeting {

    private int startTime;
    private int endTime;
    private int pos;

    public Meeting(int startTime, int endTime, int pos) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.pos = pos;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                ", pos=" + pos +
                '}';
    }
}
