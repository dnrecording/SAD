public class Main{
    public static void main(String[] args) {
        StringPublisher publisher = new StringPublisher();
        AlphabetSubscriber alpha = new AlphabetSubscriber("alph");
        NumberSubscriber numb = new NumberSubscriber("numb");
        SymbolSubscriber symb = new SymbolSubscriber("symb");

        publisher.addSub(alpha);
        publisher.addSub(numb);
        publisher.addSub(symb);

        // publisher.publish("test");
        // publisher.publish("123");
        // publisher.publish("!@#");

        publisher.publish("test123");
        publisher.publish("123!@#");
        publisher.publish("test!@#");


    }
}