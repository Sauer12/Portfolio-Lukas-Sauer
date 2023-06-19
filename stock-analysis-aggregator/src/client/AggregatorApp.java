package client;

import java.io.IOException;

import aggregators.AggregatorProcessor;
import aggregators.MaxAggregator;
import aggregators.MeanAggregator;
import aggregators.MinAggregator;
import fileprocessors.StockFileReader;

public class AggregatorApp {

	public static void main(String[] args) throws IOException {
		
		/**
			You'll need to uncomment the below code. You'll notice it does not compile!
			
			There are 2 objectives in this assignment.
			
			1).  Make sure the code compiles correctly after you uncomment it below.
			2).  Make sure it runs as explained in the assignment video!
			
			-->> YOUR WORK SHOULD BE DONE IN THE AggregatorProcessor CLASS. 
		**/

		MinAggregator agg = new MinAggregator();
		AggregatorProcessor<MinAggregator> aggsProcessor = new AggregatorProcessor<>(agg, "table.csv");
		double value = aggsProcessor.runAggregator(1);
		System.out.println(value);

		MaxAggregator agg2 = new MaxAggregator();
		AggregatorProcessor<MaxAggregator> aggsProcessor2 = new AggregatorProcessor<>(agg2, "table.csv");
		double value2 = aggsProcessor2.runAggregator(1);
		System.out.println(value2);

		MeanAggregator agg3 = new MeanAggregator();
		AggregatorProcessor<MeanAggregator> aggsProcessor3 = new AggregatorProcessor<>(agg3, "table.csv");
		double value3 = aggsProcessor3.runAggregator(1);
		System.out.println(value3);

		StockFileReader stockFileReader = new StockFileReader("table.csv");
		stockFileReader.readFileData();
	}

}
