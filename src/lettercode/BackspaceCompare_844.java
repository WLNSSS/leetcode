package lettercode;

public class BackspaceCompare_844 {
	public boolean backspaceCompare(String S, String T) {
        if (S == null || T == null) {
            return false;
        }

        /*
            �Ӻ���ǰ���������Ƚ������ַ�����
                (1)���ȱ���S(���� �ȱ���TҲ��)��
                    1������'#'���ͼ�¼����(sWell++)����ָ��ǰ��
                    2��������'#'����sWell����0(��ʾ����δ������'#')���������ǰ�ַ�����ָ��ǰ��
                    3�����������㶼�����㣬�������ǰѭ�������к�������
                (2)����T�����Ͻ��в���
                (3)�Ƚϵ�ǰS��T���ַ���������ȣ��򷵻�false
                (4)����ѭ�����ϲ��裬ֱ���κ�һ���ַ����������
         */
        int sWell = 0;  // ��¼S�У���δ������#����
        int tWell = 0;  // ��¼T�У���δ������#����
        int indexS = S.length() - 1;
        int indexT = T.length() - 1;
        while (indexS >= 0 || indexT >= 0) {
            //(1)���ȱ���S(���� �ȱ���TҲ��)��
            //    1������'#'���ͼ�¼����(sWell++)����ָ��ǰ��
            //    2��������'#'����sWell����0(��ʾ����δ������'#')���������ǰ�ַ�����ָ��ǰ��
            //    3�����������㶼�����㣬�������ǰѭ�������к�������
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

            // (2)����T�����Ͻ��в���
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

            // (3)�Ƚϵ�ǰS��T���ַ���������ȣ��򷵻�false
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
