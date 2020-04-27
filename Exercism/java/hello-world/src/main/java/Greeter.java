class Greeter {

    String getGreeting() {
        try {
            return("Hello, World!");
        } catch(Exception e) {
            throw new UnsupportedOperationException("Err");
        }
    }

}
