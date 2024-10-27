package org.but.eloryksauthorization.newbackend.exceptions;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import jakarta.servlet.http.HttpServletRequest;
import org.but.eloryksauthorization.newbackend.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.format.DateTimeParseException;
import java.util.Collections;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private HttpServletRequest request;

    @ExceptionHandler(UserExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public ErrorResponse handleUserExistsException(UserExistsException ex) {
        return new ErrorResponse(ex.getMessage(), HttpStatus.CONFLICT.value());
    }

    @ExceptionHandler(EmailAlreadyInUseException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public ErrorResponse handleEmailAlreadyInUseException(EmailAlreadyInUseException ex) {
        return new ErrorResponse("Email already in use", HttpStatus.CONFLICT.value());
    }

    @ExceptionHandler(VehicleAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponsePostDeleteDTO handleVehicleAlreadyExistsException(VehicleAlreadyExistsException ex) {
        return createErrorResponse(ex.getMessage(), 400);
    }

    @ExceptionHandler(VehicleNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ResponsePostDeleteDTO handleVehicleNotFoundException(VehicleNotFoundException ex) {
        return createErrorResponse(ex.getMessage(), 404);
    }

    @ExceptionHandler(VehicleNotFoundPutException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ResponsePutDTO handleVehiclePutNotFoundException(VehicleNotFoundPutException ex) {
        return createErrorPutResponse(ex.getMessage(), 400);
    }

    @ExceptionHandler(DateTimeParseException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponsePostDeleteDTO handleDateTimeParseException(DateTimeParseException ex) {
        String errorMsg = "Invalid timestamp format. Expected format: yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
        return createErrorResponse(errorMsg, 400);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Object handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        String errorMsg = ex.getBindingResult()
                .getAllErrors().stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.joining(", "));

        if ("POST".equalsIgnoreCase(request.getMethod())) {
            ResponsePostDeleteDTO response = new ResponsePostDeleteDTO();
            ResponseStatusDTO responseStatus = new ResponseStatusDTO();
            responseStatus.setErrorCode(400);
            responseStatus.setMessage(errorMsg);

            ResponseCreateDeleteDTO responseVehicleDTO = new ResponseCreateDeleteDTO();
            responseVehicleDTO.setErrorCode(400);
            responseVehicleDTO.setMessage(errorMsg);

            response.setResponseStatus(responseStatus);
            response.setResponseVehicle(Collections.singletonList(responseVehicleDTO));
            return response;

        } else if ("PUT".equalsIgnoreCase(request.getMethod())) {
            ResponsePutDTO putResponse = new ResponsePutDTO();
            ResponseStatusDTO responseStatus = new ResponseStatusDTO();
            responseStatus.setErrorCode(400);
            responseStatus.setMessage(errorMsg);

            ResponseUpdateDTO responseUpdateDTO = new ResponseUpdateDTO();
            responseUpdateDTO.setErrorCode(400);
            responseStatus.setMessage(errorMsg);

            putResponse.setResponseStatus(responseStatus);
            putResponse.setResponseVehicle(Collections.singletonList(responseUpdateDTO));
            return putResponse;
        }

        return Collections.singletonMap("error", errorMsg);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Object handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        Throwable cause = ex.getCause();
        String errorMsg;

        if (cause instanceof JsonMappingException) {
            JsonMappingException jme = (JsonMappingException) cause;
            String fieldPath = jme.getPath().stream()
                    .map(ref -> ref.getFieldName())
                    .collect(Collectors.joining("."));
            errorMsg = "Incorrect data type or structure for field '" + fieldPath + "'.";

        } else if (cause instanceof JsonParseException) {
            JsonParseException jpe = (JsonParseException) cause;
            if (jpe.getCause() instanceof DateTimeParseException) {
                errorMsg = "Invalid timestamp format. Expected format: yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
            } else {
                errorMsg = "JSON syntax error: " + jpe.getOriginalMessage();
            }

        } else {
            errorMsg = "Request JSON is malformed or contains incorrect data types.";
        }

        if ("POST".equalsIgnoreCase(request.getMethod())) {
            ResponsePostDeleteDTO response = new ResponsePostDeleteDTO();
            ResponseStatusDTO responseStatus = new ResponseStatusDTO();
            responseStatus.setErrorCode(1);
            responseStatus.setMessage(errorMsg);

            ResponseCreateDeleteDTO responseVehicleDTO = new ResponseCreateDeleteDTO();
            responseVehicleDTO.setErrorCode(1);
            responseVehicleDTO.setMessage(errorMsg);

            response.setResponseStatus(responseStatus);
            response.setResponseVehicle(Collections.singletonList(responseVehicleDTO));
            return response;

        } else if ("PUT".equalsIgnoreCase(request.getMethod())) {
            ResponsePutDTO putResponse = new ResponsePutDTO();
            ResponseStatusDTO responseStatus = new ResponseStatusDTO();
            responseStatus.setErrorCode(1);
            responseStatus.setMessage(errorMsg);

            ResponseUpdateDTO responseUpdateDTO = new ResponseUpdateDTO();
            responseUpdateDTO.setErrorCode(1);
            responseUpdateDTO.setMessage(errorMsg);

            putResponse.setResponseStatus(responseStatus);
            putResponse.setResponseVehicle(Collections.singletonList(responseUpdateDTO));
            return putResponse;

        } else {
            return Collections.singletonMap("error", errorMsg);
        }
    }

    private ResponsePostDeleteDTO createErrorResponse(String message, int errorCode) {
        ResponsePostDeleteDTO response = new ResponsePostDeleteDTO();
        ResponseStatusDTO responseStatus = new ResponseStatusDTO();
        responseStatus.setErrorCode(errorCode);
        responseStatus.setMessage(message);

        ResponseCreateDeleteDTO responseVehicleDTO = new ResponseCreateDeleteDTO();
        responseVehicleDTO.setErrorCode(errorCode);
        responseVehicleDTO.setMessage(message);

        response.setResponseStatus(responseStatus);
        response.setResponseVehicle(Collections.singletonList(responseVehicleDTO));
        return response;
    }

    private ResponsePutDTO createErrorPutResponse(String message, int errorCode) {
        ResponsePutDTO putResponse = new ResponsePutDTO();
        ResponseStatusDTO responseStatus = new ResponseStatusDTO();
        responseStatus.setErrorCode(errorCode);
        responseStatus.setMessage(message);

        ResponseUpdateDTO responseUpdateDTO = new ResponseUpdateDTO();
        responseUpdateDTO.setErrorCode(errorCode);
        responseStatus.setMessage(message);

        putResponse.setResponseStatus(responseStatus);
        putResponse.setResponseVehicle(Collections.singletonList(responseUpdateDTO));
        return putResponse;
    }
}
