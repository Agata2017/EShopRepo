package core;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JSONDataProvider implements ITestData{

    private Reader reader;
    private Gson gson;

    public JSONDataProvider (String filePath) throws Exception {
        reader = new FileReader(filePath);
        gson = new Gson();
    }

    @Override
    public List<HashMap<String, String>> getAllData(String testName) {
        Type type = new TypeToken<HashMap<String, ArrayList<HashMap>>>(){}.getType();
        HashMap<String, ArrayList<HashMap>> testData = gson.fromJson(reader, type);
        ArrayList<HashMap> testDataList = testData.get("testdata");
        for(HashMap test :  testDataList){
            if(test.get("testname").equals(testName)){
                return (List<HashMap<String, String>>) test.get("iteration");
            }
        }
        return null;
    }
}
