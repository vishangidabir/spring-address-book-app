package com.example.addressbookapp.exception;

import com.example.addressbookapp.dto.ResposeDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ResposeDTO> addressBookException(CustomException exeception) {
        ResposeDTO responseDTO = new ResposeDTO("Address Book Exception! ", exeception.getMessage());
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }
}
