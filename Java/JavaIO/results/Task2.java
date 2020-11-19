import java.io.*;

private class App {

    private static void filesTree(File file, int deep, PrintStream out) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();

            for (int i = 0; i < files.length; i++) {
                for (int j = 0; j < deep; j++)
                    out.print("---");
                out.println(files[i].getPath().substring(files[i].getPath().lastIndexOf("\\"),files[i].getPath().length()-1));
                if (files[i].isDirectory())
                    filesTree(files[i], deep + 1, out);
            }
        }
    }

    private static void main(String[] args) throws UnsupportedEncodingException {

        File file;
        File output = new File(new String(("output.txt").getBytes("UTF-8"),"UTF-8"));
        PrintStream ps;

        if (args != null) {
            file = new File(args[0]);
        } else {
            System.out.println("file hasn't been pointed");
            return;
        }

        if (file.isDirectory()) {
            try {
                ps = new PrintStream(output);
                filesTree(file, 0, ps);

            } catch (FileNotFoundException e) {
                System.out.println("Creating of print stream is failed");
                System.out.println("Error: " + e.getMessage());
                return;
            }
        }
        if (file.getName().endsWith(".txt")) {

            int numberOfDirectories = 0;
            int numberOfFiles = 0;
            int numberOfSymbols = 0;
            try {

                FileReader is = new FileReader(file.getAbsolutePath());
                File buf;
                StringBuilder sb = new StringBuilder();

                int c = 0;
                while ((c = is.read()) != -1) {
                    if (c == '\r') continue;
                    if (c == '\n') {
                        buf = new File(sb.toString());
                        if (buf.exists()) {
                            if (buf.isDirectory())
                                numberOfDirectories++;
                            if (buf.isFile())
                                numberOfFiles++;
                        }

                        sb.delete(0, sb.length());
                        continue;
                    }
                    sb.append((char) c);
                    numberOfSymbols++;
                }

            } catch (FileNotFoundException e) {
                System.out.println("File hasn't found");
                System.out.println("Error: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("Exception happened in I/O");
                System.out.println("Error: " + e.getMessage());
            }

            System.out.println("Number of files is " + numberOfFiles);
            System.out.println("Number of directories is " + numberOfDirectories);
            System.out.println("Average number of files in directories is " + (float) numberOfFiles / numberOfDirectories);
            System.out.println("Average length of files in directories is " + (float) numberOfSymbols / numberOfFiles);

        }

        File javaFile = new File("src\\main\\java\\App.java");
        File javaFileRedacted = new File("results\\Task2.java");
        File javaFileRedactedThirdTask = new File("results\\Task3.java");
        File javaFileWithCaseRedaction = new File("results\\Task4.java");

        try (BufferedReader br = new BufferedReader(new FileReader(javaFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(javaFileRedacted));
             BufferedWriter bw3Task = new BufferedWriter(new FileWriter(javaFileRedactedThirdTask));
             BufferedWriter bw4Task = new BufferedWriter(new FileWriter(javaFileWithCaseRedaction))) {
            String buf;
            String[] words;
            while ((buf = br.readLine()) != null) {
                bw.write(buf.replaceAll("private", "private") + "\n");
                for (int i = buf.length() - 1; i >= 0; i--)
                    bw3Task.append(buf.charAt(i));
                bw3Task.append('\n');
                bw3Task.flush();
                words = buf.split(" ");
                for (int i = 0; i < words.length; i++) {
                    if (words[i].length() > 2)
                        words[i] = words[i].toUpperCase();
                }
                bw4Task.write(String.join(" ", words) + "\n");

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
