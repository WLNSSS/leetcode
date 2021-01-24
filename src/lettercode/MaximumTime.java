package lettercode;

public class MaximumTime {
	public String solution(String time) {
		String[] timeArr = time.split(":");
		String result = "";
		if(timeArr[0].charAt(0) == '?') {
			if(timeArr[0].charAt(1) < '4' || timeArr[0].charAt(1) == '?') {
				result = "2";
			}else {
				result = "1";
			}
		}else {
			result = timeArr[0].charAt(0) + "";
		}
		if(timeArr[0].charAt(1) == '?') {
			if(result.equals("2")) {
				result += "3";
			}else {
				result += "9";
			}
		}else {
			if(result.equals("2") && timeArr[0].charAt(1) > '4') {
					result = "1" + timeArr[0].charAt(1);
			}
			result += timeArr[0].charAt(1) + "";
		}
		result += ":";
		if(timeArr[1].charAt(0) == '?') {
			result += "5";
		}else {
			result += timeArr[1].charAt(0) + "";
		}
		if(timeArr[1].charAt(1) == '?') {
			if(result.charAt(3) =='6') {
				result += "0";
			}else {
				result += "9";
			}
		}else {
			result += timeArr[1].charAt(1) + "";
		}
		return result;
	}
	public static void main(String[] args) {
		MaximumTime mt = new MaximumTime();
		mt.solution("??:3?");
	}
}
