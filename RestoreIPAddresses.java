package ByteDance;

import java.util.*;
public class RestoreIPAddresses {
    String sp;
    ArrayList<String> arrayList = new ArrayList<String>();
    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12) return arrayList;

        sp = s;
        dfs(s, 0, "");

        return arrayList;

    }

    public void dfs(String s, int n, String ip) {
        if (n == 4) {
            if (sp.length() == ip.length() - 4 && !arrayList.contains(ip.substring(0, ip.length() - 1)))
                arrayList.add(ip.substring(0, ip.length() - 1));
        }
        else {
            for (int i = 1; i <= 3; i ++) {
                if (s.length() >= i && Integer.parseInt(s.substring(0, i)) <= 255) {
                    String cp = ip;
                    ip = ip + s.substring(0, i) + ".";
                    dfs(s.substring(i), n + 1, ip);
                    ip = cp;
                }
            }
        }
    }
}

