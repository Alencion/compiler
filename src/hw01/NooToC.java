package hw01;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by eschough on 2019-09-02.
 */
public class NooToC {
    CmdExtractor cmdExtractor;
    FileWriter fw;
    String nooPgm;

    // init
    public NooToC(FileWriter fw, String nooPgm) throws IOException {
        this.fw = fw;
        this.nooPgm = nooPgm;
        this.fw.append("#include <stdio.h>\nint main() {\nint r, t1, t2, t3;\n");
        cmdExtractor = new CmdExtractor(nooPgm);
    }

    // translate cmd to C code for each case.
    public void translate(CmdExtractor.Cmds cmd) throws IOException {
        if (cmd == CmdExtractor.Cmds.CMD1) {
            translate(next());
            fw.append("printf(\"%d, r\");\n");
        }
        if (cmd == CmdExtractor.Cmds.CMD2) {
            translate(next());
            fw.append("t1 = r;\n t = t1 + 1;\n");
        }
        if (cmd == CmdExtractor.Cmds.CMD3) {
            fw.append("r = 0;\n");
        }
        if (cmd == CmdExtractor.Cmds.CMD4) {
            translate(next());
            translate(next());
        }
        if (cmd == CmdExtractor.Cmds.CMD5) {
            translate(next());
            fw.append("t1 = r;\nif (t1 != 0) { \n");
            translate(next());
            fw.append("} else {\n");
            translate(next());
            fw.append("}\n");
        }
    }

    public CmdExtractor.Cmds next() {
        if (cmdExtractor.getCmds().isEmpty())
            return null;
        return cmdExtractor.getCmds().remove(0);
    }
}
