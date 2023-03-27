package exe;

public class NumberToChineseUtil {
    private static final char[] CN_NUMERIC = {'零','壹','贰','叁','肆','伍','陆','柒','捌','玖'};
    private static final char[] CN_UNITS = {'元','拾','佰','仟','万','拾','佰','仟','亿'};

    public static String toChineseRMB(double money) {
        long integralPart = (long) money; // 整数部分
        String decimalPart = String.format("%.2f", money - integralPart).substring(2); // 小数部分
        StringBuilder resultBuilder = new StringBuilder();
        // 处理整数部分
        if (integralPart == 0) {
            resultBuilder.append(CN_NUMERIC[0]);
        } else {
            String integralStr = String.valueOf(integralPart);
            int integralLen = integralStr.length();
            boolean needZero = false;
            for (int i = 0; i < integralLen; i++) {
                int digit = integralStr.charAt(i) - '0';
                if (digit == 0) {
                    needZero = true;
                } else {
                    if (needZero) {
                        resultBuilder.append(CN_NUMERIC[0]);
                        needZero = false;
                    }
                    resultBuilder.append(CN_NUMERIC[digit]);
                    resultBuilder.append(CN_UNITS[integralLen - i - 1]);
                }
            }
        }
        // 处理小数部分
        int decimalPartLen = decimalPart.length();
        if (decimalPartLen > 0) {
            int jiao = decimalPart.charAt(0) - '0';
            int fen = decimalPartLen > 1 ? decimalPart.charAt(1) - '0' : 0;
            if (jiao > 0) {
                resultBuilder.append(CN_NUMERIC[jiao]);
                resultBuilder.append('角');
            }
            if (fen > 0) {
                resultBuilder.append(CN_NUMERIC[fen]);
                resultBuilder.append('分');
            }
        }
        return resultBuilder.toString();
    }
}