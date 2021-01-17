package lettercode;

public class CheckStraightLine_1232 {
	public boolean checkStraightLine(int[][] coordinates) {
        //(y1 - y0) / (x1 - x0) = (yi - y0) / (xi - x0)
        //转换成乘法避免斜率不存在
        //(y1 - y0) * (xi - x0) = (yi - y0) * (x1 - x0)
        int x0 = coordinates[0][0], y0 = coordinates[0][1], x1 = coordinates[1][0], y1 = coordinates[1][1];
        for(int i = 2; i < coordinates.length; i++) {
            if((y1 - y0) * (coordinates[i][0] - x0) != (coordinates[i][1] - y0) * (x1 - x0))
                return false;
        }
        return true;
    }
}
