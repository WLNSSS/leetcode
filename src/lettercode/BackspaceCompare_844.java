package lettercode;

public class BackspaceCompare_844 {
	public boolean backspaceCompare(String S, String T) {
        if (S == null || T == null) {
            return false;
        }

        /*
            从后向前，遍历并比较两个字符串：
                (1)首先遍历S(或是 先遍历T也行)：
                    1、遇到'#'，就记录个数(sWell++)，让指针前移
                    2、若不是'#'，但sWell大于0(表示还有未抵消的'#')，则抵消当前字符，让指针前移
                    3、若上述两点都不满足，则结束当前循环，进行后续步骤
                (2)遍历T，如上进行操作
                (3)比较当前S和T的字符，若不相等，则返回false
                (4)往复循环如上步骤，直至任何一个字符串遍历完毕
         */
        int sWell = 0;  // 记录S中，还未抵消的#个数
        int tWell = 0;  // 记录T中，还未抵消的#个数
        int indexS = S.length() - 1;
        int indexT = T.length() - 1;
        while (indexS >= 0 || indexT >= 0) {
            //(1)首先遍历S(或是 先遍历T也行)：
            //    1、遇到'#'，就记录个数(sWell++)，让指针前移
            //    2、若不是'#'，但sWell大于0(表示还有未抵消的'#')，则抵消当前字符，让指针前移
            //    3、若上述两点都不满足，则结束当前循环，进行后续步骤
            while (indexS >= 0) {
                if (S.charAt(indexS) == '#') {
                    sWell++;
                    indexS--;
                } else if (sWell > 0) {
                    sWell--;
                    indexS--;
                } else {
                    break;
                }
            }

            // (2)遍历T，如上进行操作
            while (indexT >= 0) {
                if (T.charAt(indexT) == '#') {
                    tWell++;
                    indexT--;
                } else if (tWell > 0) {
                    tWell--;
                    indexT--;
                } else {
                    break;
                }
            }

            // (3)比较当前S和T的字符，若不相等，则返回false
            if (indexS >= 0 && indexT >= 0) {
                if (S.charAt(indexS) != T.charAt(indexT)) {
                    return false;
                }
            } else {
                if (indexS >= 0 || indexT >= 0) {
                    return false;
                }
            }
            indexS--;
            indexT--;
        }

        return true;
    }

}
