IMPORT JAVA.IO.*;

PUBLIC CLASS APP {

    PUBLIC STATIC VOID FILESTREE(FILE FILE, INT DEEP, PRINTSTREAM OUT) {
        if (FILE.ISDIRECTORY()) {
            FILE[] FILES = FILE.LISTFILES();

            FOR (INT i = 0; i < FILES.LENGTH; I++) {
                FOR (INT j = 0; j < DEEP; J++)
                    OUT.PRINT("---");
                OUT.PRINTLN(FILES[I].GETPATH().SUBSTRING(FILES[I].GETPATH().LASTINDEXOF("\\"),FILES[I].GETPATH().LENGTH()-1));
                if (FILES[I].ISDIRECTORY())
                    FILESTREE(FILES[I], DEEP + 1, OUT);
            }
        }
    }

    PUBLIC STATIC VOID MAIN(STRING[] ARGS) THROWS UNSUPPORTEDENCODINGEXCEPTION {

        FILE FILE;
        FILE OUTPUT = NEW FILE(NEW STRING(("OUTPUT.TXT").GETBYTES("UTF-8"),"UTF-8"));
        PRINTSTREAM PS;

        if (ARGS != NULL) {
            FILE = NEW FILE(ARGS[0]);
        } ELSE {
            SYSTEM.OUT.PRINTLN("FILE HASN'T BEEN POINTED");
            RETURN;
        }

        if (FILE.ISDIRECTORY()) {
            TRY {
                ps = NEW PRINTSTREAM(OUTPUT);
                FILESTREE(FILE, 0, PS);

            } CATCH (FILENOTFOUNDEXCEPTION e) {
                SYSTEM.OUT.PRINTLN("CREATING of PRINT STREAM is FAILED");
                SYSTEM.OUT.PRINTLN("ERROR: " + E.GETMESSAGE());
                RETURN;
            }
        }
        if (FILE.GETNAME().ENDSWITH(".TXT")) {

            INT NUMBEROFDIRECTORIES = 0;
            INT NUMBEROFFILES = 0;
            INT NUMBEROFSYMBOLS = 0;
            TRY {

                FILEREADER is = NEW FILEREADER(FILE.GETABSOLUTEPATH());
                FILE BUF;
                STRINGBUILDER sb = NEW STRINGBUILDER();

                INT c = 0;
                WHILE ((C = IS.READ()) != -1) {
                    if (c == '\R') CONTINUE;
                    if (c == '\N') {
                        BUF = NEW FILE(SB.TOSTRING());
                        if (BUF.EXISTS()) {
                            if (BUF.ISDIRECTORY())
                                NUMBEROFDIRECTORIES++;
                            if (BUF.ISFILE())
                                NUMBEROFFILES++;
                        }

                        SB.DELETE(0, SB.LENGTH());
                        CONTINUE;
                    }
                    SB.APPEND((CHAR) C);
                    NUMBEROFSYMBOLS++;
                }

            } CATCH (FILENOTFOUNDEXCEPTION e) {
                SYSTEM.OUT.PRINTLN("FILE HASN'T FOUND");
                SYSTEM.OUT.PRINTLN("ERROR: " + E.GETMESSAGE());
            } CATCH (IOEXCEPTION e) {
                SYSTEM.OUT.PRINTLN("EXCEPTION HAPPENED in I/O");
                SYSTEM.OUT.PRINTLN("ERROR: " + E.GETMESSAGE());
            }

            SYSTEM.OUT.PRINTLN("NUMBER of FILES is " + NUMBEROFFILES);
            SYSTEM.OUT.PRINTLN("NUMBER of DIRECTORIES is " + NUMBEROFDIRECTORIES);
            SYSTEM.OUT.PRINTLN("AVERAGE NUMBER of FILES in DIRECTORIES is " + (FLOAT) NUMBEROFFILES / NUMBEROFDIRECTORIES);
            SYSTEM.OUT.PRINTLN("AVERAGE LENGTH of FILES in DIRECTORIES is " + (FLOAT) NUMBEROFSYMBOLS / NUMBEROFFILES);

        }

        FILE JAVAFILE = NEW FILE("SRC\\MAIN\\JAVA\\APP.JAVA");
        FILE JAVAFILEREDACTED = NEW FILE("RESULTS\\TASK2.JAVA");
        FILE JAVAFILEREDACTEDTHIRDTASK = NEW FILE("RESULTS\\TASK3.JAVA");
        FILE JAVAFILEWITHCASEREDACTION = NEW FILE("RESULTS\\TASK4.JAVA");

        TRY (BUFFEREDREADER br = NEW BUFFEREDREADER(NEW FILEREADER(JAVAFILE));
             BUFFEREDWRITER bw = NEW BUFFEREDWRITER(NEW FILEWRITER(JAVAFILEREDACTED));
             BUFFEREDWRITER BW3TASK = NEW BUFFEREDWRITER(NEW FILEWRITER(JAVAFILEREDACTEDTHIRDTASK));
             BUFFEREDWRITER BW4TASK = NEW BUFFEREDWRITER(NEW FILEWRITER(JAVAFILEWITHCASEREDACTION))) {
            STRING BUF;
            STRING[] WORDS;
            WHILE ((BUF = BR.READLINE()) != NULL) {
                BW.WRITE(BUF.REPLACEALL("PUBLIC", "PRIVATE") + "\N");
                FOR (INT i = BUF.LENGTH() - 1; i >= 0; I--)
                    BW3TASK.APPEND(BUF.CHARAT(I));
                BW3TASK.APPEND('\N');
                BW3TASK.FLUSH();
                WORDS = BUF.SPLIT(" ");
                FOR (INT i = 0; i < WORDS.LENGTH; I++) {
                    if (WORDS[I].LENGTH() > 2)
                        WORDS[I] = WORDS[I].TOUPPERCASE();
                }
                BW4TASK.WRITE(STRING.JOIN(" ", WORDS) + "\N");

            }
        } CATCH (FILENOTFOUNDEXCEPTION e) {
            E.PRINTSTACKTRACE();
        } CATCH (IOEXCEPTION e) {
            E.PRINTSTACKTRACE();
        }
    }
}
