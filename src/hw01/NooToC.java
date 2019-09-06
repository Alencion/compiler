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
        if (cmd == CmdExtractor.Cmds.CMD1) {  // 출력하라는 command일 때
            translate(next());
            fw.append("printf(\"%d, r\");\n");
        }
        if (cmd == CmdExtractor.Cmds.CMD2) {
            translate(next());
            fw.append("t1 = r;\n t = t1 + 1;\n");
        }
        if (cmd == CmdExtractor.Cmds.CMD3) {  // 리턴하는 종료 조건 결과값 r에 0을 넣고 마무리한다.
            fw.append("r = 0;\n");
            return;
        }
        if (cmd == CmdExtractor.Cmds.CMD4) {  // 종료조건 cmd3 2개가 실행되도록 하기 위해서 translate 호출을 두 번 한다.
            translate(next());
            translate(next());
        }
        if (cmd == CmdExtractor.Cmds.CMD5) {   // 비교하기전 구문, true 연산, false 연산 3개의 구문이 실행되도록 translate 호출을 3번 해주었다.
            translate(next());
            fw.append("t1 = r;\nif (t1 != 0) { \n");
            translate(next());
            fw.append("} else {\n");
            translate(next());
            fw.append("}\n");
        }
    }

    public CmdExtractor.Cmds next() { // noo 코드를 pattern으로 pattern으로 파싱하여 저장한 cmds를 하나씩 꺼내어 리턴하는 메소드
        if (cmdExtractor.getCmds().isEmpty())
            return null;
        return cmdExtractor.getCmds().remove(0);
    }
}
