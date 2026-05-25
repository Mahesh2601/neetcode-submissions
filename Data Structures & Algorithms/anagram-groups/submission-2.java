class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] schars = strs[i].toCharArray();
            Arrays.sort(schars);
            String sortedChars = new String(schars);
            if (!map.containsKey(sortedChars)) {
                map.put(sortedChars, new ArrayList<>());
            } 
            map.get(sortedChars).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }
}
