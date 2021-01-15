import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadTextFile {
    public static void main(String[] args) {
        List<int[]> numbers = readFile();
        int[][] sortedArray = sort(numbers);
        print(sortedArray);
    }

    public static List<int[]> readFile() {
        List<int[]> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/numbers.csv",StandardCharsets.US_ASCII))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if(values[0].length() > 1){
                    values[0] = values[0].substring(values[0].length() - 1);
                }

                int[] nums = new int[2];
                nums[0] = Integer.parseInt(values[0].trim());
                nums[1] = Integer.parseInt(values[1].trim());
                records.add(nums);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }

    public static int[][] sort(List<int[]> numbers){

        int[][] intArray = new int[numbers.size()][2];

        for(int i=0; i<numbers.size(); i++){
            intArray[i][0] = numbers.get(i)[0];
            intArray[i][1] = numbers.get(i)[1];
        }

        Arrays.sort(intArray, (o1, o2) -> {
            if(o1[0] == o2[0]){
                return Integer.compare(o1[1],o2[1]);
            } else {
                return Integer.compare(o1[0],o2[0]);
            }
        });
        return intArray;
    }

    public static void print(int[][] numbers){
        System.out.println(Arrays.deepToString(numbers));
    }
}
