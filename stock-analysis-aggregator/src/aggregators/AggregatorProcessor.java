package aggregators;

import fileprocessors.StockFileReader;

import java.io.IOException;
import java.nio.DoubleBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AggregatorProcessor<T extends Aggregator>{
    private StockFileReader stockFileReader;

    public T agg;

    public String file;
    public AggregatorProcessor(T agg, String file){
        this.agg = agg;
        this.file = file;
        stockFileReader = new StockFileReader(file);
    }
    public double runAggregator(int column){
        column -= 1;
        ArrayList<Double> values = loadValues(column);
        if(values.size() < 1){
            return 0;
        }

        if(agg instanceof MaxAggregator){
            for(Double d : values){
                ((MaxAggregator) agg).add(d);
            }
            return ((MaxAggregator) agg).calculate();
        }else if(agg instanceof MinAggregator){
            for(Double d : values){
                ((MinAggregator) agg).add(d);
            }
            return ((MinAggregator) agg).calculate();
        }else if(agg instanceof MeanAggregator){
            for(Double d : values){
                ((MeanAggregator) agg).add(d);
            }
            return ((MeanAggregator) agg).calculate();
        }else{
            System.out.println("Error!");
            return 0;
        }
    }

    private ArrayList<Double> loadValues(int column){
        ArrayList<Double> values = new ArrayList<>();

        try {
            List<String> lines = stockFileReader.readFileData();
            for(String s : lines){
                String[] elements = s.split(",");
                values.add(Double.parseDouble(elements[column]));
            }
        } catch (IOException e){
            System.out.println("Loading data failed!");
        }

        return values;
    }
}
