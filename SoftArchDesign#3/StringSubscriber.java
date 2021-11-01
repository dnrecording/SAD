import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.Flow;

public abstract class StringSubscriber implements Flow.Subscriber {

	private String subscriberType;
	private String subscriberName;
	private String wordTemp;

	public StringSubscriber(){};

	public StringSubscriber(String subType, String subName){
		this.subscriberType = subType;
		this.subscriberName = subName;
		//init Text file
		try {
			File myObj = new File(this.subscriberName +".txt");
			if (myObj.createNewFile()) {
			  System.out.println("File created: " + myObj.getName());
			} else {
			  System.out.println("File already exists.");
			  wordTemp = new String(Files.readAllBytes(Path.of(this.subscriberName+".txt")));
			}
		  } catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		  }
	}

	public void writeFile(String word){
		try {
			FileWriter myWriter = new FileWriter(this.subscriberName + ".txt");
			myWriter.write(wordTemp + word + "\n");
			myWriter.close();
			this.onComplete();
		  } catch (IOException e) {
			System.out.println("An error occurred.");
			this.onError(e);
		  }
		}

	public abstract boolean subTypeSeperator(String textInput);

	public abstract void onSubscribe(Flow.Subscription subscription);

	public abstract void onNext(String item);

	@Override
	public void onComplete() {
		System.out.println("Complete!");
	}

	@Override
	public void onError(Throwable t) {
		t.printStackTrace();
	}

	
}
