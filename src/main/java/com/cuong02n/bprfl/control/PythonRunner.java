package com.cuong02n.bprfl.control;
import java.io.*;

public final class PythonRunner {
    private static PythonRunner ins = null;

    public static PythonRunner instance() {
        if (ins == null) {
            ins = new PythonRunner("src/main/java/com/cuong02n/bprfl/control/python_multinomialNB.py", "test_", 2);
        }
        return ins;
    }

    ProcessBuilder processBuilder;
    Process process;
    BufferedWriter writer;
    BufferedReader reader;

    void runPythonFile(String pathFile, String prefixFileData, int chapters) throws Exception {
        processBuilder = new ProcessBuilder("python", pathFile, prefixFileData, Integer.toString(chapters));
        processBuilder.redirectErrorStream(true);
        process = processBuilder.start();
        reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
    }

    public String query(String... datas) throws Exception {
        for (String data : datas) {
            writer.write(data);
            writer.newLine();
            writer.flush();
        }
        return reader.readLine();
    }

    public PythonRunner(String pathFile, String prefixFileData, int chapters) {
        try {
            runPythonFile(pathFile, prefixFileData, chapters);
            Runtime.getRuntime().addShutdownHook(new Thread(() -> process.destroy()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
