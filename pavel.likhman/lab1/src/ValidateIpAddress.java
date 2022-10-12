public class ValidateIpAddress {
    public static String validateIpAddress(String ip) {
        if (isIPv4(ip)) {
            return "IPv4";
        } else if (isIPv6(ip)) {
            return "IPv6";
        } else {
            return "Neither";
        }
    }

    private static boolean isIPv4(String ip) {
        if (ip.length() < 7 || ip.charAt(0) == '.' || ip.charAt(ip.length() - 1) == '.') {
            return false;
        }

        String[] values = ip.split("\\.");
        if (values.length != 4) {
            return false;
        }

        for (String value : values) {
            if (!isCorrectIPv4Value(value)) {
                return false;
            }
        }

        return true;
    }

    private static boolean isCorrectIPv4Value(String value) {
        if (value.length() == 0 || (value.charAt(0) == '0' && value.length() > 1)) {
            return false;
        }

        try {
            int num = Integer.parseInt(value);
            if (num < 0 || num > 255) {
                return false;
            }
            // if(num==0 && value.charAt(0)!='0') return false;
        } catch (NumberFormatException exception) {
            return false;
        }

        return true;
    }

    private static boolean isIPv6(String ip) {
        if (ip.length() < 15 || ip.charAt(0) == ':' || ip.charAt(ip.length() - 1) == ':') {
            return false;
        }

        String[] values = ip.split(":");
        if (values.length != 8) {
            return false;
        }

        for (String value : values) {
            if (!isCorrectIPv6Value(value)) {
                return false;
            }
        }

        return true;
    }

    private static boolean isCorrectIPv6Value(String value) {
        if (value.length() == 0 || value.length() > 4) {
            return false;
        }

        for (int i = 0; i < value.length(); i++) {
            if (!(isCorrectDigit(value.charAt(i)) || isCorrectLetter(value.charAt(i)))) {
                return false;
            }
        }

        return true;
    }

    private static boolean isCorrectDigit(char c) {
        return c >= '0' && c <= '9';
    }

    private static boolean isCorrectLetter(char c) {
        return (c >= 'A' && c <= 'F') || (c >= 'a' && c <= 'f');
    }
}
