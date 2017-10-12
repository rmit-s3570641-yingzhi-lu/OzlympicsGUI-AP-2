class selectOptionException extends Exception {

    selectOptionException(String message) {
        super(message);
        System.out.println("Please input right choice number");
    }
}
