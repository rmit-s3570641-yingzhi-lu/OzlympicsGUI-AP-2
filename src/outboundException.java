class outboundException extends Exception {

    outboundException(String message) {
        super(message);
        System.out.println(message);
    }
}
