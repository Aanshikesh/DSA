
class Solution {
    int[] parent;

    int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px != py) {
            parent[py] = px;
        }
    }

    public List<List<String>> accountsMerge(
        List<List<String>> accounts) {

        int n = accounts.size();
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);

                if (map.containsKey(email)) {
                    union(i, map.get(email));
                } else {
                    map.put(email, i);
                }
            }
        }

        HashMap<Integer, TreeSet<String>> merged = new HashMap<>();

        for (String email : map.keySet()) {
            int root = find(map.get(email));

            merged.putIfAbsent(root, new TreeSet<>());
            merged.get(root).add(email);
        }

        List<List<String>> ans = new ArrayList<>();

        for (int root : merged.keySet()) {
            List<String> list = new ArrayList<>();
            list.add(accounts.get(root).get(0));
            list.addAll(merged.get(root));
            ans.add(list);
        }

        return ans;
    }
}
