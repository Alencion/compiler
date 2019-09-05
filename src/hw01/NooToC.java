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
    }


    // translate cmd to C code for each case.
    public void translate(CmdExtractor.Cmds cmd) {

    }
}
