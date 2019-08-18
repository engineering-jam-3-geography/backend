package edumaps.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ConvertJson {

    public static void main(String[] args) throws IOException {


        String data = new String(Files.readAllBytes(Paths.get("F:\\projects\\edumaps\\src\\main\\data\\u.txt")));
        String[] coordinates = data.split(" ");
        List<GMapsFormat> result = new ArrayList<GMapsFormat>();
        for (String coordinate : coordinates) {
            GMapsFormat gMapsFormat = new GMapsFormat();
            String[] ll = coordinate.split(",");
            System.out.println(ll[0]);
            System.out.println(ll[1]);
            gMapsFormat.setLat(Double.valueOf(ll[0]));
            gMapsFormat.setLng(Double.valueOf(ll[1]));
            result.add(gMapsFormat);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        File resultFile = new File("F:\\projects\\edumaps\\src\\main\\data\\ukr2.txt");
        resultFile.createNewFile();
        objectMapper.writeValue(resultFile, result);
    }


}
