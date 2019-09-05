package hw01;

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
    }


}
