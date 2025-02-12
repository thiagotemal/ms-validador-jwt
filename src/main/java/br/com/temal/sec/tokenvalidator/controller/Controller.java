package br.com.temal.sec.tokenvalidator.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.temal.sec.tokenvalidator.model.TokenJWT;
import br.com.temal.sec.tokenvalidator.service.ValidateJWTService;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.context.Scope;

/**
 * 
 */
@RestController
@RequestMapping("/v1/jwt-tokens/valid")
public class Controller {
    private static final Logger logger = LoggerFactory.getLogger(Controller.class);
    private final ValidateJWTService validateJWTServiceImpl;
    private final Tracer tracer;

    public Controller(ValidateJWTService validateJWTService, Tracer tracer) {
        this.validateJWTServiceImpl = validateJWTService;
        this.tracer = tracer;
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(value = HttpStatus.OK, code = HttpStatus.OK)
    public ResponseEntity<Boolean> validateJWT(@RequestHeader(value = "Authorization", required = true) String authorization) {
        Span currentSpan = tracer.spanBuilder("validateJWT").startSpan();
        
        try (Scope scope = currentSpan.makeCurrent()) {
            logger.info("Received token validation request. Trace ID: {}", 
                currentSpan.getSpanContext().getTraceId());

            // Add custom attributes to the span
            currentSpan.setAttribute("token.length", authorization.length());

            // Your existing token validation logic
            boolean isValid = validateJWTServiceImpl.isValid(new TokenJWT(authorization));

            logger.info("Token validation completed successfully");
            currentSpan.setStatus(io.opentelemetry.api.trace.StatusCode.OK);

            return ResponseEntity.ok().body(isValid);
        } catch (Exception e) {
            // Log error with span context
            logger.error("Token validation failed. Trace ID: {}", 
                currentSpan.getSpanContext().getTraceId(), e);
            
            // Mark the span as failed
            currentSpan.setStatus(io.opentelemetry.api.trace.StatusCode.ERROR);
            currentSpan.recordException(e);

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        } finally {
            currentSpan.end();
        }
    }
}
