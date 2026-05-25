class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] schars = strs[i].toCharArray();
            Arrays.sort(schars);
            String sortedChars = String.valueOf(schars);
            if (map.containsKey(sortedChars)) {
                map.get(sortedChars).add(strs[i]);
            } else {
                map.put(sortedChars, new ArrayList<>(List.of(strs[i])));
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (List<String> e: map.values()) {
            res.add(e);
        }
        return res;
    }
}
