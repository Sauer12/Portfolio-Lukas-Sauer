package fileprocessors;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StockFileReader {

	String filePath = null;

	public StockFileReader(String filePath){
		this.filePath = filePath;
	}

	public List<String> getHeaders() throws IOException{
		String line = readFirstLine(filePath);
		String [] header = line.split(",");
		List<String> values = new ArrayList<>();
		values = Arrays.asList(header);
		return values;
	}

	static String readFirstLine(String path) throws IOException {
		try (BufferedReader br =
					 new BufferedReader(new FileReader(path))) {
			return br.readLine();
		}
	}

	/**
	 * Complete the body of this method.
	 * @return List
	 * @throws IOException
	 */
	public List<String> readFileData() throws IOException{
		List<String> lines = new ArrayList<>();
		File file = new File("table.csv");
		BufferedReader bufferedReader = null;
		FileReader fileReader = null;
		try{
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);

			bufferedReader.readLine();
			String line = bufferedReader.readLine();

			while(line != null){
				lines.add(line);
				line = bufferedReader.readLine();
			}
			bufferedReader.close();
		} catch (IOException e){
			System.out.println("Error!");
		}

		return lines;
	}
}
