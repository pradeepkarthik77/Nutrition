package com.example.nutrition;
import com.opencsv.CSVReader;
import java.io.InputStreamReader;

public class ReadNutritioncsv
{
    public String[] nutrition_topics;
    public String[] nutrtion_data;
    protected CSVReader csvReader;

    public ReadNutritioncsv()
    {
        nutrition_topics = new String[]{};
        nutrtion_data = new String[]{};
    }

    public void setValues(InputStreamReader inputStreamReader)
    {
        csvReader = new CSVReader(inputStreamReader);
    }

    public String[] read_topics() throws Exception
    {
        String[] nextreader;
        nextreader = csvReader.readNext();
        if(nextreader !=null)
        {
            nutrition_topics = nextreader;
            return nutrition_topics;
        }
        return null;
    }

    public String[] read_values(String item_id) throws Exception
    {
        String[] nextreader;

        while((nextreader = csvReader.readNext()) != null)
        {
            if(nextreader[0].equals(item_id))
            {
                nutrtion_data = nextreader;
                return nutrtion_data;
            }
        }

        return new String[]{};
    }
}
