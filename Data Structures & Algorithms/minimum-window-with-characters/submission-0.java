class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";

        int[] targetFreq = new int[128];
        int[] windowFreq = new int[128];

        int required = 0;

        for (char ch : t.toCharArray()) {
            if (targetFreq[ch] == 0)
                required++;
            targetFreq[ch]++;
        }

        int formed = 0;

        int left = 0;

        int minLength = Integer.MAX_VALUE;
        int startIndex = 0;

        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);

            windowFreq[c]++;

            if (targetFreq[c] > 0 &&
                windowFreq[c] == targetFreq[c]) {

                formed++;
            }

            while (formed == required) {

                if (right - left + 1 < minLength) {

                    minLength = right - left + 1;
                    startIndex = left;
                }

                char leftChar = s.charAt(left);

                windowFreq[leftChar]--;

                if (targetFreq[leftChar] > 0 &&
                    windowFreq[leftChar] < targetFreq[leftChar]) {

                    formed--;
                }

                left++;
            }
        }

        return minLength == Integer.MAX_VALUE
                ? ""
                : s.substring(startIndex,
                              startIndex + minLength);
    }
}

