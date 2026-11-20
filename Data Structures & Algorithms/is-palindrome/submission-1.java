class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char cLeft = s.charAt(left);
            char cRight = s.charAt(right);

            if (!isAlphanumeric(cLeft)) {
                left++;
            } else if (!isAlphanumeric(cRight)) {
                right--;
            } else {
                if (toLower(cLeft) != toLower(cRight)) {
                    return false;
                }
                left++;
                right--;
            }
        }

        return true;
    }

    private boolean isAlphanumeric(char c) {
        return (c >= 'a' && c <= 'z') || 
               (c >= 'A' && c <= 'Z') || 
               (c >= '0' && c <= '9');
    }

    private char toLower(char c) {
        if (c >= 'A' && c <= 'Z') {
            return (char) (c + 32); // Shift uppercase ASCII to lowercase
        }
        return c;
    }
}
