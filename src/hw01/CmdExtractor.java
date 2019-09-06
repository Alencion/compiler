package hw01;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Created by eschough on 2019-09-02.
 */

// find command pattern from input, and convert it to cmd
// CmdExtractor는 input으로부터 CMD pattern을 찾아 parsing
public class CmdExtractor {
    public enum Cmds {
        // pattern
        CMD1("'\""),
        CMD2("'\"\""),
        CMD3("'\"\"\""),
        CMD4("'\"\"\"\""),
        CMD5("'\"\"\"\"\"");

        String matchedStr;

        Cmds(String matchedStr) {
            this.matchedStr = matchedStr;
        }

        @Override
        public String toString() {
            return this.matchedStr;
        }
    }

    private ArrayList<Cmds> cmds = new ArrayList<>();

    public ArrayList<Cmds> getCmds() {
        return cmds;
    }
    public CmdExtractor(String nooPrm){
        parsing(nooPrm);
    }

    public void parsing(String nooPrm){
        Pattern pattern = Pattern.compile("'\"+");
        Matcher matcher = pattern.matcher(nooPrm);
        while(matcher.find()){
            cmds.add(find(matcher.group()));
        }
    }

    private Cmds find(String s){
        if (s.equals(Cmds.CMD1.matchedStr)) return Cmds.CMD1;
        if (s.equals(Cmds.CMD2.matchedStr)) return Cmds.CMD2;
        if (s.equals(Cmds.CMD3.matchedStr)) return Cmds.CMD3;
        if (s.equals(Cmds.CMD4.matchedStr)) return Cmds.CMD4;
        return Cmds.CMD5;
    }


}