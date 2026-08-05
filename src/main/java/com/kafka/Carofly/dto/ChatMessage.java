//WID(5/8/2026)(Sarthak Mittal)(DegamieSign)
package com.kafka.Carofly.dto;

import java.text.DateFormat;

public class ChatMessage {
    public DateFormat recieveddate;
        private String clientId;
        private String sessionId;
        private String message;
        private long timestamp;

        // getters, setters, no-arg constructor
        public ChatMessage() {}

        public ChatMessage(String clientId, String sessionId, String message, long timestamp) {
            this.clientId = clientId;
            this.sessionId = sessionId;
            this.message = message;
            this.timestamp = timestamp;
        }

        public String getClientId() { return clientId; }
        public void setClientId(String clientId) { this.clientId = clientId; }

        public String getSessionId() { return sessionId; }
        public void setSessionId(String sessionId) { this.sessionId = sessionId; }

        public String getMessage() { return message; }
        public void setMessage(String message) { this.message = message; }

        public long getTimestamp() { return timestamp; }
        public void setTimestamp(long timestamp) { this.timestamp = timestamp; }
    }
}
