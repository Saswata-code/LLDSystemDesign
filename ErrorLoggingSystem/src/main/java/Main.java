public class Main {

    public static void main(String[] args){

        LogProcessor logProcessor = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));

        logProcessor.log(3,"ERROR");
        logProcessor.log(2,"DEBUG");
        logProcessor.log(1,"INFO");
    }
}
