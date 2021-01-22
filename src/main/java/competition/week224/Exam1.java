package competition.week224;

public class Exam1 {
    public int countGoodRectangles(int[][] rectangles) {
        int res = 0;
        int max = 0;
        for (int i = 0; i < rectangles.length; i++) {
            int temp = Math.min(rectangles[i][0],rectangles[i][1]);
            if(temp > max){
                max = temp;
                res = 1;
            }else if(temp == max){
                res++;
            }
        }
        return res;
    }
}
