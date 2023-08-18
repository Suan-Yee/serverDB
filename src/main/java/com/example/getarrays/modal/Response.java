package com.example.getarrays.modal;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {
    protected LocalDateTime timeStamp;
    protected int statusCode;
    protected HttpStatus status;
    protected String reason;
    protected String message;
    protected String developerMessage;
    protected Map<?,?> data;

   /* "timeStamp": "2023-08-18T21:32:02.3697604",
            "statusCode": 200,
            "status": "OK",
            "message": "Servers retrieved",
            "data": {
        "server": [
        {
            "id": 1,
                "ipAddress": "192.168.1.160",
                "name": "Ubuntu Linux",
                "memory": "16 GB",
                "type": "Personal PC",
                "imageUrl": "http://localhost:8080/server/image/server1.png",
                "status": "SERVER_UP"
        },*/
}
