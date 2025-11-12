package org.functional;

public interface Result {
    public class Success implements Result {
        private final String message = "OK";
        public String getMessage() {
            return message;
        }
    }

    public class Failure implements Result {
        private final String errorMessage;
        public Failure(String s) {
            this.errorMessage = s;
        }
        public String getMessage() {
            return errorMessage;
        }
    }
}
