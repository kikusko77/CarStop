package org.but.eloryksauthorization.rest.exceptionhandler;

import jakarta.servlet.http.HttpServletRequest;
import org.but.eloryksauthorization.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.util.UrlPathHelper;

import java.time.Clock;
import java.time.LocalDateTime;

@RestControllerAdvice
public class CustomRestExceptionHandler {

    private static final UrlPathHelper URL_PATH_HELPER = new UrlPathHelper();

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<Object> handleAll(final ResourceNotFoundException ex, final WebRequest request, HttpServletRequest req) {
        final ApiError apiError = new ApiError(LocalDateTime.now(Clock.systemUTC()), HttpStatus.NOT_FOUND, ex.getMessage(), URL_PATH_HELPER.getRequestUri(req));
        return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
    }


    /**
     * Handle all response entity.
     *
     * @param ex      the ex
     * @param request the request
     * @param req     the req
     * @return the response entity
     */
    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleAll(final Exception ex, final WebRequest request, HttpServletRequest req) {
        final ApiError apiError = new ApiError(LocalDateTime.now(Clock.systemUTC()), HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), URL_PATH_HELPER.getRequestUri(req));
        return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
    }
}
