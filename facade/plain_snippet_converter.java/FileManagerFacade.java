import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class FileManagerFacade {
  public File createFileWithPath(String filePath) {
    File file = new File(filePath);

    return file;
  }

  public void writeToFileWithPath(String filePath, String fileContent) throws IOException {
    FileWriter outputFileWriter = new FileWriter(filePath);
    outputFileWriter.write(fileContent);
    outputFileWriter.close();
  }
}
