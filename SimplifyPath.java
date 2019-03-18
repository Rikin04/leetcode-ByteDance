package ByteDance;

public class SimplifyPath {

    public String simplifyPath(String path) {
        while(path.indexOf("//") != -1)
            path = path.replaceAll("//", "/");

        String[] strings = path.split("/");

        int index = 0;

        String[] onlyWord = new String[strings.length];
        for (int i = 1; i < strings.length; i ++) {
            if (strings[i].equals(".")){}
            else if (strings[i].equals("..")) {
                if (index == 0);
                else -- index;
            }
            else {
                onlyWord[index] = strings[i];
                ++ index;
            }
        }

        if (index ==  0) return "/";

        String pathString = "";


        -- index;
        while (index >= 0) {
            pathString = "/" + onlyWord[index] + pathString;
            -- index;
        }

        return pathString;
    }

}