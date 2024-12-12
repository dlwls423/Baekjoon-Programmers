import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = stoi(st.nextToken());
        StringBuilder sb = new StringBuilder();

        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int F = stoi(st.nextToken());
            int id = 0;
            Map<String, Integer> nameId = new HashMap<>();
            Map<Integer, String> idName = new HashMap<>();
            int[] root = new int[F*2];
            int[] friends = new int[F*2];
            for (int i = 0; i < F; i++) {
                st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();

                if(!nameId.containsKey(a)) {
                    nameId.put(a, id);
                    idName.put(id, a);
                    friends[id] = 1;
                    root[id] = id++;
                }

                if(!nameId.containsKey(b)) {
                    nameId.put(b, id);
                    idName.put(id, b);
                    friends[id] = 1;
                    root[id] = id++;
                }

                int aId = nameId.get(a);
                int bId = nameId.get(b);
                int aRootId = getRoot(aId, root);
                int bRootId = getRoot(bId, root);
                if(aRootId != bRootId) {
                    root[Math.max(aRootId, bRootId)] = Math.min(aRootId, bRootId);
                    friends[Math.min(aRootId, bRootId)] += friends[Math.max(aRootId, bRootId)];
                }

                sb.append(friends[Math.min(aRootId, bRootId)]).append("\n");
            }
        }

        System.out.print(sb);
    }

    public static int getRoot(int id, int[] root) {
        if(id == root[id]) return id;
        return root[id] = getRoot(root[id], root);
    }
}