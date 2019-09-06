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

    // Commands 을 저장 하기 위한 collection
    private ArrayList<Cmds> cmds = new ArrayList<>();

    public ArrayList<Cmds> getCmds() {
        return cmds;
    }

    public CmdExtractor(String nooPrm) { parsing(nooPrm); }

    // 정규표현식으로 pattern을 matching된 command들을 필드 cmds에 Cmds를 저장하는 메소드
    public void parsing(String nooPrm) {
        Pattern pattern = Pattern.compile("'\"+");
        Matcher matcher = pattern.matcher(nooPrm);
        while (matcher.find()) {
            cmds.add(find(matcher.group()));
        }
    }

    // pattern과 매칭하여 Cmds의 pattern을 반환
    private Cmds find(String s) {
        if (s.equals(Cmds.CMD1.matchedStr)) return Cmds.CMD1;
        if (s.equals(Cmds.CMD2.matchedStr)) return Cmds.CMD2;
        if (s.equals(Cmds.CMD3.matchedStr)) return Cmds.CMD3;
        if (s.equals(Cmds.CMD4.matchedStr)) return Cmds.CMD4;
        return Cmds.CMD5;
    }
}